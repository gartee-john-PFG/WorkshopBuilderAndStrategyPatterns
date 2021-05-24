package Patterns;

public class House implements HousePlan {
    private String basement;
    private String structure;
    private String roof;
    private String interior;

    @Override
    public void setBasement(String basement) {
        this.basement = basement;
    }

    @Override
    public String getBasement() {
        return this.basement;
    }

    @Override
    public void setStructure(String structure) {
        this.structure = structure;
    }

    @Override
    public String getStructure() {
        return this.structure;
    }

    @Override
    public void setRoof(String roof) {
        this.roof = roof;
    }

    @Override
    public String getRoof() {
        return this.roof;
    }

    @Override
    public void setInterior(String interior) {
        this.interior = interior;
    }

    @Override
    public String getInterior() {
        return this.interior;
    }
}
