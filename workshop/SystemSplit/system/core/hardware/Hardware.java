package workshop.SystemSplit.system.core.hardware;

import workshop.SystemSplit.system.core.software.Software;

import java.util.Collections;
import java.util.List;

public abstract class Hardware {
    private String name;
    private String type;
    private int maximumCapacity;
    private int maximumMemory;
    private List<Software> softwares;
    private int usedCapacity;
    private int usedMemory;

    public Hardware(String name, String type, int maximumCapacity, int maximumMemory, List<Software> softwares) {
        this.name = name;
        this.type = type;
        this.maximumCapacity = maximumCapacity;
        this.maximumMemory = maximumMemory;
        this.softwares = softwares;
        this.usedCapacity = 0;
        this.usedMemory = 0;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return type;
    }

    public int getMaximumCapacity() {
        return this.maximumCapacity;
    }

    public int getMaximumMemory() {
        return this.maximumMemory;
    }

    public void addSoftware(Software software) {
        if (this.usedCapacity + software.getCapacityCons() <= this.getMaximumCapacity()
                && this.usedMemory + software.getMemoryCons() <= this.getMaximumMemory()) {
            this.softwares.add(software);
            this.usedCapacity += software.getCapacityCons();
            this.usedMemory += software.getMemoryCons();
        }
    }

    public void removeSoftware(String name) {
        for (int i = 0; i < this.softwares.size(); i++) {
            if (this.softwares.get(i).getName().equals(name)) {
                this.softwares.remove(i);
                this.usedCapacity -= this.softwares.get(i).getCapacityCons();
                this.usedMemory -= this.softwares.get(i).getMemoryCons();
                break;
            }
        }
    }

    public int getUsedCapacity() {
        return this.usedCapacity;
    }

    public int getUsedMemory() {
        return this.usedMemory;
    }

    public int getSize() {
        return this.softwares.size();
    }

    protected int expressSoftCount() {
        int count = 0;
        for (Software software : softwares) {
            if (software.getType().equals("Express")) {
                count++;
            }
        }
        return count;
    }

    protected int lightSoftCount() {
        int count = 0;
        for (Software software : softwares) {
            if (software.getType().equals("Light")) {
                count++;
            }
        }
        return count;
    }

    public List<Software> getSoftwares() {
        return Collections.unmodifiableList(this.softwares);
    }
}
