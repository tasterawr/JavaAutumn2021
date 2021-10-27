package org.loktevik.exceptions;

public class Main {
    public static void main(String[] args) {
        Image image = new Image(-300, 200);
        image.reshape(100, -200);
    }
}
