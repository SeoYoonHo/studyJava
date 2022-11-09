package Backjoon.DP.BOJ11659;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			int N = sc.nextInt();
			int M = sc.nextInt();

			int[] inputArr = new int[N];
			int[][] index = new int[M][2];

			for (int i = 0; i < inputArr.length; i++) {
				inputArr[i] = sc.nextInt();
			}

			for (int i = 0; i < M; i++) {
				index[i][0] = sc.nextInt();
				index[i][1] = sc.nextInt();
			}

			int[] sumArr = new int[N];
			sumArr[0] = inputArr[0];
			for (int i = 1; i < N; i++) {
				sumArr[i] = sumArr[i - 1] + inputArr[i];
			}

//			for (int i : sumArr) {
//				System.out.print(i + " ");
//			}
//			System.out.println();

			for (int i = 0; i < M; i++) {
				int res = index[i][0] == 1 ? sumArr[index[i][1] - 1]
						: sumArr[index[i][1] - 1] - sumArr[index[i][0] - 2];
				System.out.println(res);
			}

//			new Main().printArr(ij);
		}
	}

	public void printArr(int[][] arr) {
		for (int[] i : arr) {
			for (int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
