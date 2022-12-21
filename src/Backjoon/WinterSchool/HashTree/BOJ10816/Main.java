package Backjoon.WinterSchool.HashTree.BOJ10816;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            Map<Integer, Integer> cardMap = new HashMap<>();
            for (int i = 0; i < N; i++) {
                int temp = sc.nextInt();
                if (cardMap.containsKey(temp)) {
                    cardMap.put(temp, cardMap.get(temp) + 1);
                } else {
                    cardMap.put(temp, 1);
                }
            }

            int M = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                int temp = sc.nextInt();
                Integer cnt = cardMap.get(temp);

                sb.append(cnt == null ? 0 : cnt);
                sb.append(" ");
            }

            System.out.println(sb);
        }
    }
}
