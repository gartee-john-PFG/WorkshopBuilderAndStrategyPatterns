package Facade.devices.livingroom;

import Facade.devices.TV;

public class LivingRoomTV extends TV {

    protected String source;

    public LivingRoomTV() {
        super("LivingRoomTV");
    }

    public void setSource(String source) {
        this.source = source;
        System.out.printf("Setting Source of '%s' to '%s'.\n", name, source);
    }

    public String source() {
        return source;
    }

    @Override
    public String toString() {
        return "LivingRoomTV{" +
                "name='" + name + '\'' +
                ", status=" + status +
                ", currentVolume=" + currentVolume +
                ", currentChannel=" + currentChannel +
                ", volumeWhenMute=" + volumeWhenMute +
                ", source='" + source + '\'' +
                '}';
    }
}