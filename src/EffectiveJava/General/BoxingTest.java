package EffectiveJava.General;

import java.util.Comparator;

public class BoxingTest {
    private static Comparator<Integer> naturalOrder = (i, j) -> (i < j) ? -1 : (i == j ? 0 : 1);

    public static void main(String[] args) {
        Integer comp = naturalOrder.compare(new Integer(42), new Integer(42));

        // 1이 출력됨... Boxing 된 기본타입에 == 연산자 사용시 오류가 발생한다
        System.out.println(comp);

        // Comparator의 정적메서드를 활용하여 해결
        Comparator<Integer> naturalOrder2 = Comparator.naturalOrder();
        System.out.println(naturalOrder2.compare(new Integer(42), new Integer(42)));
    }
}
