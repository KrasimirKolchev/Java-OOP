package InterfacesAndAbstractionEx.MilitaryElite.addons;

public class Mission {
    private String codeName;
    private String state;

    public Mission(String codeName, String state) {
        this.codeName = codeName;
        this.setState(state);
    }

    private void setState(String state) {
        if (state.equals("Finished") || state.equals("inProgress")) {
            this.state = state;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return String.format("  Code Name: %s State: %s", this.codeName, this.state);
    }
}
