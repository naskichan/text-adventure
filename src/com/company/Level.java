package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class Level {
    //An adjacent level exists of a direction and the level object per sé
    Map<String, Level> adjacentLevels = new HashMap<String, Level>();
    String initialDescription;
    boolean isUnlockable = false;
    int timesVisited = 0;
    boolean impassable = false;
    boolean bossFlag = false;
    List<Item> items = new ArrayList<Item>();
    Item usableItem; //Contains Emoji value of an Item
    String usageWay; // Contains a string order to determine the function the use call does
    public Level(String description) {
        this.initialDescription = description;
    }
    public void addAdjacentLevel(Level l, String direction) {
        adjacentLevels.put(direction, l);
    }
    public String getOppositeDirection(String dir) {
        switch(dir) {
            case "s": return "n";
            case "n": return "s";
            case "w": return "e";
            case "e": return "w";
            default: return null;
        }
    }
    public void setImpassable(boolean input) {
        impassable = input;
    }

    public boolean isPassable() {
        return impassable;
    }

    public Level getLevelInDirection(String direction) {
        return adjacentLevels.get(direction);
    }

    public void addImpassables() {
        Level catchWall = new Level("There is a Wall");
        catchWall.setImpassable(true);
        if(!adjacentLevels.containsKey("n")) { adjacentLevels.put("n", catchWall); }
        if(!adjacentLevels.containsKey("e")) { adjacentLevels.put("e", catchWall); }
        if(!adjacentLevels.containsKey("s")) { adjacentLevels.put("s", catchWall); }
        if(!adjacentLevels.containsKey("w")) { adjacentLevels.put("w", catchWall); }
    }
    public void addImpassablesDescribed(String desNorth, String desEast, String desSouth, String desWest) {
        Level n = new Level(desNorth);
        n.setImpassable(true);
        Level e = new Level(desEast);
        e.setImpassable(true);
        Level s = new Level(desSouth);
        s.setImpassable(true);
        Level w = new Level(desWest);
        w.setImpassable(true);
        if(!adjacentLevels.containsKey("n")) { adjacentLevels.put("n", n); }
        if(!adjacentLevels.containsKey("e")) { adjacentLevels.put("e", e); }
        if(!adjacentLevels.containsKey("s")) { adjacentLevels.put("s", s); }
        if(!adjacentLevels.containsKey("w")) { adjacentLevels.put("w", w); }
    }

    public int getTimesVisited() {
        return timesVisited;
    }
    public boolean containsItem(String emoji) {
        boolean result = false;
        for(Item obj : items) {
            if(obj.emoji.equals(emoji)) {
                result = true;
            }
        }
        return result;
    }
    public Item getItemByEmoji(String emoji) {
        Item result = new Item("Debug");
        for(Item obj : items) {
            if(obj.emoji.equals(emoji)) {
                result = obj;
            }
        }
        return result;
    }
    public void removeItemByEmoji(String emoji) {
        for(int i=0; i<items.size(); i++) {
            if(items.get(i).emoji.equals(emoji)) {
                items.remove(i);
            }
        }
    }

    public void addItemToMapInventory(Item i) {
        items.add(i);
    }
    public void printItems() {
        System.out.println("The map inventory contains:");
        for(Item obj : items) {
            System.out.println(obj.emoji);
        }
    }
    public void addUsableItem(Item i) {
        usableItem = i;
    }
    public void setUnlockable(Boolean input) {
        isUnlockable = input;
    }
    public void unlockNeighbor() {
        System.out.println("Neighbor north is: "+adjacentLevels.get("n").isUnlockable);
        if(adjacentLevels.get("n").isUnlockable) {
            System.out.println("was true");
            adjacentLevels.get("n").setImpassable(false);
        }
        System.out.println("Neighbor east is: "+adjacentLevels.get("e").isUnlockable);
        if(adjacentLevels.get("e").isUnlockable) {
            adjacentLevels.get("e").setImpassable(false);
        }
        System.out.println("Neighbor south is: "+adjacentLevels.get("s").isUnlockable);
        if(adjacentLevels.get("s").isUnlockable) {
            adjacentLevels.get("s").setImpassable(false);
        }
        System.out.println("Neighbor west is: "+adjacentLevels.get("w").isUnlockable);
        if(adjacentLevels.get("w").isUnlockable) {
            adjacentLevels.get("w").setImpassable(false);
        }
    }
    public void setBossFlag(boolean input) {
        bossFlag = input;
    }

}