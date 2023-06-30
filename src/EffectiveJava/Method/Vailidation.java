package EffectiveJava.Method;

import java.util.Objects;

public class Vailidation {
    public static void main(String[] args) {
        // requireNonNull 메소드를 활용한 null 검사
        // null값일 시 nullPointerException 발생
        String str = null;
        String str1 = Objects.requireNonNull(str, "test");
        System.out.println(str1);
    }
}
