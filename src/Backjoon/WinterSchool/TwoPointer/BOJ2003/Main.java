package Backjoon.WinterSchool.TwoPointer.BOJ2003;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            long count = 0;

            int[] inputArr = new int[N];
            for (int i = 0; i < N; i++) {
                inputArr[i] = sc.nextInt();
            }

            long[] subSumArr = new long[N];

            long sum = 0;
            for (int i = 1; i <= N; i++) {
                sum += inputArr[i - 1];
                subSumArr[i - 1] = sum;
                if (sum == M) count++;
            }

            for (int i = 1; i <= N; i++) {
                for (int j = i + 1; j <= N; j++) {
                    long subSum = subSumArr[j - 1] - subSumArr[i - 1];
                    if (subSum == M) count++;
                }
            }

            System.out.println(count);
        }
    }
}
