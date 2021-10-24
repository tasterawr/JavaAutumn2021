package org.loktevik.singleton;

public class SingletonClass {
    private static SingletonClass singletonClass;

    public SingletonClass(){ }

    public static SingletonClass getInstance(){
        if (singletonClass == null) {
            singletonClass = new SingletonClass();
        }
        return singletonClass;
    }
}
