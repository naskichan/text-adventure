package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Commands cmds = new Commands();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean playing = true;
        GameWorld world = new GameWorld();
        Level currentLevel = world.getStartLevel();
        Level lastLevel = currentLevel;

        User usr = new User();
        System.out.println("You wake up in a room of silence, you are cold, hurt and naked. Find a way out \uD83D\uDDE1️");
        while(playing) {
            //When starting the game loop, first the list of available commands and the inventory is printed to the console
            System.out.println("Commands  | "+cmds.printCmds());
            System.out.println("Inventory | "+usr.printInv());
            System.out.println(" ");
            System.out.println(currentLevel.initialDescription);
            if(currentLevel.bossFlag) {
                if(usr.hasPrincess()) {
                    if(!usr.hasSword()) {
                        System.out.println("You cant defend your princess against the ADDENTITYHERE");
                        playing = false;
                    }
                }
            }
            /*for(int i=0;i<4;i++) {
                System.out.println(" ");
            }*/
            //Then the dynamic parts of the game start where the description of the current level is printed
            if(currentLevel.impassable) {
                currentLevel = lastLevel;
            }
            String uInput = sc.nextLine();
            uInput = uInput.toLowerCase();
            if(isValidInput(parseInput(uInput))) {
                switch(parseInput(uInput)[0]) {
                    case "n" : { }
                    case "e" : { }
                    case "s" : { }
                    case "w" : {
                        System.out.println("You go "+cmds.printCommand(uInput));
                        Level nextLevel = currentLevel.getLevelInDirection(uInput);
                        lastLevel = currentLevel;
                        currentLevel = nextLevel;
                        break;
                    }
                    case "t" : {
                        String uItemName = parseInput(uInput)[1];
                        String emoji = cmds.parseInputToEmoji(uItemName);
                        if(currentLevel.containsItem(emoji)) {
                            System.out.println("You take the "+emoji+" in the room");
                            usr.addToInventory(currentLevel.getItemByEmoji(emoji));
                            currentLevel.removeItemByEmoji(emoji);
                        }
                        else {
                            System.out.println("There is no "+uItemName+" in the room");
                        }
                        break;
                    }
                    case "u" : {
                        String uItemName = parseInput(uInput)[1];
                        String emoji = cmds.parseInputToEmoji(uItemName);
                        if(usr.isItemContainedInInventoryByEmoji(emoji)) {
                            String usageType = usr.getItemFromInventoryByEmoji(emoji).getUsageType();
                            switch(usageType) {
                                case "key": {

                                }
                                case "press": {
                                    currentLevel.unlockNeighbor();
                                    usr.dropFromInventoryByEmoji(emoji);
                                }
                            }
                        }
                        else {
                            System.out.println("There is no "+uItemName+" to use");
                        }
                        break;
                    }
                    case "d" : {
                        String uItemName = parseInput(uInput)[1];
                        String emoji = cmds.parseInputToEmoji(uItemName);
                        if(!usr.isItemContainedInInventoryByEmoji(emoji)) {
                            System.out.println("There is no "+uItemName+" to drop");
                        } else {
                            currentLevel.addItemToMapInventory(usr.getItemFromInventoryByEmoji(emoji));
                            usr.dropFromInventoryByEmoji(emoji);
                            System.out.println("You throw the " + emoji + " into the room violently");
                            break;
                        }
                    }
                }

            }
        }
        System.out.println("You are dead");
    }
    //Uses the List of valid Inputs from the Commands class to determine if the user used a valid command
    //Input: String | Output: Boolean
    //Usage: isValidInput("n") => true isValidInput("Gulasch") => false
    public static String[] parseInput(String uInput) {
        String[] result = uInput.split(" ");
        return result;
    }
    public static boolean isValidInput(String[] input) {
        for(String obj : cmds.getCmds()) {
            if(input[0].equals(obj)) {
                return true;
            }
        }
        return false;
    }
}
