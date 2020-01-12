package EncapsulationEx.FootballTeamGenerator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        Validate.validateName(name);
        this.name = name;
    }

    private int getEndurance() {
        return this.endurance;
    }

    private void setEndurance(int endurance) {
        Validate.validateStats(endurance, "Endurance");
        this.endurance = endurance;
    }

    private int getSprint() {
        return this.sprint;
    }

    private void setSprint(int sprint) {
        Validate.validateStats(sprint, "Sprint");
        this.sprint = sprint;
    }

    private int getDribble() {
        return this.dribble;
    }

    private void setDribble(int dribble) {
        Validate.validateStats(dribble, "Dribble");
        this.dribble = dribble;
    }

    private int getPassing() {
        return this.passing;
    }

    private void setPassing(int passing) {
        Validate.validateStats(passing, "Passing");
        this.passing = passing;
    }

    private int getShooting() {
        return this.shooting;
    }

    private void setShooting(int shooting) {
        Validate.validateStats(shooting, "Shooting");
        this.shooting = shooting;
    }

    double overallSkillLevel() {
        double result = this.getEndurance() + this.getSprint() + this.getDribble()
                + this.getPassing() + this.getShooting();
        result = result / 5;
        return result;
    }
}
