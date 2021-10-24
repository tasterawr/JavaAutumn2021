package org.loktevik;

import org.loktevik.circle.Circle;
import org.loktevik.singleton.SingletonClass;

public class MainClass {
    public static void main(String[] args) {
        Circle circle = new Circle(4, 5);

        //недоступен
        //Point point = new Point(4, 5);

        SingletonClass singletonClass = SingletonClass.getInstance();
        SingletonClass singletonClass1 = SingletonClass.getInstance();

        System.out.println(singletonClass);
        System.out.println(singletonClass1);
    }
}
