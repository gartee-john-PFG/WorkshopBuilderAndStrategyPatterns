package Facade.devices.kitchen;

import Facade.devices.Appliance;

public class ElectricGrill extends Appliance {

    protected int temp;

    public ElectricGrill() {
        super("ElectricGrill");
    }

    public void setTemp(int temp) {
        this.temp = temp;
        System.out.printf("Setting '%s' temprature to '%d'.\n", name, temp);
    }

    public int temperature() {
        return temp;
    }

    @Override
    public String toString() {
        return "ElectricGrill{" +
                "name='" + name + '\'' +
                ", status=" + status +
                ", temp=" + temp +
                '}';
    }
}