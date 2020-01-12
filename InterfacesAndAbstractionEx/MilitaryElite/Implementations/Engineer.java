package InterfacesAndAbstractionEx.MilitaryElite.Implementations;

import InterfacesAndAbstractionEx.MilitaryElite.AbstractClesses.EngineerImpl;

public class Engineer extends EngineerImpl {
    public Engineer(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
    }
}
