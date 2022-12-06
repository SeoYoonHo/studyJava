package Backjoon.WinterSchool.Array.BOJ10818;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();

            int max = 0;
            int min = 0;
            for (int i = 0; i < N; i++) {
                int temp = sc.nextInt();
                if (i == 0) {
                    max = temp;
                    min = temp;
                }
                max = Math.max(max, temp);
                min = Math.min(min, temp);
            }

            System.out.println(min + " " + max);
        }
    }
}
