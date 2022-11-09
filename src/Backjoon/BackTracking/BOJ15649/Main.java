package Backjoon.BackTracking.BOJ15649;

/**
 * BackTracking 전형적인 코드 기억!
 * */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Main sol = new Main();

		try (Scanner sc = new Scanner(System.in)) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			ArrayList<Integer[]> resArr = new ArrayList<Integer[]>();
			int[] arr_param = new int[M];
			boolean[] check = new boolean[N];
			sol.solution(N, resArr, arr_param, 0, check);

			for (Integer[] arr : resArr) {
				for (int i : arr) {
					System.out.print(i + " ");
				}
				System.out.println();
			}
		}
	}

	public void solution(int N, ArrayList<Integer[]> resArrList, int[] intArr, int targetInd, boolean[] check) {
		ArrayList<Integer> checkIndex = new ArrayList<Integer>();

		if (targetInd == intArr.length) {
			Integer[] newArr = new Integer[intArr.length];
			for (int j = 0; j < newArr.length; j++) {
				newArr[j] = intArr[j];
			}
			resArrList.add(newArr);
			
			return;
		}

		for (int i = 1; i <= check.length; i++) {
			if (!check[i - 1]) {
				intArr[targetInd] = i;
				check[i - 1] = true;
				checkIndex.add(i);
				solution(N, resArrList, intArr, targetInd + 1, check);
			}

			for (int k : checkIndex) {
				check[k - 1] = false;
			}
		}
		intArr[targetInd] = 0;

	}
}
