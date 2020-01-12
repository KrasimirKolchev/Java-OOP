package InterfacesAndAbstraction.Ferrari;

public class Ferrari implements Car {
    private String model;
    private String driverName;

    Ferrari(String driverName) {
        this.driverName = driverName;
        this.model = "488-Spider";
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "Zadu6avam sA!";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s",
                this.model, this.brakes(), this.gas(), this.driverName);
    }
}
