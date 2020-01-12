package EncapsulationEx.FootballTeamGenerator;

import java.util.LinkedHashMap;
import java.util.Map;

public class Teams {

    private static final Map<String, Team> teamsMap = new LinkedHashMap<>();

    static void add(Team team) {
        if (team != null) {
            Teams.teamsMap.putIfAbsent(team.getName(), team);
        }
    }

    static Team get(String teamName) {
        Team team = Teams.teamsMap.get(teamName);

        if (team == null) {
            throw new IllegalArgumentException(String.format("Team %s does not exist.", teamName));
        }
        return team;
    }
}
