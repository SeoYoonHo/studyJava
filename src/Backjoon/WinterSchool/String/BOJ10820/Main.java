package Backjoon.WinterSchool.String.BOJ10820;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        try (Scanner sc = new Scanner(System.in)) {
            List<String> stringList = new ArrayList<>();
            while (sc.hasNextLine()) {
                String str = sc.nextLine();

                if (str.isEmpty()) {
                    break;
                }
                stringList.add(str);
            }

            for (String str : stringList) {
                main.solution(str);
            }
        }
    }

    public void solution(String str) {
        long lowerCaseCount = str.chars().filter(Character::isLowerCase).count();
        long upperCaseCount = str.chars().filter(Character::isUpperCase).count();
        long digitCount = str.chars().filter(Character::isDigit).count();
        long spaceCount = str.chars().filter(Character::isSpaceChar).count();

        String sb = lowerCaseCount +
                " " +
                upperCaseCount +
                " " +
                digitCount +
                " " +
                spaceCount;

        System.out.println(sb);
    }
}
