package InterfacesAndAbstractionEx.CollectionHierarchy;

public class MyListImpl extends Collection implements MyList {

    @Override
    public String remove() {
        int index = 0;
        String item = super.getItems().remove(index);
        return item;
    }

    @Override
    public int getUsed() {
        return super.getItems().size();
    }

    @Override
    public int add(String s) {
        int index = 0;
        super.getItems().add(index, s);
        return index;
    }
}
