package workshop.SystemSplit.system.core.commands;

import workshop.SystemSplit.system.core.repositories.DumpRepo;
import workshop.SystemSplit.system.core.repositories.Repository;
import workshop.SystemSplit.system.core.hardware.HeavyHardware;
import workshop.SystemSplit.system.core.hardware.PowerHardware;
import workshop.SystemSplit.system.core.software.ExpressSoftware;
import workshop.SystemSplit.system.core.software.LightSoftware;

public class Commands {

    private Repository repository;
    private DumpRepo dumpRepo;

    public Commands() {
        this.repository = new Repository();
        this.dumpRepo = new DumpRepo();
    }

    public void registerPowerHardware(String name, int capacity, int memory) {
        this.repository.register(new PowerHardware(name, capacity, memory));
    }

    public void registerHeavyHardware(String name, int capacity, int memory) {
        this.repository.register(new HeavyHardware(name, capacity, memory));
    }

    public void registerExpressSoftware(String hardwareComponentName, String name, int capacity, int memory) {
        if (this.repository.containHardware(hardwareComponentName)) {
            this.repository.addSoftware(hardwareComponentName, new ExpressSoftware(name, capacity, memory));
        }
    }

    public void registerLightSoftware(String hardwareComponentName, String name, int capacity, int memory) {
        if (this.repository.containHardware(hardwareComponentName)) {
            this.repository.addSoftware(hardwareComponentName, new LightSoftware(name, capacity, memory));
        }
    }

    public void releaseSoftwareComponent(String hardwareName, String softwareName) {
        this.repository.removeSoftware(hardwareName, softwareName);
    }

    public void analyze() {
        StringBuilder sb = new StringBuilder();
        sb.append("System Analysis").append(System.lineSeparator());
        sb.append(String.format("Hardware Components: %d"
                , this.repository.hardwareCount())).append(System.lineSeparator());
        sb.append(String.format("Software Components: %d"
                , this.repository.softwareCount())).append(System.lineSeparator());
        sb.append(String.format("Total Operational Memory: %d / %d"
                , this.repository.memoryUsed(),  this.repository.maximumMemory())).append(System.lineSeparator());
        sb.append(String.format("Total Capacity Taken: %d / %d"
                , this.repository.capacityUsed(), this.repository.maximumCapacity()));

        System.out.println(sb.toString());
    }

    public void systemSplit() {
        StringBuilder sb = new StringBuilder();
        this.repository.getPowerHardware().forEach(h -> sb.append(h.toString()));
        this.repository.getHeavyHardware().forEach(p -> sb.append(p.toString()));
        System.out.println(sb.toString());
    }

    public void dump(String hardwareComponentName) {
        this.dumpRepo.addHardware(this.repository.removeHardware(hardwareComponentName));
    }

    public void restore(String hardwareComponentName) {
        this.repository.register(this.dumpRepo.removeHardware(hardwareComponentName));
    }

    public void destroy(String hardwareComponentName) {
        this.dumpRepo.removeHardware(hardwareComponentName);
    }

    public void dumpAnalyze() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dump Analysis").append(System.lineSeparator());
        sb.append(String.format("Power Hardware Components: %d"
                , this.dumpRepo.getPowerCompCount())).append(System.lineSeparator());
        sb.append(String.format("Heavy Hardware Components: %d"
                , this.dumpRepo.getHeavyCompCount())).append(System.lineSeparator());
        sb.append(String.format("Express Software Components: %d"
                , this.dumpRepo.expressSoftCount())).append(System.lineSeparator());
        sb.append(String.format("Light Software Components: %d"
                , this.dumpRepo.lightSoftCount())).append(System.lineSeparator());
        sb.append(String.format("Total Dumped Memory: %d"
                , this.dumpRepo.totalDumpMemory())).append(System.lineSeparator());
        sb.append(String.format("Total Dumped Capacity: %d"
                , this.dumpRepo.totalDumpCapacity())).append(System.lineSeparator());

        System.out.println(sb.toString());
    }
}