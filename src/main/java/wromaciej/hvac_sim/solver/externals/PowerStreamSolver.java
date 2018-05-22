package wromaciej.hvac_sim.solver.externals;

import org.springframework.stereotype.Service;
import wromaciej.hvac_sim.solver.result.SolverResult;
import wromaciej.hvac_sim.solver.result.SolverResultType;
import wromaciej.hvac_sim.thermo.streams.model.HeatStream;
import wromaciej.hvac_sim.thermo.streams.model.PowerStream;

@Service
public class PowerStreamSolver implements ExternalSolver<PowerStream>  {

    @Override
    public SolverResult solve(PowerStream toSolve) {
        return new SolverResult(null, SolverResultType.SOLVED);
    }

}