package Patterns;
// Because all houses need a Plan, we define an interface

interface HousePlan {
    void setBasement(String basement);
    String getBasement();

    void setStructure(String structure);
    String getStructure();

    void setRoof(String roof);
    String getRoof();

    void setInterior(String interior);
    String getInterior();
}
