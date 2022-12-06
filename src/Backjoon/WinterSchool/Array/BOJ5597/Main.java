package Backjoon.WinterSchool.Array.BOJ5597;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int[] studentArr = new int[30];

            for (int i = 0; i < 28; i++) {
                studentArr[sc.nextInt() - 1] = 1;
            }

            for (int i = 0; i < 30; i++) {
                if (studentArr[i] == 0) {
                    System.out.println(i + 1);
                }
            }
        }
    }
}
