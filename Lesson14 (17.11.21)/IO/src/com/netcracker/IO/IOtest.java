package com.netcracker.IO;

import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IOtest {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(".\\resources\\file.txt");
        FileInputStream fileInputStream2 = new FileInputStream(".\\resources\\file.txt");

//        int c;
//        while ((c = fileInputStream.read()) != -1) {
//            System.out.print((char) c);
//        }
//
//        byte[] mas = new byte[fileInputStream.available()];
//        byte[] mas2 = new byte[fileInputStream.available()];
//        System.out.println(fileInputStream.available());
//        int read = fileInputStream.read(mas, 0, fileInputStream.available());
//        int read2 = fileInputStream2.read(mas2);
//        String s = new String(mas);
//        System.out.println(s);

        DataInputStream dataInputStream = new DataInputStream(fileInputStream);
//        int c;
//        while ((c = dataInputStream.readInt()) != -1) {
//            System.out.print(c);
//        }

        System.out.println();
        FileReader fileReader = new FileReader(".\\resources\\file.txt");

//        int c1;
//        while ((c1 = fileReader.read()) != -1) {
//            System.out.print((char) c1);
//        }

        System.out.println();
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
//        while ((line = bufferedReader.readLine()) != null) {
//            System.out.println(line);
//        }
        List<String> collect = bufferedReader.lines().collect(Collectors.toList());


//        File file = new File(".\\resources\\file.txt");
//        BufferedReader reader3 = new BufferedReader(new FileReader(file));
//        String line3 = null;
//        while ((line3 = reader3.readLine()) != null) {
//            System.out.println(line3);
//        }

        Path resource = Paths.get(".", "resources", "file.txt");
        Files
                .lines(resource)
                .forEach(System.out::println);

    }

    public static Stream<String> method(Path resource) throws IOException {
        return Files.lines(resource);
    }
}
