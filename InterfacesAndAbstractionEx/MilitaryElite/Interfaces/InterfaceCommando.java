package InterfacesAndAbstractionEx.MilitaryElite.Interfaces;

import InterfacesAndAbstractionEx.MilitaryElite.addons.Mission;

import java.util.List;

public interface InterfaceCommando {

    void addMission(Mission mission);

    List<Mission> getMissions();
}
