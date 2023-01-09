package Backjoon.SamsungTest.BOJ14501;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            int[] T = new int[N];
            int[] P = new int[N];

            for (int i = 0; i < N; i++) {
                T[i] = sc.nextInt();
                P[i] = sc.nextInt();
            }

            int[] max = new int[1];
            solution(T, P, 0, 0, max);
            System.out.println(max[0]);
        }
    }

    public static void solution(int[] T, int[] P, int index, int sum, int[] max) {
        if (index < T.length) {
            //index 선택할 경우
            if (!(index + T[index] > T.length)) {
//            System.out.println(index);
                solution(T, P, index + T[index], sum + P[index], max);
            }

            //index 선택 안할 경우
            if (!(index + 1 >= T.length)) {
                solution(T, P, index + 1, sum, max);
            }
        }

        max[0] = Math.max(max[0], sum);
//        System.out.println("hhhhhh");
    }
}
