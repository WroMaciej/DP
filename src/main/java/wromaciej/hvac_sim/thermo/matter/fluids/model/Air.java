package wromaciej.hvac_sim.thermo.matter.fluids.model;

import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.quantities.specific.MoistureContent;
import wromaciej.hvac_sim.thermo.quantities.specific.Pressure;
import wromaciej.hvac_sim.thermo.quantities.specific.RelativeHumidity;
import wromaciej.hvac_sim.thermo.quantities.specific.Temperature;

public final class Air extends Fluid {
    /**
     * Relative Humidity 0-1
     */
    private Parameter<RelativeHumidity> relativeHumidity;
    /**
     * Moisture Content x kgH2O/kgDRY
     */
    private Parameter<MoistureContent> moistureContent;
    /**
     * Content of steam in mixture kgH2O/kgWET
     */
    private Parameter<MoistureContent> waterFraction;
    /**
     * Temperature of Dewpoint (x=idem)
     */
    private Parameter<Temperature> dewPointTemperature;
    /**
     * Temperature of wet bult (h=idem)
     */
    private Parameter<Temperature> wetBulbTemperature;
    /**
     * Partial pressure of water in mixture
     */
    private Parameter<Pressure> waterPartialPressure;



    public Air() {
        super();
    }

    @Override
    public void updateParameters() {
        super.updateParameters();
        addParameter(relativeHumidity);
        addParameter(moistureContent);
        addParameter(dewPointTemperature);
        addParameter(wetBulbTemperature);
        addParameter(waterPartialPressure);
    }

    public Parameter<RelativeHumidity> getRelativeHumidity() {
        return relativeHumidity;
    }

    protected void setRelativeHumidity(Parameter<RelativeHumidity> relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
    }

    public Parameter<MoistureContent> getMoistureContent() {
        return moistureContent;
    }

    protected void setMoistureContent(Parameter<MoistureContent> moistureContent) {
        this.moistureContent = moistureContent;
    }

    public Parameter<Temperature> getDewPointTemperature() {
        return dewPointTemperature;
    }

    protected void setDewPointTemperature(Parameter<Temperature> dewPointTemperature) {
        this.dewPointTemperature = dewPointTemperature;
    }

    public Parameter<Temperature> getWetBulbTemperature() {
        return wetBulbTemperature;
    }

    protected void setWetBulbTemperature(Parameter<Temperature> wetBulbTemperature) {
        this.wetBulbTemperature = wetBulbTemperature;
    }

    public Parameter<MoistureContent> getWaterFraction() {
        return waterFraction;
    }

    protected void setWaterFraction(Parameter<MoistureContent> waterFraction) {
        this.waterFraction = waterFraction;
    }

    public Parameter<Pressure> getWaterPartialPressure() {
        return waterPartialPressure;
    }

    protected void setWaterPartialPressure(Parameter<Pressure> waterPartialPressure) {
        this.waterPartialPressure = waterPartialPressure;
    }


}
