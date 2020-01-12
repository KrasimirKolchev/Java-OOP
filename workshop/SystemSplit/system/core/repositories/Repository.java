package workshop.SystemSplit.system.core.repositories;

import workshop.SystemSplit.system.core.hardware.Hardware;
import workshop.SystemSplit.system.core.software.Software;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Repository {
    private Map<String, Hardware> hardwareMap;

    public Repository() {
        this.hardwareMap = new LinkedHashMap<>();
    }

    public void register(Hardware hardware) {
        this.hardwareMap.put(hardware.getName(), hardware);
    }

    public boolean containHardware(String name) {
        return this.hardwareMap.containsKey(name);
    }

    public void addSoftware(String name, Software software) {
        this.hardwareMap.get(name).addSoftware(software);
    }

    public void removeSoftware(String hardwareName, String softwareName) {
        this.hardwareMap.get(hardwareName).removeSoftware(softwareName);
    }

    public int hardwareCount() {
        return this.hardwareMap.size();
    }

    public int softwareCount() {
        int result = 0;
        for (Hardware hardware : this.hardwareMap.values()) {
            result += hardware.getSize();
        }
        return result;
    }

    public int maximumMemory() {
        return this.hardwareMap.values().stream().mapToInt(Hardware::getMaximumMemory).sum();
    }

    public int memoryUsed() {
        return this.hardwareMap.values().stream().mapToInt(Hardware::getUsedMemory).sum();
    }

    public int maximumCapacity() {
        return this.hardwareMap.values().stream().mapToInt(Hardware::getMaximumCapacity).sum();
    }

    public int capacityUsed() {
        return this.hardwareMap.values().stream().mapToInt(Hardware::getUsedCapacity).sum();
    }

    public List<Hardware> getPowerHardware() {
        return this.hardwareMap.values().stream()
                .filter(h -> h.getType().equals("Power"))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Hardware> getHeavyHardware() {
        return this.hardwareMap.values().stream()
                .filter(h -> h.getType().equals("Heavy"))
                .collect(Collectors.toUnmodifiableList());
    }

    public Hardware removeHardware(String hardwareName) {
        return this.hardwareMap.remove(hardwareName);
    }
}
