package org.loktevik;

import org.loktevik.mylist.MyLinkedList;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new MyLinkedList<>();
        System.out.println("Лист пустой: " + list.isEmpty());
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("Лист пустой: " + list.isEmpty());
        System.out.println("Размер: " + list.size());
        System.out.println("Элемент по индексу 2: " + list.get(2));

        System.out.println();
        Object[] array = list.toArray();
        System.out.print("Как массив: ");
        for (Object o : array){
            System.out.print(o + " ");
        }

        list.remove(1);

        System.out.println();
        array = list.toArray();
        System.out.print("Удален элемент с индексом 1: ");
        for (Object o : array){
            System.out.print(o + " ");
        }

        List<Integer> list2 = new MyLinkedList<>();
        list2.add(5);
        list2.add(6);

        list.addAll(1, list2);

        System.out.println();
        System.out.print("Вставка коллекции по индексу 1: ");
        for (Object o : list.toArray()){
            System.out.print(o + " ");
        }

        list.add(2, 10);
        System.out.println();
        System.out.print("Вставка элемента 10 по индексу 2: ");
        for (Object o : list.toArray()){
            System.out.print(o + " ");
        }

        System.out.println();
        System.out.print("Передача массива контейнера: ");
        for (Object o : list.toArray(new Object[6])){
            System.out.print(o + " ");
        }

        list.clear();
        System.out.println();
        System.out.println("Размер списка после очистки: " + list.size());
    }
}
