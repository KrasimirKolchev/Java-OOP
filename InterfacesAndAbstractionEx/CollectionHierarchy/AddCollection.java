package InterfacesAndAbstractionEx.CollectionHierarchy;

public class AddCollection extends Collection implements Addable {

    @Override
    public int add(String s) {
        int index = super.getItems().size();
        super.getItems().add(s);
        return index;
    }
}
