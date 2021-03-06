package wromaciej.hvac_sim.simulation.thermo.solvers;

import org.junit.Test;
import wromaciej.hvac_sim.simulation.solver.matterSolvers.FluidDefinition;
import wromaciej.hvac_sim.simulation.solver.matterSolvers.FluidSolver;
import wromaciej.hvac_sim.simulation.thermo.matter.fluids.model.*;
import wromaciej.hvac_sim.simulation.thermo.parameters.Parameter;
import wromaciej.hvac_sim.simulation.thermo.parameters.ParameterType;
import wromaciej.hvac_sim.simulation.thermo.matter.fluids.service.FluidData;
import wromaciej.hvac_sim.simulation.thermo.quantities.specific.Pressure;
import wromaciej.hvac_sim.simulation.thermo.quantities.specific.Temperature;

import javax.measure.unit.NonSI;
import javax.measure.unit.SI;

public class FluidSolverTest {

    @Test
    public void shouldReturnWaterForTemperatureAndPressure(){
        FluidData fluidData = new FluidData(true);
        FluidSetter fluidSetter = new FluidSetter(fluidData);
        FluidSolver fluidSolver = new FluidSolver(fluidSetter);

        Fluid fluid= new Fluid(fluidSolver);
        Parameter<Temperature> temperature = new Parameter(ParameterType.TEMPERATURE, SI.CELSIUS.asType(Temperature.class), 20);
        Parameter<Pressure> pressure = new Parameter(ParameterType.PRESSURE, NonSI.BAR.asType(Pressure.class), 1);
        FluidDefinition fluidDefinition = new FluidDefinition(FluidName.WATER, MatterType.GENERAL_FLUID, temperature, pressure);

        fluid.setMatterDefinition(fluidDefinition);
        fluid.solve();

        System.out.println(fluid);
    }


}
