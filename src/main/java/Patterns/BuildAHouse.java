package Patterns;

public class BuildAHouse {
    CivilEngineerDirector engineer;

    public BuildAHouse(){

    }

    public CivilEngineerDirector getEngineer() {
        return engineer;
    }

    public House BuildIgloo(){
        HouseBuilder iglooBuilder = new IglooHouseBuilder();
        CivilEngineerDirector engineer = new CivilEngineerDirector(iglooBuilder);

        engineer.constructHouse();

        return engineer.getHouse();
    }

    public House BuildTipi() {
        HouseBuilder tipiBuilder = new IglooHouseBuilder();
        CivilEngineerDirector engineer = new CivilEngineerDirector(tipiBuilder);

        engineer.constructHouse();

        return engineer.getHouse();
    }

    public House BuildFrameHouse() {
        HouseBuilder frameHouseBuilder = new FrameHouseBuilder();
        CivilEngineerDirector engineer = new CivilEngineerDirector(frameHouseBuilder);

        engineer.constructHouse();

        return engineer.getHouse();
    }
}
