package Backjoon.WinterSchool.Array.BOJ2738;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] mat = new int[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    mat[i][j] += sc.nextInt();
                }
            }

            for (int[] ints : mat) {
                for (int a : ints) {
                    System.out.print(a + " ");
                }
                System.out.println();
            }

        }
    }
}
