package org.loktevik;

import org.loktevik.fruits.Fruit;

import java.util.ArrayList;
import java.util.List;

public class MyShop<T> implements Shop<T>{
    private Farm<T> farm;
    private List<T> truckWithProducts;
    private int buyIndex = 0;

    public MyShop(Farm<T> farm){
        this.farm = farm;
        truckWithProducts = new ArrayList<>();
    }

    @Override
    public void requestProducts(int amount, Class<T> clazz) throws InstantiationException, IllegalAccessException {
        truckWithProducts = farm.sendFruitsToShop(amount, clazz);
    }

    @Override
    public T buy() {
        if (!truckWithProducts.isEmpty()){
            return truckWithProducts.remove(0);
        } else {
            return null;
        }
    }
}
