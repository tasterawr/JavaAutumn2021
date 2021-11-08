package org.loktevik;

import org.loktevik.domain.Verb;
import org.loktevik.service.VerbService;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        VerbService verbService = VerbService.getInstance();
        List<Verb> modifiableVerbs = verbService.getModifiableVerbs();
        Collections.shuffle(modifiableVerbs);
        System.out.println("Вывод перемешанных глаголов:");
        modifiableVerbs.forEach(System.out::println);

        TreeSet<Verb> sortedSet = new TreeSet<>(Comparator.comparing(Verb::getRusName).thenComparing(Verb::getInfinitive));
        sortedSet.addAll(verbService.getVerbs());
        System.out.println("\nВывод отсортированных глаголов:");
        sortedSet.forEach(System.out::println);

        Iterator<Verb> iterator = sortedSet.iterator();
        Verb startFromC = null;
        Verb startFromT = null;
        while (iterator.hasNext()){
            Verb cur = iterator.next();
            if (cur.getRusName().charAt(0) == 'с' && startFromC == null){
                System.out.println(cur);
                startFromC = cur;
            }
            if (cur.getRusName().charAt(0) == 'т' && startFromT == null){
                System.out.println(cur);
                startFromT = cur;
                break;
            }
        }
        System.out.println("\nПервый глагол, начинающийся на 'с':");
        System.out.println(startFromC);
        System.out.println("\nПервый глагол, начинающийся на 'т':");
        System.out.println(startFromT);

        Iterator<Verb> backIterator = sortedSet.descendingIterator();
        Verb end = null;
        while (backIterator.hasNext()){
            Verb cur = backIterator.next();
            if (cur.getRusName().charAt(0) == 'т'){
                end = cur;
                break;
            }
        }

        NavigableSet<Verb> subSet1 = sortedSet.subSet(startFromC, true,
                end, true);
        System.out.println("\nГлаголы, начинающееся с 'с' и 'т':");
        subSet1.forEach(System.out::println);
    }
}
