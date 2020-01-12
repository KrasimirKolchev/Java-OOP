package InterfacesAndAbstractionEx.CollectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {
    private int maxSize = 100;
    private List<String> items;

    public Collection() {
        this.items = new ArrayList<>(maxSize);
    }

    public List<String> getItems() {
        return this.items;
    }

    public int getMaxSize() {
        return this.maxSize;
    }
}
