package EffectiveJava.EnumStudy;

public class Main {
    public static void main(String[] args) {
        double x = 1.0;
        double y = 2.0;

        for (Operation op : Operation.values()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }
}
