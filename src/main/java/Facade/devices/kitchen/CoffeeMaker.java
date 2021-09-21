package Facade.devices.kitchen;

import Facade.devices.Appliance;

public class CoffeeMaker extends Appliance {

    public CoffeeMaker() {
        super("CoffeeMaker");
    }

    @Override
    public String toString() {
        return "CoffeeMaker{" +
                "name='" + name + " \\ " +
                ", status=" + status + " " +
                '}';
    }
}