package EffectiveJava.EnumStudy;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.stream.Collectors;

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

        // 5. EnumMap 사용 예제
        Plant[] garden = new Plant[6];
        garden[0] = new Plant("식물1", Plant.LifeCycle.ANNUAL);
        garden[1] = new Plant("식물2", Plant.LifeCycle.PERENNIAL);
        garden[2] = new Plant("식물3", Plant.LifeCycle.BIENNIAL);
        garden[3] = new Plant("식물4", Plant.LifeCycle.ANNUAL);
        garden[4] = new Plant("식물5", Plant.LifeCycle.PERENNIAL);
        garden[5] = new Plant("식물6", Plant.LifeCycle.BIENNIAL);

        // EnumMap을 사용안함
        System.out.println(Arrays.stream(garden).collect(Collectors.groupingBy(plant -> plant.lifeCycle)));

        // mapFactory 매개변수에 원하는 맵 구현체를 명시
        // 만약 ANNUAL에 해당하는 식물이 없다면 Set을 생성하지 않는다.
        System.out.println(
                Arrays.stream(garden).collect(Collectors.groupingBy(plant -> plant.lifeCycle, () -> new EnumMap<>(
                        Plant.LifeCycle.class), Collectors.toSet())));
    }
}
