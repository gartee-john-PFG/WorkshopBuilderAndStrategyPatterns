package Facade.devices.livingroom;

import Facade.devices.Fan;

public class LivingRoomFan extends Fan {

    public LivingRoomFan() {
        super("LivingRoomFan");
    }

    @Override
    public String toString() {
        return "LivingRoomFan{" +
                "name='" + name + '\'' +
                ", status=" + status +
                ", currentSpeed=" + currentSpeed +
                '}';
    }
}