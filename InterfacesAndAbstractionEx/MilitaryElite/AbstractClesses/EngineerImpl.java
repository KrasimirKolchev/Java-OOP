package InterfacesAndAbstractionEx.MilitaryElite.AbstractClesses;

import InterfacesAndAbstractionEx.MilitaryElite.Interfaces.InterfaceEngineer;
import InterfacesAndAbstractionEx.MilitaryElite.addons.Repair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class EngineerImpl extends SpecialisedSoldierImpl implements InterfaceEngineer {
    private List<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList<>();
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public List<Repair> getRepairs() {
        return Collections.unmodifiableList(repairs);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s Id: %d Salary: %.2f",
                this.getFirstName(), this.getLastName(), this.getId(), this.getSalary()));
        sb.append(System.lineSeparator()).append(String.format("Corps: %s", this.getCorps())).append(System.lineSeparator());
        sb.append("Repairs:");

        for (Repair aRepair : repairs) {
            sb.append(System.lineSeparator()).append(aRepair.toString());
        }
        return sb.toString();
    }
}
