package wromaciej.hvac_sim.simulation.solver.externals;

import org.springframework.stereotype.Service;
import wromaciej.hvac_sim.simulation.solver.result.SolverResult;
import wromaciej.hvac_sim.simulation.solver.result.SolverResultType;
import wromaciej.hvac_sim.simulation.thermo.generals.bonds.BondDirection;
import wromaciej.hvac_sim.simulation.thermo.generals.conservationLaw.Junction;
import wromaciej.hvac_sim.simulation.thermo.generals.conservationLaw.ParameterWithDirection;
import wromaciej.hvac_sim.simulation.thermo.parameters.Parameter;

import java.util.ArrayList;
import java.util.List;

@Service
public class JunctionSolver implements ExternalSolver<Junction> {


    public List<ParameterWithDirection> getAllParameters(Junction toSolve) {
        return toSolve.getAllParameters();
    }

    public List<ParameterWithDirection> getUndefinedParameters(Junction toSolve) {
        List<ParameterWithDirection> undefinedParameters = new ArrayList<>();
        for (ParameterWithDirection parameterWithDirection : getAllParameters(toSolve)) {
            if (!parameterWithDirection.getParameter().isDefined()) undefinedParameters.add(parameterWithDirection);
        }

        return undefinedParameters;
    }

    public List<ParameterWithDirection> getDefinedParameters(Junction toSolve) {
        List<ParameterWithDirection> definedParameters = new ArrayList<>();
        for (ParameterWithDirection parameterWithDirection : getAllParameters(toSolve)) {
            if (parameterWithDirection.getParameter().isDefined()) definedParameters.add(parameterWithDirection);
        }
        return definedParameters;
    }

    private int allParametersNumber(Junction toSolve){
        return getAllParameters(toSolve).size();
    }

    private int definedParametersNumber(Junction toSolve){
        return getDefinedParameters(toSolve).size();
    }
    private int undefinedParametersNumber(Junction toSolve){
        return getUndefinedParameters(toSolve).size();
    }




    public ParameterWithDirection getBalance(Junction toSolve){

        Parameter sum = new Parameter();
        ParameterWithDirection resultingParameterWithDirection;
        for (ParameterWithDirection parameterWithDirection : getDefinedParameters(toSolve)){
            if (!sum.isDefined()) sum=parameterWithDirection.getParameter().times(parameterWithDirection.getDirection().balanceMultiplyer);
            else sum = sum.plus(parameterWithDirection.getParameter().times(parameterWithDirection.getDirection().balanceMultiplyer));
        }


        if (sum.isPositive()) resultingParameterWithDirection = new ParameterWithDirection(sum.abs(), BondDirection.OUTLET);
        else resultingParameterWithDirection = new ParameterWithDirection(sum.abs(), BondDirection.INLET);

        return resultingParameterWithDirection;
    }



    @Override
    public SolverResult solve(Junction toSolve) {
        SolverResultType solverResultType;
        List<ParameterWithDirection> undefinedParameters = getUndefinedParameters(toSolve);

        if (undefinedParametersNumber(toSolve)>1) solverResultType = SolverResultType.NOT_SOLVED_NODATA;
        else if (undefinedParametersNumber(toSolve)<1) solverResultType = SolverResultType.NOT_SOLVED_TOO_MUCH_DATA;
        else{
            //undefinedParameters.get(0).setParameter(getBalance(toSolve).getParameter());
            ParameterWithDirection junctionBalance = getBalance(toSolve);
            undefinedParameters.get(0).getParameter().calculate(junctionBalance.getParameter());
            undefinedParameters.get(0).setDirection(junctionBalance.getDirection());
            solverResultType = SolverResultType.SOLVED;
        }
        return new SolverResult(null, solverResultType);
    }
}
