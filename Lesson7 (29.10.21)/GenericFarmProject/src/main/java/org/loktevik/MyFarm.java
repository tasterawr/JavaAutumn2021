package org.loktevik;

import java.util.ArrayList;
import java.util.List;

public class MyFarm<T> implements Farm<T>{

    @Override
    public List<T> sendFruitsToShop(int amount, Class<T> clazz) throws InstantiationException, IllegalAccessException {
        List<T> products = new ArrayList<>();
        for (int i = 0; i < amount; i++){
            products.add(clazz.newInstance());
        }

        return products;
    }
}
