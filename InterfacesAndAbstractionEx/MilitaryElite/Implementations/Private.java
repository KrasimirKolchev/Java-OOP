package InterfacesAndAbstractionEx.MilitaryElite.Implementations;

import InterfacesAndAbstractionEx.MilitaryElite.AbstractClesses.PrivateImpl;
import InterfacesAndAbstractionEx.MilitaryElite.Interfaces.InterfacePrivate;

public class Private extends PrivateImpl implements InterfacePrivate {
    public Private(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
    }
}
