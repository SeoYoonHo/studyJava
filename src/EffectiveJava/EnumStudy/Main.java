package EffectiveJava.EnumStudy;

import java.util.EnumSet;

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

        // 4. EnumSet 사용 --> 어떤 Set을 넘겨도 되나, EnumSet이 가장 좋다.
        Text text = new Text();
        text.applyStyle(EnumSet.of(Text.Style.BOLD, Text.Style.UNDERLINE));
    }
}
