package Backjoon.WinterSchool.HashTree.BOJ2776;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt();

            for (int t = 0; t < T; t++) {
                int N = sc.nextInt();
                Map<Integer, Integer> note = new HashMap<>();

                for (int i = 0; i < N; i++) {
                    int temp = sc.nextInt();
                    note.put(temp, 1);
                }

                int M = sc.nextInt();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < M; i++) {
                    int temp = sc.nextInt();
                    if (note.get(temp) != null) {
                        sb.append(1);
                        sb.append("\n");
                    } else {
                        sb.append(0);
                        sb.append("\n");
                    }
                }

                System.out.print(sb);
            }
        }
    }
}
