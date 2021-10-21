package org.loktevik;

public class MainClass {
    public static void main(String[] args) {
        Calculator calculator = new SumCalculator(4, 5);
        calculator.calculate();

        calculator = new SubtractionCalculator(10, 8);
        calculator.calculate();

        calculator = new MultiplicationCalculator(4, 20);
        calculator.calculate();

        calculator = new DivisionCalculator(15, 3);
        calculator.calculate();
    }
}
