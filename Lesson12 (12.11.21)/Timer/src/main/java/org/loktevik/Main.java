package org.loktevik;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Thread timer = new Thread(new Timer());
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Enter command (start/restart/stop): ");
            String command = scanner.nextLine();
            switch (command){
                case "start":
                    if (timer.isInterrupted()){
                        timer = new Thread(new Timer());
                        timer.start();
                    }
                    else if (!timer.isAlive()){
                        timer.start();
                    }
                    break;
                case "stop":
                    timer.interrupt();
                    break;
                case "restart":
                    Timer.reset();
            }
        }
    }
}
