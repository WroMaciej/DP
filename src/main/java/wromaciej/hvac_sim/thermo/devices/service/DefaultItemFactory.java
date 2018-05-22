package wromaciej.hvac_sim.thermo.devices.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import wromaciej.hvac_sim.ids.IdGenerator;
import wromaciej.hvac_sim.simulation.data.AllElements;
import wromaciej.hvac_sim.simulation.data.AllSolvers;
import wromaciej.hvac_sim.thermo.devices.model.basic.Heater;
import wromaciej.hvac_sim.thermo.generals.Item;
import wromaciej.hvac_sim.thermo.generals.bonds.InletDeviceBond;
import wromaciej.hvac_sim.thermo.generals.bonds.InletStreamBond;
import wromaciej.hvac_sim.thermo.generals.bonds.OutletDeviceBond;
import wromaciej.hvac_sim.thermo.generals.bonds.OutletStreamBond;
import wromaciej.hvac_sim.thermo.generals.conservationLaw.Channel;
import wromaciej.hvac_sim.thermo.generals.conservationLaw.ParameterWithDirection;
import wromaciej.hvac_sim.thermo.matter.fluids.model.Fluid;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.ParameterType;
import wromaciej.hvac_sim.thermo.quantities.extensive.HeatFlow;
import wromaciej.hvac_sim.thermo.quantities.extensive.MassFlow;
import wromaciej.hvac_sim.thermo.quantities.specific.PressureDifference;
import wromaciej.hvac_sim.thermo.streams.model.FluidStream;
import wromaciej.hvac_sim.thermo.streams.model.HeatStream;
import wromaciej.hvac_sim.thermo.streams.model.MatterStream;
import wromaciej.hvac_sim.thermo.unitSystems.UnitSystem;

import static wromaciej.hvac_sim.thermo.generals.bonds.BondDirection.INLET;
import static wromaciej.hvac_sim.thermo.matter.fluids.parameters.ParameterType.OTHER;

/**
 * Creates brand new and complete devices
 */


public class DefaultItemFactory {

    private AllElements allElements;
    private UnitSystem unitSystem;
    private IdGenerator idGenerator;
    private AllSolvers allSolvers;

    public DefaultItemFactory(AllElements allElements, UnitSystem unitSystem, IdGenerator idGenerator, AllSolvers allSolvers) {
        this.allElements = allElements;
        this.unitSystem = unitSystem;
        this.idGenerator = idGenerator;
        this.allSolvers = allSolvers;
    }

    public HeatStream createDefaultHeatStream(){
        HeatStream heatStream;
        int uniqueId = idGenerator.getUniqueId();
        Parameter<HeatFlow> heatFlow = new Parameter<>(unitSystem.getHeatFlowUnit());
        InletStreamBond<HeatStream>  inletStreamBond = new InletStreamBond<>(idGenerator.getUniqueId());
        OutletStreamBond<HeatStream> outletStreamBond = new OutletStreamBond<>(idGenerator.getUniqueId());
        heatStream = new HeatStream(uniqueId, idGenerator, heatFlow, inletStreamBond, outletStreamBond);
        heatStream.setName("HeatStream " + uniqueId);

        heatStream.setExternalSolver(allSolvers.getHeatStreamSolver());
        allElements.addHeatStream(heatStream);
        return heatStream;
    }

    public FluidStream createDefaultFluidStream(){
        FluidStream fluidStream;
        int uniqueId = idGenerator.getUniqueId();
        InletStreamBond<FluidStream>  inletStreamBond = new InletStreamBond<>(idGenerator.getUniqueId());
        OutletStreamBond<FluidStream> outletStreamBond = new OutletStreamBond<>(idGenerator.getUniqueId());
        Fluid specificParameters = new Fluid(allSolvers.getFluidSolver());
        fluidStream = new FluidStream(uniqueId, idGenerator, specificParameters, inletStreamBond, outletStreamBond);
        fluidStream.setName("FluidStream " + uniqueId);

        fluidStream.setExternalSolver(allSolvers.getMatterStreamSolver());
        allElements.addMatterStream(fluidStream);
        return fluidStream;
    }

    private Channel createDefaultChannel(Item ownerItem, Parameter<PressureDifference> pressureDrop, ParameterWithDirection heatFlow, ParameterWithDirection extraMassFlow){
        Channel channel;
        InletDeviceBond inletDeviceBond = new InletDeviceBond(idGenerator.getUniqueId());
        OutletDeviceBond outletDeviceBond = new OutletDeviceBond(idGenerator.getUniqueId());
        channel = new Channel(ownerItem, inletDeviceBond, outletDeviceBond, pressureDrop, heatFlow, extraMassFlow);
        return channel;
    }

    public Heater createDefaultHeater(){
        Heater heater;
        int uniqueId = idGenerator.getUniqueId();
        Parameter<PressureDifference> pressureDrop = new Parameter<>(unitSystem.getPressureDifferenceUnit(), 0.0);
        ParameterWithDirection heatFlow = new ParameterWithDirection(new Parameter(unitSystem.getHeatFlowUnit()), INLET);
        ParameterWithDirection extraMassFlow = new ParameterWithDirection(new Parameter(unitSystem.getMassFlowUnit(), 0.0), INLET);
        InletDeviceBond<HeatStream> heatStreamInletDeviceBond= new InletDeviceBond<>(idGenerator.getUniqueId());
        heater = new Heater(uniqueId, idGenerator, null, heatStreamInletDeviceBond);
        Channel<MatterStream> channel = createDefaultChannel(heater, pressureDrop, heatFlow, extraMassFlow);
        heater.setMainChannel(channel);
        return heater;
    }



}