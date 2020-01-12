package InterfacesAndAbstractionEx.MilitaryElite.AbstractClesses;

import InterfacesAndAbstractionEx.MilitaryElite.Implementations.Private;
import InterfacesAndAbstractionEx.MilitaryElite.Interfaces.InterfaceLeutenantGeneral;

import java.util.*;


public abstract class LeutenantGeneralImpl extends PrivateImpl implements InterfaceLeutenantGeneral {
    private Map<Integer, PrivateImpl> privates;

    public LeutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new TreeMap<>(Comparator.reverseOrder());
    }

    private Map<Integer, PrivateImpl> getPrivates() {
        return this.privates;
    }

    @Override
    public void addPrivate(Private priv) {
        this.privates.put(priv.getId(), priv);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s Id: %d Salary: %.2f",
                this.getFirstName(), this.getLastName(), this.getId(), this.getSalary()));
        sb.append(System.lineSeparator()).append("Privates:");

        this.getPrivates().values().forEach(p -> sb.append(System.lineSeparator()).append("  ").append(p.toString()));

        return sb.toString();
    }

}
