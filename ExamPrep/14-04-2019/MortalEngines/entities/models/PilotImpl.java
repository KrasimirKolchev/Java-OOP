package entities.models;

import entities.interfaces.Machine;
import entities.interfaces.Pilot;

import java.util.ArrayList;
import java.util.List;

public class PilotImpl implements Pilot {

    private String name;
    private List<Machine> machines;

    public PilotImpl(String name) {
        this.setName(name);
        this.machines = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addMachine(Machine machine) {

    }

    @Override
    public List<Machine> getMachines() {
        return this.machines;
    }

    @Override
    public String report() {
        return null;
    }
}
