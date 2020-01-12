package workshop.SystemSplit.system.core.software;

public class ExpressSoftware extends Software {

    public ExpressSoftware(String name, int capacityCons, int memoryCons) {
        super(name, "Express", capacityCons, memoryCons);
    }

    @Override
    public int getMemoryCons() {
        return super.getMemoryCons() * 2;
    }
}
