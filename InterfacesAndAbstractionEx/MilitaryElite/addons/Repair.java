package InterfacesAndAbstractionEx.MilitaryElite.addons;

public class Repair {
    private String part;
    private int hours;

    public Repair(String part, int hours) {
        this.part = part;
        this.hours = hours;
    }

    @Override
    public String toString() {
        return String.format("  Part Name: %s Hours Worked: %s", this.part, this.hours);
    }
}
