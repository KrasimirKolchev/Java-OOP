package EncapsulationEx.FootballTeamGenerator;

public class Validate {

    static void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
    }

    static void validateStats(int stat, String type) {
        if (stat < 0 || stat > 100) {
            throw new IllegalArgumentException(String.format("%s should be between 0 and 100.", type));
        }
    }
}
