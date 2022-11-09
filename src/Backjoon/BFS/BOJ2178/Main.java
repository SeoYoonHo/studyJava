package Backjoon.BFS.BOJ2178;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			int[][] maze = new int[n][m];
			for (int i = 0; i < n; i++) {
				String jString = sc.next();
				for (int j = 0; j < m; j++) {
					maze[i][j] = Integer.parseInt(jString.substring(j, j + 1));
				}
			}

			int[] startPoint = { 0, 0 };
			int[][] distance = new int[n][m];
			boolean[][] isCheck = new boolean[n][m];

			Main main = new Main();
			System.out.println(main.solution(maze, startPoint, distance, isCheck) + 1);
		}
	}

	public int solution(int[][] maze, int[] startPoint, int[][] distance, boolean[][] isCheck) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(startPoint);
		isCheck[0][0] = true;

		int dt = 0;
		while (!queue.isEmpty()) {
			int[] point = queue.poll();
			int dx = point[0];
			int dy = point[1];
			dt = distance[dx][dy] + 1;

			// 상 하 좌 우 모두 체크
			if (dx - 1 >= 0) {
				if (!isCheck[dx - 1][dy] && maze[dx - 1][dy] == 1) {
					int[] tempArr = new int[2];
					tempArr[0] = dx - 1;
					tempArr[1] = dy;
					queue.add(tempArr);
					isCheck[dx - 1][dy] = true;
					if (distance[dx - 1][dy] == 0 || dt < distance[dx - 1][dy]) {
						distance[dx - 1][dy] = dt;
					}
				}
			}
			if (dx + 1 < maze.length) {
				if (!isCheck[dx + 1][dy] && maze[dx + 1][dy] == 1) {
					int[] tempArr = new int[2];
					tempArr[0] = dx + 1;
					tempArr[1] = dy;
					queue.add(tempArr);
					isCheck[dx + 1][dy] = true;
					if (distance[dx + 1][dy] == 0 || dt < distance[dx + 1][dy]) {
						distance[dx + 1][dy] = dt;
					}
				}
			}
			if (dy - 1 >= 0) {
				if (!isCheck[dx][dy - 1] && maze[dx][dy - 1] == 1) {
					int[] tempArr = new int[2];
					tempArr[0] = dx;
					tempArr[1] = dy - 1;
					queue.add(tempArr);
					isCheck[dx][dy - 1] = true;
					if (distance[dx][dy - 1] == 0 || dt < distance[dx][dy - 1]) {
						distance[dx][dy - 1] = dt;
					}
				}
			}
			if (dy + 1 < maze[0].length) {
				if (!isCheck[dx][dy + 1] && maze[dx][dy + 1] == 1) {
					int[] tempArr = new int[2];
					tempArr[0] = dx;
					tempArr[1] = dy + 1;
					queue.add(tempArr);
					isCheck[dx][dy + 1] = true;
					if (distance[dx][dy + 1] == 0 || dt < distance[dx][dy + 1]) {
						distance[dx][dy + 1] = dt;
					}
				}
			}
		}

//		printArr(distance);

		return distance[distance.length - 1][distance[0].length - 1];
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
