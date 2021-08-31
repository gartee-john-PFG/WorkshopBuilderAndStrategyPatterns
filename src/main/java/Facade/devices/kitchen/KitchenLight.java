package Facade.devices.kitchen;

import Facade.devices.Light;

public class KitchenLight extends Light {

    public KitchenLight() {
        super("KitchenLight");
    }

    @Override
    public String toString() {
        return "KitchenLight{" +
                "name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}