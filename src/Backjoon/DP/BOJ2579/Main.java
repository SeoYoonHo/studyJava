package Backjoon.DP.BOJ2579;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			int N = sc.nextInt();
			int arrLength = N < 3 ? 3 : N;

			int[] stairs = new int[arrLength + 1];
			int[] scores = new int[arrLength + 1];

			for (int i = 1; i < N + 1; i++) {
				stairs[i] = sc.nextInt();
			}

			scores[1] = stairs[1];
			scores[2] = stairs[1] + stairs[2];
			scores[3] = Math.max(stairs[1], stairs[2]) + stairs[3];

			for (int i = 4; i < N + 1; i++) {
				int temp1 = scores[i - 2] + stairs[i];
				int temp2 = scores[i - 3] + stairs[i - 1] + stairs[i];

				scores[i] = Math.max(temp1, temp2);
			}

			System.out.println(scores[N]);
		}
	}
}
