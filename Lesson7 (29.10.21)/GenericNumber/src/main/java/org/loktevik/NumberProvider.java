package org.loktevik;

public class NumberProvider <T extends Number>{

    private T value;

    public int getAsInt(){
        return value.intValue();
    }

    public double getAsDouble(){
        return value.doubleValue();
    }

    public String getAsString(){
        return value.toString();
    }

    public byte getAsByte(){
        return value.byteValue();
    }

    public float getAsFloat(){
        return value.floatValue();
    }

    public Short getAsShort(){
        return value.shortValue();
    }

    public void setValue(T value){
        this.value = value;
    }
}
