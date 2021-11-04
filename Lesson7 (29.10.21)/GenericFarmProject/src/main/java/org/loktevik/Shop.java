package org.loktevik;

import org.loktevik.fruits.Fruit;

public interface Shop <T>{

    void requestProducts(int amount, Class<T> clazz) throws InstantiationException, IllegalAccessException;

    T buy();
}
