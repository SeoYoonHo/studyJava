package Backjoon.BFS.BOJ4179;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			String[][] maze = new String[N][M];
			int[][] j_distance = new int[N][M];
			int[][] f_distance = new int[N][M];
//			int[] j_start = new int[2];
//			int[] f_start = new int[2];
			// -1 : no check, -2 : wall

			Queue<int[]> j_queue = new LinkedList<int[]>();
			Queue<int[]> f_queue = new LinkedList<int[]>();

			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < M; j++) {
					maze[i][j] = str.substring(j, j + 1);
					if (maze[i][j].equals("#")) {
						j_distance[i][j] = -2;
						f_distance[i][j] = -2;
					} else if (maze[i][j].equals("J")) {
						j_distance[i][j] = 0;
						f_distance[i][j] = -1;

						int[] j_start = new int[2];
						j_start[0] = i;
						j_start[1] = j;
						j_queue.add(j_start);
					} else if (maze[i][j].equals("F")) {
						j_distance[i][j] = -1;
						f_distance[i][j] = 0;

						int[] f_start = new int[2];
						f_start[0] = i;
						f_start[1] = j;
						f_queue.add(f_start);
					} else {
						j_distance[i][j] = -1;
						f_distance[i][j] = -1;
					}
				}
			}

			Main main = new Main();
			int res = main.solution(maze, j_distance, f_distance, j_queue, f_queue);
			if (res == 0) {
				System.out.println("IMPOSSIBLE");
			} else {
				System.out.println(res);
			}

//			main.printArr_int(j_distance);
//			main.printArr(maze);
		}
	}

	public int solution(String[][] maze, int[][] j_distance, int[][] f_distance, Queue<int[]> j_queue,
			Queue<int[]> f_queue) {
		// 상 하 좌 우 체크용 배열
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		int j_dist = 0;
		int f_dist = 0;
		while (!j_queue.isEmpty()) {
			int[] targetPoint = j_queue.poll();

			j_dist = j_distance[targetPoint[0]][targetPoint[1]] + 1;

			// 상 하 좌 우 모두 체크
			for (int dir = 0; dir < 4; dir++) {
				int nx = targetPoint[0] + dx[dir];
				int ny = targetPoint[1] + dy[dir];
				if (nx < 0 || nx >= maze.length || ny < 0 || ny >= maze[0].length)
					continue;

				if (j_distance[nx][ny] == -1 && (maze[nx][ny].equals(".") || maze[nx][ny].equals("F"))) {
					int[] tempArr = new int[2];
					tempArr[0] = nx;
					tempArr[1] = ny;
					j_queue.add(tempArr);
					j_distance[nx][ny] = j_dist;
				}

			}
		}

		while (!f_queue.isEmpty()) {
			int[] targetPoint = f_queue.poll();

			f_dist = f_distance[targetPoint[0]][targetPoint[1]] + 1;

			// 상 하 좌 우 모두 체크
			for (int dir = 0; dir < 4; dir++) {
				int nx = targetPoint[0] + dx[dir];
				int ny = targetPoint[1] + dy[dir];
				if (nx < 0 || nx >= maze.length || ny < 0 || ny >= maze[0].length)
					continue;

				if (f_distance[nx][ny] == -1 && (maze[nx][ny].equals(".") || maze[nx][ny].equals("J"))) {
					int[] tempArr = new int[2];
					tempArr[0] = nx;
					tempArr[1] = ny;
					f_queue.add(tempArr);
					f_distance[nx][ny] = f_dist;
				}
			}
		}

//		printArr_int(j_distance);
//		printArr_int(f_distance);

//		System.out.println(sub_tArr(j_distance, f_distance));

		return sub_tArr(j_distance, f_distance) + 1;
	}

	public int sub_tArr(int[][] arr1, int[][] arr2) {
		int res = -1;

		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[0].length; j++) {
				if (i == 0 || j == 0 || i == arr1.length - 1 || j == arr1[0].length - 1) {
					if ((arr2[i][j] - arr1[i][j] > 0 && arr1[i][j] >= 0) || (arr2[i][j] == -1 && arr1[i][j] >= 0)) {
						if (res == -1 || arr1[i][j] < res) {
							res = arr1[i][j];
						}
					}
				}
			}
		}

		return res;
	}

	public void printArr(String[][] arr) {
		for (String[] i : arr) {
			for (String j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public void printArr_int(int[][] arr) {
		for (int[] i : arr) {
			for (int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
