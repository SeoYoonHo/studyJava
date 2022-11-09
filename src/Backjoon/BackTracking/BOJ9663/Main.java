package Backjoon.BackTracking.BOJ9663;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int N = sc.nextInt();
			int[][] chessArray = new int[N][N];
			Main main = new Main();
			int res = main.solution(chessArray, 0);
			System.out.println(res);
		}
	}

	public int solution(int[][] chessArray, int jIndex) {
		int res = 0;

		if (jIndex == chessArray.length) {
//			printArr(chessArray);
			return 1;
		}

		for (int i = 0; i < chessArray.length; i++) {

			if (chessArray[i][jIndex] == 0) {
				queenArea(chessArray, i, jIndex, 1);
				res += solution(chessArray, jIndex + 1);
				queenArea(chessArray, i, jIndex, -1);
			}
		}

		return res;
	}

	public void queenArea(int[][] arr, int i, int j, int flag) {
		arr[i][j] += flag;

		for (int k = 0; k < arr.length; k++) {
			if (k != j)
				arr[i][k] += flag;

			if (k != i)
				arr[k][j] += flag;

			if (k != 0) {
				if (i >= k && j >= k)
					arr[i - k][j - k] += flag;
				if ((i + k) < arr.length && (j + k) < arr.length)
					arr[i + k][j + k] += flag;
				if (i >= k && (j + k) < arr.length)
					arr[i - k][j + k] += flag;
				if ((i + k) < arr.length && j >= k)
					arr[i + k][j - k] += flag;
			}
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
