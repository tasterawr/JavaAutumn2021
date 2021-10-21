package org.loktevik;

public class MultiplicationCalculator implements Calculator{
    private double firstParam;
    private double secondParam;

    public MultiplicationCalculator(){ };

    public MultiplicationCalculator(double firstParam, double secondParam){
        this.firstParam = firstParam;
        this.secondParam = secondParam;
    }

    public double getFirstParam() {
        return firstParam;
    }

    public void setFirstParam(double firstParam) {
        this.firstParam = firstParam;
    }

    public double getSecondParam() {
        return secondParam;
    }

    public void setSecondParam(double secondParam) {
        this.secondParam = secondParam;
    }

    @Override
    public void calculate() {
        System.out.println(firstParam * secondParam);
    }
}
