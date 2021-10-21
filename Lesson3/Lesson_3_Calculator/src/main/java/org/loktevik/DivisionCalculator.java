package org.loktevik;

public class DivisionCalculator implements Calculator{

    private double firstParam;
    private double secondParam;

    public DivisionCalculator(){ };

    public DivisionCalculator(double firstParam, double secondParam){
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
        System.out.println(firstParam / secondParam);
    }
}
