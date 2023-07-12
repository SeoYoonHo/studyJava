package EffectiveJava;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.function.Supplier;

public class Item1 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        int dayWeek = (int) (date.getLong(ChronoField.EPOCH_DAY) + 12) % 14 + 1;
        System.out.println(dayWeek);
    }
}
