package spaceStation.models.bags;

import spaceStation.common.ConstantMessages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class Backpack implements Bag {

    private Collection<String> data;

    public Backpack() {
        this.data = new ArrayList<>();
    }

    @Override
    public Collection<String> getItems() {
        return this.data;
    }

    @Override
    public String toString() {
        String result = "";

        if (data.size() > 0) {
            result += data.stream().collect(Collectors.joining(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER));
        } else {
            result += "none";
        }

        return result;
    }
}
