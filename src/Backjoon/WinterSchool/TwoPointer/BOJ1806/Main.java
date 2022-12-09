package Backjoon.WinterSchool.TwoPointer.BOJ1806;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            int S = sc.nextInt();

            int[] inputArr = new int[N];
            for (int i = 0; i < N; i++) {
                inputArr[i] = sc.nextInt();
            }

            int start = 0;
            int end = 0;

            long sum = 0;
            int minLength = 0;
            while (start < inputArr.length) {
                if (sum < S) {
                    if (end < inputArr.length) {
                        end++;
                        sum += inputArr[end - 1];
                    } else {
                        break;
                    }
                } else {
                    if (minLength == 0) {
                        minLength = end - start;
                    } else {
                        minLength = Math.min(minLength, end - start);
                    }
//                    System.out.println("start : " + start + ", end : " + end);

                    sum -= inputArr[start];
                    start++;
                }
            }

            System.out.println(minLength);
        }
    }
}
