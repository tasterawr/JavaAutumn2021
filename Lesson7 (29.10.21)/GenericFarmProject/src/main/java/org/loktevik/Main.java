package org.loktevik;

import org.loktevik.fruits.Apple;
import org.loktevik.fruits.Fruit;
import org.loktevik.fruits.Orange;
import org.loktevik.fruits.Plum;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Shop<Apple> appleShop = new MyShop<>(new MyFarm<>());
        Shop<Plum> orangeShop = new MyShop<>(new MyFarm<>());
        appleShop.requestProducts(4, Apple.class);
        orangeShop.requestProducts(5, Plum.class);

        buyFromShop(appleShop, 2);
        buyFromShop(appleShop, 3);
        buyFromShop(orangeShop, 5);
    }

    public static void buyFromShop(Shop shop, int numOfBuys){
        System.out.println("Buying from shop:");
        for (int i = 0; i < numOfBuys; i++){
            Object product = shop.buy();
            if (product != null)
                System.out.println(product + " bought!");
            else
                System.out.println("Shop is empty!");
        }
        System.out.println();
    }
}
