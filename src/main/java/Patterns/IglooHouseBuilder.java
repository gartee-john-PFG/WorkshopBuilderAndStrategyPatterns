package Patterns;

public class IglooHouseBuilder implements HouseBuilder {
    private House house;

    public IglooHouseBuilder() {
        this.house = new House();
    }

    @Override
    public void setBasement() {
        house.setBasement("Ice Bars");
    }

    @Override
    public void setStructure() {
        house.setStructure("Ice Blocks");
    }

    @Override
    public void setRoof() {
        house.setRoof("Ice Dome");
    }

    @Override
    public void setInterior() {
        house.setInterior("Blankets and Skins");
    }

    @Override
    public House build() {
        return house;
    }
}
