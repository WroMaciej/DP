package wromaciej.hvac_sim.simulation.thermo.streams.model;

import wromaciej.hvac_sim.ids.IdGenerator;
import wromaciej.hvac_sim.simulation.solver.result.SolverResult;
import wromaciej.hvac_sim.simulation.thermo.generals.bonds.InletStreamBond;
import wromaciej.hvac_sim.simulation.thermo.generals.bonds.OutletStreamBond;
import wromaciej.hvac_sim.simulation.thermo.parameters.Parameter;
import wromaciej.hvac_sim.simulation.thermo.quantities.extensive.HeatFlow;

public final class HeatStream extends AnyStream {
    private Parameter<HeatFlow> heatFlow;
    public final InletStreamBond<HeatStream> inletStreamBond;
    public final OutletStreamBond<HeatStream> outletStreamBond;



    public HeatStream(int id, IdGenerator idGenerator, Parameter<HeatFlow> heatFlow, InletStreamBond<HeatStream> inletStreamBond, OutletStreamBond<HeatStream> outletStreamBond) {
        super(id, idGenerator, inletStreamBond, outletStreamBond);
        this.heatFlow = heatFlow;
        this.inletStreamBond = inletStreamBond;
        this.outletStreamBond = outletStreamBond;
        this.inletStreamBond.setOwnerItem(this);
        this.outletStreamBond.setOwnerItem(this);
    }

    public Parameter<HeatFlow> getHeatFlow() {
        return heatFlow;
    }


    @Override
    public String display() {
        return null;
    }


    @Override
    public SolverResult solve() {
        return null;
    }
}
