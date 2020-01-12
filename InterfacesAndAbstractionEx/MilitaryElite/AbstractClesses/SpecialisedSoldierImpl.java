package InterfacesAndAbstractionEx.MilitaryElite.AbstractClesses;

import InterfacesAndAbstractionEx.MilitaryElite.Interfaces.InterfaceSpecialisedSoldier;

public abstract class SpecialisedSoldierImpl extends PrivateImpl implements InterfaceSpecialisedSoldier {
    private static final String CORPS_AIRFORCES = "Airforces";
    private static final String CORPS_MARINES = "Marines";

    private String corps;

    SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.setCorps(corps);
    }

    private void setCorps(String corps) {
        if(corps == null) {
            this.corps = null;
            return;
        }

        switch (corps) {
            case SpecialisedSoldierImpl.CORPS_AIRFORCES:
                this.corps = SpecialisedSoldierImpl.CORPS_AIRFORCES;
                break;
            case SpecialisedSoldierImpl.CORPS_MARINES:
                this.corps = SpecialisedSoldierImpl.CORPS_MARINES;
                break;
            default:
                //throw new IllegalArgumentException("Invalid corps");
        }
    }

    @Override
    public String getCorps() {
        return this.corps;
    }
}
