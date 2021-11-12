package org.loktevik;

public class Main {
    public static void main(String[] args) {
        Thread chickenThread = new Thread(new Chicken());
        Thread eggThread = new Thread(new Egg());
        chickenThread.start();
        eggThread.start();
    }
}

class Chicken implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++){
            System.out.println("Chicken!");
        }
    }
}

class Egg implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++){
            System.out.println("Egg!");
        }
    }
}
