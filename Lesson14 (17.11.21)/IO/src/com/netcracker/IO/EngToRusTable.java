package com.netcracker.IO;

import java.util.HashMap;
import java.util.Map;

public class EngToRusTable {
    private static Map<Character, Character> symbolMap = new HashMap<>();
    static {
        symbolMap.put('a', 'а');
        symbolMap.put('A', 'А');
        symbolMap.put('e', 'е');
        symbolMap.put('E', 'Е');
        symbolMap.put('y', 'у');
        symbolMap.put('p', 'р');
        symbolMap.put('P', 'Р');
        symbolMap.put('x', 'х');
        symbolMap.put('X', 'Х');
        symbolMap.put('c', 'с');
        symbolMap.put('C', 'С');
        symbolMap.put('M', 'М');
        symbolMap.put('T', 'Т');
        symbolMap.put('B', 'В');
        symbolMap.put('K', 'К');
        symbolMap.put('H', 'Н');
    }

    public static char getSymbol(char c){
        if (symbolMap.keySet().contains(c)){
            return symbolMap.get(c);
        } else{
            return c;
        }
    }

    public static char getSymbol(int c){
        if (symbolMap.keySet().contains((char)c)){
            return symbolMap.get((char)c);
        } else{
            return (char)c;
        }
    }
}
