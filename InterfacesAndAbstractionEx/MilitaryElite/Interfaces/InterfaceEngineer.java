package InterfacesAndAbstractionEx.MilitaryElite.Interfaces;

import InterfacesAndAbstractionEx.MilitaryElite.addons.Repair;

import java.util.List;

public interface InterfaceEngineer {

    void addRepair(Repair repair);

    List<Repair> getRepairs();
}
