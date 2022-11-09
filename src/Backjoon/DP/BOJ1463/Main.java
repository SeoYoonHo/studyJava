package Backjoon.DP.BOJ1463;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int N = sc.nextInt();

			int[] arr = new int[N + 1];

			for (int i = 2; i <= N; i++) {
				int min = arr[i - 1] + 1;
				min = i % 3 == 0 ? Math.min(arr[i / 3] + 1, min) : min;
				min = i % 2 == 0 ? Math.min(arr[i / 2] + 1, min) : min;
				
				arr[i] = min;
			}
			
			System.out.println(arr[N]);
		}
	}

}
