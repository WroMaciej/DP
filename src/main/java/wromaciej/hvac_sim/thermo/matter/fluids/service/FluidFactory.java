package wromaciej.hvac_sim.thermo.matter.fluids.service;

import wromaciej.hvac_sim.thermo.matter.fluids.model.Air;
import wromaciej.hvac_sim.thermo.matter.fluids.model.Fluid;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.*;
import wromaciej.hvac_sim.thermo.quantities.base.AirQuantity;
import wromaciej.hvac_sim.thermo.quantities.specific.Pressure;
import wromaciej.hvac_sim.thermo.unitSystems.UnitSystem;

public final class FluidFactory {

    public static Fluid createFluid(FluidName fluidName, FluidParameter parameter1, FluidParameter parameter2) {

        Fluid fluid = new Fluid();
        if (fluidName != FluidName.MOIST_AIR) {
            fluid.setFluidName(fluidName);

        }
        else fluid= createAir(parameter1,  parameter2);

        return fluid;
    }

    public static Air createAir(FluidParameter<? extends AirQuantity> parameter1, FluidParameter<? extends AirQuantity> parameter2){
        return createAir(parameter1, parameter2, UnitSystem.getActualUnitSystem().getAtmosphericPressure());
    }

    public static Air createAir(FluidParameter<? extends AirQuantity> parameter1, FluidParameter<? extends AirQuantity> parameter2, FluidParameter<? extends AirQuantity> parameter3){
        Air air= new Air();
        air.setFluidName(FluidName.MOIST_AIR);


        return air;
    }
}
