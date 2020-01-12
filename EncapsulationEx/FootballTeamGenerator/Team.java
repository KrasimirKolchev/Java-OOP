package EncapsulationEx.FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    String getName() {
        return name;
    }

    private void setName(String name) {
        Validate.validateName(name);
        this.name = name;
    }

    void addPlayer(Player player) {
        if (this.players != null) {
            this.players.add(player);
        }
    }

    void removePlayer(String name) {
        Player player = this.players
                .stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (player == null) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", name, this.name));
        } else {
            this.players.remove(player);
        }
    }

    double getRating() {
        return Math.round(this.players.stream().mapToDouble(Player::overallSkillLevel).average().orElse(0));
    }
}
