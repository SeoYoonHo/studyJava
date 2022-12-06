package Backjoon.WinterSchool.Array.BOJ2566;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int max = 0;
            int col = 0;
            int row = 0;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    int temp = sc.nextInt();
                    if (i == 0 && j == 0) max = temp;

                    if (max < temp) {
                        max = temp;
                        col = i;
                        row = j;
                    }
                }
            }

            System.out.println(max);
            System.out.println((col + 1) + " " + (row + 1));
        }
    }
}
