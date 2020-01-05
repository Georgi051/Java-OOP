package spaceStation.models;

import spaceStation.common.ConstantMessages;
import spaceStation.models.bags.Bag;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Backpack implements Bag {
    private List<String> items;

    public Backpack() {
        this.items = new ArrayList<>();
    }

    @Override
    public Collection<String> getItems() {
        return this.items;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.getItems().size() == 0) {
            sb.append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS, "none"));
        } else {
            sb.append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS,
                    String.join(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER, this.getItems())));
        }
        return sb.toString().trim();
    }
}
