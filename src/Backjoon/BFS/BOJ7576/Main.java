package Backjoon.BFS.BOJ7576;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int M = sc.nextInt();
			int N = sc.nextInt();

			int[][] box = new int[N][M];
			int[][] day_check = new int[N][M];
			/**
			 * day_check -2 : 토마토 없는 -1 : 덜익은 토마토 0 ~: 토마토 익은 날짜
			 */

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					box[i][j] = sc.nextInt();
					day_check[i][j] = box[i][j] == -1 ? -2 : -1;
				}
			}

			Main main = new Main();
			System.out.println(main.solution(box, day_check));
		}
	}

	public int solution(int[][] box, int[][] day_check) {

		Queue<int[]> queue = new LinkedList<int[]>();
		
		// 상 하 좌 우 체크용 배열
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		for (int i = 0; i < box.length; i++) {
			for (int j = 0; j < box[0].length; j++) {
				if (box[i][j] == 1 && day_check[i][j] == -1) {
					int[] tempPoint = new int[2];
					tempPoint[0] = i;
					tempPoint[1] = j;

					day_check[i][j] = 0;
					queue.add(tempPoint);
				}
			}
		}

		int day = 0;
		while (!queue.isEmpty()) {

			int[] targetPoint = queue.poll();
			day = day_check[targetPoint[0]][targetPoint[1]] + 1;

			// 상 하 좌 우 모두 체크
			for (int dir = 0; dir < 4; dir++) {
				int nx = targetPoint[0] + dx[dir];
				int ny = targetPoint[1] + dy[dir];
				if (nx < 0 || nx >= box.length || ny < 0 || ny >= box[0].length)
					continue;

				if (day_check[nx][ny] == -1 && box[nx][ny] == 0) {
					int[] tempArr = new int[2];
					tempArr[0] = nx;
					tempArr[1] = ny;
					queue.add(tempArr);
					day_check[nx][ny] = day;
				}
			}
		}

		int[] res = minmax(day_check);
		if (res[0] == -1) {
			return -1;
		} else {
			return res[1];
		}
	}

	public int[] minmax(int[][] arr) {
		int[] res = { 0, 0 };
		res[0] = arr[0][0];
		res[1] = arr[0][0];

		for (int[] i : arr) {
			for (int j : i) {
				if (j != -2)
					res[0] = Math.min(res[0], j);
				res[1] = Math.max(res[1], j);
			}
		}

		return res;

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
