package wromaciej.hvac_sim.thermo.devices.model.basic.bonds;

import wromaciej.hvac_sim.display.Item;
import wromaciej.hvac_sim.thermo.devices.model.basic.Device;
import wromaciej.hvac_sim.thermo.streams.model.AnyStream;

import java.util.Objects;

public abstract class Bond {
    private final int bondId;
    /**
     * Id of the owner of the bond
     */

    /**
     * Flow direction in/out
     */
    private final BondDirection flowDirection;

    /**
     * Id of the bond
     */

    private final Item ownerItem;
    /**
     * Id of the object connected to
     */
    protected Bond targetBond;

    /**
     * Description of the bond
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Bond(int bondId, BondDirection flowDirection, Item ownerItem) {
        this.bondId = bondId;
        this.flowDirection = flowDirection;
        this.ownerItem = ownerItem;
    }

    public void disconnect(){
        this.targetBond =  null;
    }

    public int getBondId() {
        return bondId;
    }

    public Item getOwnerItem() {
        return ownerItem;
    }

    public Bond getTargetBond() {
        return targetBond;
    }

    public BondDirection getFlowDirection() {
        return flowDirection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bond bond = (Bond) o;
        return bondId == bond.bondId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(bondId);
    }
}