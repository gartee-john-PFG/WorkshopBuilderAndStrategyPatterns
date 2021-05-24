package Patterns;

public class FrameHouseBuilder implements HouseBuilder {
    private House house;

    public FrameHouseBuilder() {
        this.house = new House();
    }

    @Override
    public void setBasement() {
        house.setBasement("Cinder Block");
    }

    @Override

    public void setStructure() {
        house.setStructure("Frame Structure");
    }

    @Override

    public void setInterior() {
        house.setInterior("2 x 4 frame walls");
    }

    @Override

    public void setRoof() {
        house.setRoof("Rafters and Shingles");
    }

    @Override

    public House build() {
        return this.house;
    }
}
