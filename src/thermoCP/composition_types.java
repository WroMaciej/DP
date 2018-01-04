/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package thermoCP;

public final class composition_types {
  public final static composition_types IFRAC_MASS = new composition_types("IFRAC_MASS");
  public final static composition_types IFRAC_MOLE = new composition_types("IFRAC_MOLE");
  public final static composition_types IFRAC_VOLUME = new composition_types("IFRAC_VOLUME");
  public final static composition_types IFRAC_UNDEFINED = new composition_types("IFRAC_UNDEFINED");
  public final static composition_types IFRAC_PURE = new composition_types("IFRAC_PURE");

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static composition_types swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + composition_types.class + " with value " + swigValue);
  }

  private composition_types(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private composition_types(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private composition_types(String swigName, composition_types swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static composition_types[] swigValues = { IFRAC_MASS, IFRAC_MOLE, IFRAC_VOLUME, IFRAC_UNDEFINED, IFRAC_PURE };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

