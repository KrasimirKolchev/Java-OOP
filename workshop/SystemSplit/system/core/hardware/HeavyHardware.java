package workshop.SystemSplit.system.core.hardware;

import workshop.SystemSplit.system.core.software.Software;

import java.util.ArrayList;

public class HeavyHardware extends Hardware {

    public HeavyHardware(String name, int maximumCapacity, int maximumMemory) {
        super(name, "Heavy" , maximumCapacity, maximumMemory, new ArrayList<>());
    }

    @Override
    public int getMaximumCapacity() {
        return super.getMaximumCapacity() * 2;
    }

    @Override
    public int getMaximumMemory() {
        int memory = super.getMaximumMemory();
        memory -= (memory / 4);
        return memory;
    }

    @Override
    public String toString() {
        int usedMemory = 0;
        int usedCapacity = 0;

        for (Software soft : getSoftwares()) {
            usedMemory += soft.getMemoryCons();
            usedCapacity += soft.getCapacityCons();
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Hardware Component - %s", this.getName())).append(System.lineSeparator());
        sb.append(String.format("Express Software Components - %d"
                , expressSoftCount())).append(System.lineSeparator());
        sb.append(String.format("Light Software Components - %d"
                , lightSoftCount())).append(System.lineSeparator());
        sb.append(String.format("Memory Usage: %d / %d"
                , usedMemory, this.getMaximumMemory())).append(System.lineSeparator());
        sb.append(String.format("Capacity Usage: %d / %d"
                , usedCapacity, this.getMaximumCapacity())).append(System.lineSeparator());
        sb.append(String.format("Type: %s", this.getType())).append(System.lineSeparator());
        sb.append("Software Components: ");

        if (this.getSoftwares().isEmpty()) {
            sb.append("None");
        } else {
            this.getSoftwares().forEach(s -> sb.append(s.getName()).append(", "));
            sb.delete(sb.lastIndexOf(","), sb.length()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
