package workshop.SystemSplit.system.core.software;

public abstract class Software {
    private String name;
    private String type;
    private int capacityCons;
    private int memoryCons;

    public Software(String name, String type, int capacityCons, int memoryCons) {
        this.name = name;
        this.type = type;
        this.capacityCons = capacityCons;
        this.memoryCons = memoryCons;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getCapacityCons() {
        return this.capacityCons;
    }

    public int getMemoryCons() {
        return this.memoryCons;
    }
}