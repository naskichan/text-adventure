package com.company;

import java.util.*;

public class GameWorld {
    //Bei bidirektoinalität nicht notwendig
    Level Cell = new Level("Debug Cell"); // North Floor
    Level FloorMain = new Level("Debug Floor Main"); // South Cell , East Lab
    Level Lab = new Level("Debug Lab, Button"); //West Floor
    Level Bathroom = new Level("Debug Bathroom");
    Level Escape = new Level("Debug Escape");
    Level Locker = new Level("Debug Locker, Mask");
    Level FloorChoice = new Level("There is a HUGE Vault Door, Time"); //North
    Level Storage = new Level("Debug Storage Key, Bomb");
    Level KillerDog = new Level("Debug KillerDog, Sword");
    Level FIL1 = new Level("Debug FIL");
    Level FIL2 = new Level("Debug FIL");
    Level FIL3 = new Level("Debug FIL");
    Level FIL4 = new Level("Debug FIL");
    Level FIL5 = new Level("Debug FIL");
    Level FIL6 = new Level("Debug FIL");
    Level FIL7 = new Level("Debug FIL");
    Level FloorSub = new Level("Debug Floor Sub, Timer end");
    Level Gas = new Level("Debug Gas, Hammer");
    Level Princess = new Level("Debug Princess, Princess");
    Item sword = new Item("\uD83D\uDDE1");
    Item bomb = new Item("\uD83D\uDCA3");
    Item key = new Item("\uD83D\uDDDD");
    Item mask = new Item("\uD83E\uDD3F");
    Item hammer = new Item("\uD83D\uDD28");
    Item princess = new Item("\uD83D\uDC78");
    Item button = new Item("\uD83D\uDECE");


    public GameWorld() {
        addAdjacentLevel(Cell, FloorMain, "n");
        addAdjacentLevel(FloorMain, Lab, "e");
        addAdjacentLevel(FloorMain, FloorSub, "w"); //Impassable
        addAdjacentLevel(FloorMain, FloorChoice, "n"); //Impassable
        addAdjacentLevel(Lab, Bathroom, "e");
        addAdjacentLevel(Lab, Locker, "s");
        addAdjacentLevel(Bathroom, Escape, "e"); //Impassable
        addAdjacentLevel(FloorChoice, Storage, "e");
        addAdjacentLevel(FloorChoice, KillerDog, "n");
        addAdjacentLevel(FloorChoice, FIL1, "w"); //Impassable
        addAdjacentLevel(FIL1, FIL2, "w");
        addAdjacentLevel(FIL2, FIL3, "n");
        addAdjacentLevel(FIL3, FIL4, "n");
        addAdjacentLevel(FIL4, FIL5, "w");
        addAdjacentLevel(FIL5, FIL6, "w");
        addAdjacentLevel(FIL6, FIL7, "s");
        addAdjacentLevel(FIL7, FloorSub, "w"); //Warning impassable
        addAdjacentLevel(FloorSub, Gas, "n");
        addAdjacentLevel(FloorSub, Princess, "w");
        FloorSub.setImpassable(true);
        FloorChoice.setImpassable(true);
        Escape.setImpassable(true);
        FIL1.setImpassable(true);
        Cell.addImpassablesDescribed("", "There is a Wall", "There is a window up high. You can´t reach it", "There is a bed standing next to the wall");
        FloorMain.addImpassables();
        Lab.addImpassables();
        Bathroom.addImpassables();
        Escape.addImpassables();
        Locker.addImpassables();
        FloorChoice.addImpassables();
        Storage.addImpassables();
        KillerDog.addImpassables();
        FIL1.addImpassables();
        FIL2.addImpassables();
        FIL3.addImpassables();
        FIL4.addImpassables();
        FIL5.addImpassables();
        FIL6.addImpassables();
        FIL7.addImpassables();
        FloorSub.addImpassables();
        Gas.addImpassables();
        Princess.addImpassables();
        FloorSub.setBossFlag(true);
        FloorChoice.setUnlockable(true);
        FIL1.setUnlockable(true);
        Escape.setUnlockable(true);
        Lab.addItemToMapInventory(button);
        Locker.addItemToMapInventory(mask);
        Storage.addItemToMapInventory(key);
        Storage.addItemToMapInventory(bomb);
        KillerDog.addItemToMapInventory(sword);
        Gas.addItemToMapInventory(hammer);
        Princess.addItemToMapInventory(princess);
        button.usageType = "press";
        FloorChoice.addUsableItem(button);
        hammer.usageType = "key";
        Escape.addUsableItem(hammer);
        bomb.usageType = "key";
        KillerDog.addUsableItem(bomb);
        mask.usageType = "key";
        Gas.addUsableItem(mask);
        sword.usageType = "key";
        Princess.addUsableItem(sword);

    }
    public void addAdjacentLevel(Level lvl1, Level lvl2, String direction) {
        lvl1.addAdjacentLevel(lvl2, direction);
        lvl2.addAdjacentLevel(lvl1, lvl1.getOppositeDirection(direction));
    }
    public Level getStartLevel() {
        return Cell;
    }
}

/*
[][][][][][]
[][][][][][]
[][][x][o][x][]
[][][x][o][x][]
[][][][x][][]
[][][][][][]
*/