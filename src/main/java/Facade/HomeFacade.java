package Facade;
import Facade.devices.Fan;
import Facade.devices.Light;
import Facade.devices.SoundBar;
import Facade.devices.TV;
import Facade.devices.kitchen.*;
import Facade.devices.livingroom.*;

import java.util.List;

public class HomeFacade {
    Fan fan;
    LivingRoomFireTV4KStick stick;
    Light livingRoomLight;
    SoundBar soundBar;
    TV tv;

    CoffeeMaker maker;
    ElectricGrill grill;
    Light kitchenLight;
    Microwave microwave;
    Refrigerator refrigerator;

    public HomeFacade() {
        super();
        fan = new LivingRoomFan();
        tv = new LivingRoomTV();
        stick = new LivingRoomFireTV4KStick(tv);
        livingRoomLight = new LivingRoomLight();
        soundBar = new LivingRoomSoundBar(tv);

        maker = new CoffeeMaker();
        grill = new ElectricGrill();
        kitchenLight = new KitchenLight();
        microwave = new Microwave();
        refrigerator = new Refrigerator();
    }

    public void playMovieOnNetflix(String movieName) {
        fan.on();
        fan.increase();
        livingRoomLight.on();
        tv.on();
        ((LivingRoomTV) tv).setSource("HDMI ARC");
        stick.on();
        soundBar.on();
        soundBar.setSoundMode("Dolby Atmos");
        stick.openApp("Netflix");
        stick.selectContent(movieName);
        ((LivingRoomLight) livingRoomLight).dim();
        soundBar.volume(20);
        stick.play();
    }

    public void prepareFood(List<String> pizzaNames) {
        kitchenLight.on();
        // normally refrigerator runs always. so no need to turn on.
        refrigerator.partyMode(); // for fast cooling
        microwave.on();
        microwave.setOnPreHeat(200, 5);
        microwave.grillOn();
        grill.on();
        maker.on();
        pizzaNames.forEach(pizzaName -> microwave.bake(pizzaName, 400, 10));
    }

    public void stopMovie() {
        stick.closeApp();
        stick.off();
        soundBar.off();
        tv.off();
        ((LivingRoomLight) livingRoomLight).bright();
        fan.off();
    }

    public void closeKitchen() {
        refrigerator.normalMode();
        grill.off();
        maker.off();
        microwave.off();
    }

    @Override
    public String toString() {
        return "HomeFacade{" + "\n\t" +
                "fan=" + fan + "\n\t" +
                ", stick=" + stick + "\n\t" +
                ", livingRoomLight=" + livingRoomLight + "\n\t" +
                ", soundBar=" + soundBar + "\n\t" +
                ", tv=" + tv + "\n\t" +
                ", maker=" + maker + "\n\t" +
                ", grill=" + grill + "\n\t" +
                ", kitchenLight=" + kitchenLight + "\n\t" +
                ", microwave=" + microwave + "\n\t" +
                ", refrigerator=" + refrigerator + "\n" +
                '}';
    }
}
