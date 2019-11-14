package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class Commands {
    //Gegner läuft die ganze Zeit durch die Karte
    List<String> lst = new ArrayList<String>();
    Map<String, String> inputToEmoji = new HashMap<String, String>();

    //Initialize Command List inside of Constructor
    public Commands() {
        lst.add("North");
        lst.add("East");
        lst.add("South");
        lst.add("West");
        lst.add("Use");
        lst.add("Take");
        lst.add("Drop");
        inputToEmoji.put("sword", "\uD83D\uDDE1");
        inputToEmoji.put("knife", "\uD83D\uDDE1");
        inputToEmoji.put("dagger", "\uD83D\uDDE1");
        inputToEmoji.put("schwert", "\uD83D\uDDE1");
        inputToEmoji.put("messer", "\uD83D\uDDE1");
        inputToEmoji.put("bomb", "\uD83D\uDCA3");
        inputToEmoji.put("bombe", "\uD83D\uDCA3");
        inputToEmoji.put("explosives", "\uD83D\uDCA3");
        inputToEmoji.put("key", "\uD83D\uDDDD");
        inputToEmoji.put("schlüssel", "\uD83D\uDDDD");
        inputToEmoji.put("mask", "\uD83E\uDD3F");
        inputToEmoji.put("gasmask", "\uD83E\uDD3F");
        inputToEmoji.put("gasmaske", "\uD83E\uDD3F");
        inputToEmoji.put("maske", "\uD83E\uDD3F");
        inputToEmoji.put("hammer", "\uD83D\uDD28");
        inputToEmoji.put("princess", "\uD83D\uDC78");
        inputToEmoji.put("prinzessin", "\uD83D\uDC78");
        inputToEmoji.put("prinz", "\uD83D\uDC78");
        inputToEmoji.put("prince", "\uD83D\uDC78");
        inputToEmoji.put("manita", "\uD83D\uDC78");
        inputToEmoji.put("button", "\uD83D\uDECE");
        inputToEmoji.put("knopf", "\uD83D\uDECE");
        inputToEmoji.put("fernbedienung", "\uD83D\uDECE");
        inputToEmoji.put("bell", "\uD83D\uDECE");
    }

    //Function for getting All Commands in an ArrayList
    public List<String> getCmds() {
        List<String> result = new ArrayList<String>();
        for(String obj : lst) {
            result.add(obj.toLowerCase().substring(0,1));
        }
        return result;
    }
    public String printCommand(String input) {
        for(String obj : lst) {
            if(obj.substring(0,1).toLowerCase().equals(input)) {
                return obj;
            }
        }
        return "";
    }
    //Prints Commands in the following Pattern: [firstLetter]+secondToLastLetter;
    //Example: [G]ulasch
    public String printCmds() {
        String result = "";
        for (String obj : lst) {
            //System.out.println("["+obj.substring(0,1)+"]"+obj.substring(1,obj.length()));
            result+=("["+obj.substring(0,1)+"]"+obj.substring(1,obj.length())+ " | ");
        }
        return result;
    }
    public String parseInputToEmoji(String uInput) {
        String result = "Debug";
        if(inputToEmoji.containsKey(uInput)) {
            result = inputToEmoji.get(uInput);
        }
        return result;
    }
}
