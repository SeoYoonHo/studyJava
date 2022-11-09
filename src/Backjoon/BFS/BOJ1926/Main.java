package Backjoon.BFS.BOJ1926;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			int[][] paper = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					paper[i][j] = sc.nextInt();
				}
			}

			Main main = new Main();
			boolean[][] ischecked = new boolean[n][m];

			int[] res = main.solution(paper, ischecked);

			for (int i : res) {
				System.out.println(i);
			}
		}
	}

	public int[] solution(int[][] paper, boolean[][] ischecked) {
		int[] res = new int[2];

		for (int i = 0; i < paper.length; i++) {
			for (int j = 0; j < paper[0].length; j++) {
				if (!ischecked[i][j] && paper[i][j] == 1) {
					ischecked[i][j] = true;

					Queue<Integer[]> queue = new LinkedList<Integer[]>();
					Integer[] initalPoint = new Integer[2];
					initalPoint[0] = i;
					initalPoint[1] = j;
					queue.add(initalPoint);

					int maxSize = 0;
					while (!queue.isEmpty()) {
						Integer[] point = queue.poll();
						int dx = point[0];
						int dy = point[1];
						// 상 하 좌 우 모두 체크
						if (dx - 1 >= 0) {
							if (!ischecked[dx - 1][dy] && paper[dx - 1][dy] == 1) {
								Integer[] tempArr = new Integer[2];
								tempArr[0] = dx - 1;
								tempArr[1] = dy;
								queue.add(tempArr);
								ischecked[dx - 1][dy] = true;
							}
						}
						if (dx + 1 < paper.length) {
							if (!ischecked[dx + 1][dy] && paper[dx + 1][dy] == 1) {
								Integer[] tempArr = new Integer[2];
								tempArr[0] = dx + 1;
								tempArr[1] = dy;
								queue.add(tempArr);
								ischecked[dx + 1][dy] = true;
							}
						}
						if (dy - 1 >= 0) {
							if (!ischecked[dx][dy - 1] && paper[dx][dy - 1] == 1) {
								Integer[] tempArr = new Integer[2];
								tempArr[0] = dx;
								tempArr[1] = dy - 1;
								queue.add(tempArr);
								ischecked[dx][dy - 1] = true;
							}
						}
						if (dy + 1 < paper[0].length) {
							if (!ischecked[dx][dy + 1] && paper[dx][dy + 1] == 1) {
								Integer[] tempArr = new Integer[2];
								tempArr[0] = dx;
								tempArr[1] = dy + 1;
								queue.add(tempArr);
								ischecked[dx][dy + 1] = true;
							}
						}
						maxSize++;
					}

					res[0]++;
					res[1] = Math.max(res[1], maxSize);
				}
			}
		}
		return res;
	}
}
