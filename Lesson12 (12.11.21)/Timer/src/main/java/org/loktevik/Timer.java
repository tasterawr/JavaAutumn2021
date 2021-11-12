package org.loktevik;

public class Timer implements Runnable {
    private static int value;

    @Override
    public void run() {
        System.out.println("Timer started.");
        while(!Thread.currentThread().isInterrupted()){
            value++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        System.out.println("Timer stopped: " + value);
    }

    public static void reset(){
        value = 0;
    }
}
