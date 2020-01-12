package workshop.SystemSplit.system.core.software;

public class LightSoftware extends Software {
    public LightSoftware(String name, int capacityCons, int memoryCons) {
        super(name, "Light", capacityCons, memoryCons);
    }

    @Override
    public int getCapacityCons() {
        int capacity = super.getCapacityCons();
        capacity += capacity / 2;
        return capacity;
    }

    @Override
    public int getMemoryCons() {
        int memory = super.getMemoryCons();
        memory -= memory / 2;
        return memory;
    }
}
