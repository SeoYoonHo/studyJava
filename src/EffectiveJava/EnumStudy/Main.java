package EffectiveJava.EnumStudy;

public class Main {
    public static void main(String[] args) {
        double x = 1.0;
        double y = 2.0;

        // 1.toString 재정의
        for (Operation op : Operation.values()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }

        // 2.valueOf 사용법
        Operation o = Operation.valueOf("PLUS");
        System.out.println(o.apply(x, y));


        // 3.fromString 사용
        Operation plusOperation = Operation.fromString("+").orElseThrow();
        System.out.println(plusOperation.apply(x, y));
    }
}
