package wromaciej.hvac_sim.thermo.quantities.specific;

import wromaciej.hvac_sim.thermo.quantities.base.FluidQuantity;

import javax.measure.quantity.Dimensionless;
import javax.measure.unit.ProductUnit;
import javax.measure.unit.Unit;

public interface Quality extends FluidQuantity {

    public final static Unit<Quality> UNIT =
            new ProductUnit<Quality>(Dimensionless.UNIT);
}