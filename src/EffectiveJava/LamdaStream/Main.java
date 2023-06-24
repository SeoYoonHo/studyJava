package EffectiveJava.LamdaStream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        double x = 1.0;
        double y = 2.0;

        // 1.toString 재정의
        for (EffectiveJava.EnumStudy.Operation op : EffectiveJava.EnumStudy.Operation.values()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }

        // 2.valueOf 사용법
        Operation o = Operation.valueOf("PLUS");
        System.out.println(o.apply(x, y));

        // 3.fromString 사용
        Operation plusOperation = Operation.fromString("+")
                                           .orElseThrow();
        System.out.println(plusOperation.apply(x, y));

        // 4.메서드 참조 이용
        // 이미 메서드 참조를 제공한다면 람다식보다는 메서드 참조를 이용하는게 코드가 더 깔끔하다
        Map<Integer, Integer> map = new HashMap<>();
        Integer key = 1;
        map.merge(key, 1, (integer, integer2) -> integer + integer2);
        // 4-1. 정적 메서드 참조
        map.merge(key, 1, Integer::sum);
        System.out.println(map);

        Bicycle bicycle1 = new Bicycle("panda");
        Bicycle bicycle2 = new Bicycle("bear");
        List<Bicycle> bicycles = new ArrayList<>();
        bicycles.add(bicycle1);
        bicycles.add(bicycle2);

        // 4-2 한정적 인스턴스(bound) --> 이미 존재하는 인스턴스의 메소드 활용
        List<String> unbound_bicycleYahos = bicycles.stream()
//                                                    .map(bicycle -> bicycle1.getYaho(bicycle))
                                                    .map(bicycle1::getYaho)
                                                    .collect(Collectors.toList());
        System.out.println(unbound_bicycleYahos);

        // 4-3 비한정적 인스턴스(unbound) --> 인스턴스의 타입만 알고 있을때
        List<String> bound_bicycleYahos = bicycles.stream()
//                                                  .map(bicycle -> bicycle.getYaho())
                                                  .map(Bicycle::getYaho)
                                                  .collect(Collectors.toList());
        System.out.println(bound_bicycleYahos);
    }
}
