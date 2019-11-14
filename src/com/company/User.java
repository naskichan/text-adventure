package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    List<Item> inventory = new ArrayList<Item>();

    String name;
    public User() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public String printInv() {
        String result = "";
        if(countInventory() == 0) {
            return "Your Inventory is empty";
        }
        for(Item obj : inventory) {
            result+=obj.emoji+" |";
        }
        return result;
    }
    public int countInventory() {
        int result = 0;
        for(Item obj : inventory) {
            result++;
        }
        return result;
    }
    public void addToInventory(Item i) {
        inventory.add(i);
    }
    public Item getItemFromInventoryByEmoji(String emoji) {
        Item result = new Item("Debug");
        for(Item obj : inventory) {
            if(obj.emoji.equals(emoji)) {
                result = obj;
            }
        }
        return result;
    }
    public void dropFromInventoryByEmoji(String emoji) {
        for(int i=0;i<inventory.size();i++) {
            if(inventory.get(i).emoji.equals(emoji)) {
                inventory.remove(i);
            }
        }
    }
    public boolean isItemContainedInInventoryByEmoji(String emoji) {
        boolean result = false;
        for(Item obj : inventory) {
            if(obj.emoji.equals(emoji)) {
                result = true;
            }
        }
        return result;
    }
    public boolean hasSword() {
        boolean result = false;
        for(int i=0; i<inventory.size(); i++) {
            if(inventory.get(i).emoji.equals("\uD83D\uDDE1")) {
                result = true;
            }
        }
        return result;
    }
    public boolean hasPrincess() {
        boolean result = false;
        for(int i=0; i<inventory.size(); i++) {
            if(inventory.get(i).emoji.equals("\uD83D\uDC78")) {
                result = true;
            }
        }
        return result;
    }
}