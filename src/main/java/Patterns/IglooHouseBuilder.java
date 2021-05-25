package Patterns;

//  this is a bad implementation, found on the internet.  It does not create an immutable object and
//  also creates the object in an inconsistent state.  For these reasons, this is not recommended.

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
