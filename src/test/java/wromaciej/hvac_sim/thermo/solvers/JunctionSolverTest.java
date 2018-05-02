package wromaciej.hvac_sim.thermo.solvers;

import org.junit.Test;
import wromaciej.hvac_sim.solver.externals.JunctionSolver;
import wromaciej.hvac_sim.thermo.generals.bonds.BondDirection;
import wromaciej.hvac_sim.thermo.generals.bonds.Junction;
import wromaciej.hvac_sim.thermo.generals.bonds.ParameterWithDirection;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.quantities.extensive.MassFlow;

import javax.measure.unit.SI;
import java.util.ArrayList;
import java.util.List;

public class JunctionSolverTest {

    @Test
    public void shouldReturnExtraMassFlowForGivenInletAndOutlet(){
        //GIVEN
        JunctionSolver junctionSolver = new JunctionSolver();
        List<ParameterWithDirection> parametersWithDirections = new ArrayList<>();
        Parameter<MassFlow> inletMassFlow = new Parameter<MassFlow>(SI.KILOGRAM.divide(SI.SECOND).asType(MassFlow.class),100.0);
        Parameter<MassFlow> outletMassFlow = new Parameter<MassFlow>(SI.KILOGRAM.divide(SI.SECOND).asType(MassFlow.class),200.0);
        Parameter<MassFlow> extraMassFlow = new Parameter<MassFlow>(SI.KILOGRAM.divide(SI.SECOND).asType(MassFlow.class));

        parametersWithDirections.add(new ParameterWithDirection(inletMassFlow, BondDirection.INLET));
        parametersWithDirections.add(new ParameterWithDirection(outletMassFlow, BondDirection.OUTLET));
        parametersWithDirections.add(new ParameterWithDirection(extraMassFlow, BondDirection.OUTLET));
        Junction junction = new Junction(parametersWithDirections, junctionSolver);

        //WHEN
        junction.solve();

        System.out.println(junction.getAllParameters().get(0).getParameter());
        System.out.println(junction.getAllParameters().get(1).getParameter());
        System.out.println(junction.getAllParameters().get(2).getParameter());
    }
}
