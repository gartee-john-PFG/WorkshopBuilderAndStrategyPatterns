package Facade.devices.livingroom;

import Facade.devices.SoundBar;
import Facade.devices.TV;

public class LivingRoomSoundBar extends SoundBar {

    protected TV tv;

    public LivingRoomSoundBar(TV tv) {
        super("LivingRoomSoundBar");
        this.tv = tv;
    }

    public TV tv() {
        return tv;
    }

    @Override
    public String toString() {
        return "LivingRoomSoundBar{" +
                "name='" + name + " \\ " +
                ", status=" + status + " \\ " +
                ", soundMode='" + soundMode + " \\ " +
                ", currentVolume=" + currentVolume + " \\ " +
                ", volumeWhenMute=" + volumeWhenMute + " \\ " +
                ", tv=" + tv + " " +
                '}';
    }
}