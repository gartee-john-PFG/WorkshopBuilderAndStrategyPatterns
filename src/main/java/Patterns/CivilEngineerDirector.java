package Patterns;

public class CivilEngineerDirector {
    private HouseBuilder houseBuilder;
    public CivilEngineerDirector(HouseBuilder houseBuilder){
                this.houseBuilder = houseBuilder;
    }
    public House getHouse(){
        constructHouse();
        return this.houseBuilder.build();
    }
    public void constructHouse()
    {
        this.houseBuilder.setBasement();
        this.houseBuilder.setStructure();
        this.houseBuilder.setRoof();
        this.houseBuilder.setInterior();
    }
}
