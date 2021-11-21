package com.netcracker.IO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try(EngToRusReader reader = new EngToRusReader(new FileReader(".\\resources\\file.txt"))){
            char[] cbuf = new char[10];
            int result = reader.read(cbuf, 0, 10);
            System.out.println(result);
            for (Character c : cbuf){
                System.out.println(Character.toLowerCase(c));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try(EngToRusWriter writer = new EngToRusWriter(new FileWriter(".\\resources\\file.txt"))){
            String str = "WE LOVE TEATP";
            writer.write(str, 0, str.length());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
