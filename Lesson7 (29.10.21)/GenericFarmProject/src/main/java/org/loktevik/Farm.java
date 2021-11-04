package org.loktevik;

import java.util.List;

public interface Farm <T>{
    List<T> sendFruitsToShop(int amount, Class<T> clazz) throws InstantiationException, IllegalAccessException;
}
