package InterfacesAndAbstractionEx.MilitaryElite.Implementations;

import InterfacesAndAbstractionEx.MilitaryElite.AbstractClesses.SpyImpl;
import InterfacesAndAbstractionEx.MilitaryElite.Interfaces.InterfaceSpy;

public class Spy extends SpyImpl implements InterfaceSpy {
    public Spy(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName, codeNumber);
    }
}
