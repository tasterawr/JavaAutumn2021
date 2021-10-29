package org.loktevik;

public class Main {
    public static void main(String[] args) {
        NumberProvider<Integer> integerNumberProvider = new NumberProvider<>();
        NumberProvider<Double> doubleNumberProvider = new NumberProvider<>();

        integerNumberProvider.setValue(5);
        doubleNumberProvider.setValue(4.7);

        System.out.println(integerNumberProvider.getAsDouble());
        System.out.println(integerNumberProvider.getAsShort());

        System.out.println(doubleNumberProvider.getAsByte());
        System.out.println(doubleNumberProvider.getAsString());
    }
}
