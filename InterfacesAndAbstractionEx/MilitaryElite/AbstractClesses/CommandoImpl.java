package InterfacesAndAbstractionEx.MilitaryElite.AbstractClesses;

import InterfacesAndAbstractionEx.MilitaryElite.Interfaces.InterfaceCommando;
import InterfacesAndAbstractionEx.MilitaryElite.addons.Mission;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class CommandoImpl extends SpecialisedSoldierImpl implements InterfaceCommando {

    private List<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new ArrayList<>();
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public List<Mission> getMissions() {
        return Collections.unmodifiableList(missions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s Id: %d Salary: %.2f",
                this.getFirstName(), this.getLastName(), this.getId(), this.getSalary()));
        sb.append(System.lineSeparator()).append(String.format("Corps: %s", this.getCorps()));
        sb.append(System.lineSeparator()).append("Missions:");

        for (Mission aMission : missions) {
            sb.append(System.lineSeparator()).append(aMission.toString());
        }
        return sb.toString();
    }
}
