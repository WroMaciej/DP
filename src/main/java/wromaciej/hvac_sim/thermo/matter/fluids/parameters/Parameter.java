package wromaciej.hvac_sim.thermo.matter.fluids.parameters;


import org.jscience.physics.amount.Amount;
import wromaciej.hvac_sim.thermo.quantities.base.AnyQuantity;
import javax.measure.unit.Unit;


public class Parameter<Q extends AnyQuantity> {

    private Amount<Q> amount;

    private Unit<Q> actualUnit;

    public Double getValue() {
        return amount.doubleValue(actualUnit);
    }

    public void setValue(double value) {
        amount = Amount.valueOf(value, actualUnit);
    }

    public Amount<Q> getAmount() {
        return amount;
    }

    public void setAmount(Amount<Q> amount) {
        this.amount = amount;
    }

    public Parameter(){}

    public Parameter(Unit<Q> unitInUnitSystem) {
        this.actualUnit = unitInUnitSystem;
    }

    public Parameter(Unit<Q> unitInUnitSystem, double value) {
        this.actualUnit = unitInUnitSystem; ;
        setValue(value);
    }

    public Unit<Q> getActualUnit() {
        return actualUnit;
    }

    public void setActualUnit(Unit<Q> actualUnit) {
        this.actualUnit = actualUnit;
        amount = Amount.valueOf(getValue(),actualUnit);
    }

    public Parameter times (double factor){
        Amount resultingAmount=amount.times(factor);
        Unit resultingUnit=resultingAmount.getUnit();
        Parameter resultingParameter=new Parameter(resultingUnit);
        resultingParameter.setAmount(resultingAmount);
        return resultingParameter;
    }


    public Parameter times (Parameter that){
        Amount resultingAmount=amount.times(that.getAmount());
        Unit resultingUnit=resultingAmount.getUnit();
        Parameter resultingParameter=new Parameter(resultingUnit);
        resultingParameter.setAmount(resultingAmount);
        return resultingParameter;
    }


    @Override
    public String toString() {
        return getValue() + getActualUnit().toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        Parameter<Q> thatParameter = (Parameter<Q>) that;
        Amount<Q> thatAmount= (Amount) thatParameter.amount;
        return amount.approximates(thatAmount);
    }

    @Override
    public int hashCode() {

        return amount.hashCode();
    }
}
