package workshop.SystemSplit.system.core.repositories;

import workshop.SystemSplit.system.core.hardware.Hardware;
import workshop.SystemSplit.system.core.software.Software;

import java.util.LinkedHashMap;
import java.util.Map;

public class DumpRepo {
    private static final int INITIAL_VALUE = 0;
    private Map<String, Hardware> dumpRepo;
    private int heavyCompCount;
    private int powerCompCount;

    public DumpRepo() {
        this.dumpRepo = new LinkedHashMap<>();
        this.heavyCompCount = INITIAL_VALUE;
        this.powerCompCount = INITIAL_VALUE;
    }

    public int getHeavyCompCount() {
        return this.heavyCompCount;
    }

    public int getPowerCompCount() {
        return this.powerCompCount;
    }

    public void addHardware(Hardware hardware) {
        this.dumpRepo.put(hardware.getName(), hardware);
        if (hardware.getType().equals("Power")) {
            this.powerCompCount++;
        } else {
            this.heavyCompCount++;
        }
    }

    public Hardware removeHardware(String hardwareName) {
        Hardware hardware = this.dumpRepo.get(hardwareName);
        if (hardware.getType().equals("Power")) {
            this.powerCompCount--;
        } else {
            this.heavyCompCount--;
        }
        return this.dumpRepo.remove(hardwareName);
    }

    public int expressSoftCount() {
        int count = 0;
        for (Hardware h : this.dumpRepo.values()) {
            for (Software s : h.getSoftwares()) {
                if (s.getType().equals("Express")) {
                    count++;
                }
            }
        }
        return count;
    }

    public int lightSoftCount() {
        int count = 0;
        for (Hardware h : this.dumpRepo.values()) {
            for (Software s : h.getSoftwares()) {
                if (s.getType().equals("Light")) {
                    count++;
                }
            }
        }
        return count;
    }

    public int totalDumpMemory() {
        int sum = 0;
        for (Hardware h : this.dumpRepo.values()) {
            for (Software s : h.getSoftwares()) {
                sum += s.getMemoryCons();
            }
        }
        return sum;
    }

    public int totalDumpCapacity() {
        int sum = 0;
        for (Hardware h : this.dumpRepo.values()) {
            for (Software s : h.getSoftwares()) {
                sum += s.getCapacityCons();
            }
        }
        return sum;
    }
}
