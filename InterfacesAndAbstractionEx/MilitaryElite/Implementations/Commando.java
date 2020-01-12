package InterfacesAndAbstractionEx.MilitaryElite.Implementations;

import InterfacesAndAbstractionEx.MilitaryElite.AbstractClesses.CommandoImpl;

public class Commando extends CommandoImpl {
    public Commando(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
    }
}
