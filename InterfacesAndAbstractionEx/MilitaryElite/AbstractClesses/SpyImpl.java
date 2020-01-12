package InterfacesAndAbstractionEx.MilitaryElite.AbstractClesses;

import InterfacesAndAbstractionEx.MilitaryElite.Interfaces.InterfaceSpy;

public abstract class SpyImpl extends SoldierImpl implements InterfaceSpy {
    private String codeNumber;

    public SpyImpl(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.setCodeNumber(codeNumber);
    }

    private void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }

    @Override
    public String getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %d%sCode Number: %s",
                this.getFirstName(), this.getLastName(), this.getId(), System.lineSeparator(), this.getCodeNumber());
    }
}
