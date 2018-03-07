package wromaciej.hvac_sim.thermo.matter.specificQuantities;

import wromaciej.hvac_sim.thermo.matter.specificQuantities.base.AirQuantity;

import javax.measure.quantity.Dimensionless;
import javax.measure.unit.ProductUnit;
import javax.measure.unit.Unit;

public interface MoistureContent extends AirQuantity {

    public final static Unit<MoistureContent> UNIT =
            new ProductUnit<MoistureContent>(Dimensionless.UNIT);
}
