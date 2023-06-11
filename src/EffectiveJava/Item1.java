package EffectiveJava;

import java.util.function.Supplier;

public class Item1 {
    public static void main(String[] args) {
        Supplier<Item1> supplier = () -> new Item1();

        supplier.get();
    }
}
