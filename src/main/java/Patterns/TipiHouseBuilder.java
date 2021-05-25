package Patterns;

//  this is a bad implementation, found on the internet.  It does not create an immutable object and
//  also creates the object in an inconsistent state.  For these reasons, this is not recommended.

public class TipiHouseBuilder implements HouseBuilder {
    private House house;

    public TipiHouseBuilder() {
        this.house = new House();
    }

    @Override
    public void setBasement() {
        house.setBasement("Nothing");
    }

    @Override

    public void setStructure() {
        house.setStructure("Wood poles");
    }

    @Override

    public void setInterior() {
        house.setInterior("Fire Wood");
    }

    @Override

    public void setRoof() {
        house.setRoof("Wood, caribou and seal skins");
    }

    @Override

    public House build() {
        return this.house;
    }
}
