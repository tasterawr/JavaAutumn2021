package com.netcracker.domain.util;

public class Pair <T, R>{
    private T firstElement;
    private R secondElement;

    public Pair(){}

    public Pair(T firstElement, R secondElement){
        this.firstElement = firstElement;
        this.secondElement = secondElement;
    }

    public T getFirstElement() {
        return firstElement;
    }

    public void setFirstElement(T firstElement) {
        this.firstElement = firstElement;
    }

    public R getSecondElement() {
        return secondElement;
    }

    public void setSecondElement(R secondElement) {
        this.secondElement = secondElement;
    }

    @Override
    public String toString() {
        return "[" + firstElement + ", " + secondElement + "]";
    }
}
