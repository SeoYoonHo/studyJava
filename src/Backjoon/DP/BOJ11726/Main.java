package Backjoon.DP.BOJ11726;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			int N = sc.nextInt();
			int[] count = new int[N < 3 ? 3 : N];

			count[0] = 1;
			count[1] = 2;

			for (int i = 2; i < N; i++) {
				count[i] = (count[i - 1] + count[i - 2]) % 10007;
			}

			System.out.println(count[N - 1] % 10007);
		}
	}
}
