package InterfacesAndAbstractionEx.CollectionHierarchy;

public class AddRemoveCollection extends Collection implements AddRemovable {

    @Override
    public int add(String s) {
        int index = 0;
        super.getItems().add(0, s);
        return index;
    }

    @Override
    public String remove() {
        int index = super.getItems().size() - 1;
        String item = super.getItems().remove(index);
        return item;
    }
}
