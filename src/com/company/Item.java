package com.company;

import java.util.ArrayList;
import java.util.List;

public class Item {
    String emoji;
    List<Level> usageLevel = new ArrayList<Level>();
    String usageType;
    public Item(String emoji) {
        this.emoji = emoji;
    }

    public String getEmoji() {
        return emoji;
    }
    public void addUsageLevel(Level l) {
        usageLevel.add(l);
    }
    public String getUsageType() {
        return  usageType;
    }
}
