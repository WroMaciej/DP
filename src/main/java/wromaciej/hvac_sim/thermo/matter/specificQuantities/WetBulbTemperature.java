package wromaciej.hvac_sim.thermo.matter.specificQuantities;

import wromaciej.hvac_sim.thermo.matter.specificQuantities.base.AirQuantity;
import wromaciej.hvac_sim.thermo.matter.specificQuantities.base.FluidQuantity;

import javax.measure.unit.ProductUnit;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

public interface WetBulbTemperature extends AirQuantity {

    public final static Unit<WetBulbTemperature> UNIT =
            new ProductUnit<WetBulbTemperature>(SI.KELVIN);
}
