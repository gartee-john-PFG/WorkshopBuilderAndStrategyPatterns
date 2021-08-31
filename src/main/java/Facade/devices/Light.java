package Facade.devices;

public abstract class Light extends Appliance {

    public Light(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Light{" +
                "name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}