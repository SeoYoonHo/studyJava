package Backjoon.WinterSchool.BOJ2744;

import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String str = sc.next();

            String res = new String(str.chars().map(operand -> {
                                           if (Character.isUpperCase(operand)) {
                                               return Character.toLowerCase(operand);
                                           } else {
                                               return Character.toUpperCase(operand);
                                           }
                                       }).mapToObj(c -> Character.toString((char) c))
                                       .collect(Collectors.joining())
                                       .toCharArray());

            System.out.println(res);
        }
    }

}
