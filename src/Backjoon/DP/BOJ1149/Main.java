package Backjoon.DP.BOJ1149;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			int N = sc.nextInt();
			int[][] cost = new int[N][3];
			// 빨강 파랑 초록 순서

			int[][] minmumCost_color = new int[N][3];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 3; j++) {
					cost[i][j] = sc.nextInt();
				}
			}

			minmumCost_color[0][0] = cost[0][0];
			minmumCost_color[0][1] = cost[0][1];
			minmumCost_color[0][2] = cost[0][2];

			for (int i = 1; i < N; i++) {
				minmumCost_color[i][0] = Math.min(minmumCost_color[i - 1][1], minmumCost_color[i - 1][2]) + cost[i][0];
				minmumCost_color[i][1] = Math.min(minmumCost_color[i - 1][0], minmumCost_color[i - 1][2]) + cost[i][1];
				minmumCost_color[i][2] = Math.min(minmumCost_color[i - 1][0], minmumCost_color[i - 1][1]) + cost[i][2];
			}

			int min = Math.min(minmumCost_color[N-1][0],minmumCost_color[N-1][1]);
			min = Math.min(min,minmumCost_color[N-1][2]);
			
			System.out.println(min);
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
