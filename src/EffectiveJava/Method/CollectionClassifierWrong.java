package EffectiveJava.Method;

import java.math.BigInteger;
import java.util.*;

public class CollectionClassifierWrong {
    public static String classify(Set<?> s) {
        return "집합";
    }

    public static String classify(List<?> lst) {
        return "리스트";
    }

    public static String classify(Collection<?> c) {
        return "그외";
    }

    public static void main(String[] args) {
        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<BigInteger>(),
                new HashMap<String, String>().values()
        };

        // 다중정의된 메서드중 선택될 메서드는 컴파일 타임에 이미 선택된다.
        // 즉 Collection 을 인자로 받는 classify 가 선택된다!
        for (Collection<?> c : collections) {
            System.out.println(classify(c));
        }
    }
}
