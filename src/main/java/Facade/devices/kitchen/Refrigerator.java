package Facade.devices.kitchen;

import Facade.devices.Appliance;

public class Refrigerator extends Appliance {

    protected static final String PARTY = "party";
    protected static final String NORMAL = "normal";
    protected String mode = NORMAL;

    public Refrigerator() {
        super("Refrigerator");
    }

    public void partyMode() {
        mode = PARTY;
        System.out.printf("Setting '%s' Cooling to 'Party'.\n", name);
    }

    public void normalMode() {
        mode = NORMAL;
        System.out.printf("Setting '%s' Cooling to 'Normal'.\n", name);
    }

    @Override
    public String toString() {
        return "Refrigerator{" +
                "name='" + name + " \\ " +
                ", status=" + status + " \\ " +
                ", mode='" + mode + " " +
                '}';
    }
}