package Backjoon.WinterSchool.BOJ2675;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int caseCount = sc.nextInt();
            List<Integer> rArr = new ArrayList<>();
            List<String> sArr = new ArrayList<>();

            for (int c = 0; c < caseCount; c++) {
                int R = sc.nextInt();
                String S = sc.next();
                rArr.add(R);
                sArr.add(S);
            }

            for (int c = 0; c < rArr.size(); c++) {
                int R = rArr.get(c);
                String S = sArr.get(c);

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < S.length(); i++) {
                    String tempStr = S.substring(i, i + 1);
                    sb.append(tempStr.repeat(Math.max(0, R)));
                }

                System.out.println(sb);
            }
        }
    }
}
