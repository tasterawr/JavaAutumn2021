package org.loktevik.service;

import org.loktevik.domain.Verb;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class VerbService {
    private static VerbService instance;
    private final String PATH = "src/main/resources/verbs.csv";
    private final List<Verb> verbs = new ArrayList<>();

    private VerbService() {
        try(Scanner scanner = new Scanner(new File(PATH))){
            while (scanner.hasNextLine()){
                String [] line = scanner.nextLine().split(";");
                verbs.add(new Verb(line[0], line[1],line[2],line[3]));
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static VerbService getInstance(){
        if (instance == null){
            instance = new VerbService();
        }

        return instance;
    }

    public List<Verb> getModifiableVerbs(){
        return verbs;
    }

    public List<Verb> getVerbs(){
        return Collections.unmodifiableList(verbs);
    }
}
