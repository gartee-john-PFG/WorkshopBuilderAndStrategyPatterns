package Patterns;

// import Patterns.BuildAHouse;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BuildHouseTest {
    @Test
    void buildIglooTest() {
        HouseBuilder builder = new IglooHouseBuilder();
        CivilEngineerDirector engineer = new CivilEngineerDirector(builder);

        House house = engineer.getHouse();

        assertEquals("Ice Bars", house.getBasement(), "getBasement() should return 'Ice Bars'");
    }

    @Test
    void buildFrameHouseTest() {
        HouseBuilder builder = new FrameHouseBuilder();
        CivilEngineerDirector engineer = new CivilEngineerDirector(builder);

        House frameHome = engineer.getHouse();

        assertEquals("Cinder Block", engineer.getHouse().getBasement(), "getBasement() should return 'Cinder Blocks'");
    }

    @Test
    void buildTipiTest() {
        HouseBuilder builder = new TipiHouseBuilder();
        CivilEngineerDirector engineer = new CivilEngineerDirector(builder);

        House tipi = engineer.getHouse();

        assertEquals("Nothing", tipi.getBasement(), "getBasement() should return 'Nothing'");
    }
}
