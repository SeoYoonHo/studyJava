package Backjoon.BFS.BOJ1697;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int N = sc.nextInt();
			int K = sc.nextInt();

			int[] dist = new int[100001];
			Arrays.fill(dist, -1);

			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(N);
			dist[N] = 0;

			int[] dx = { -1, 1, 2 };

			int distance = 0;
			int min = -1;
			while (!queue.isEmpty()) {
				int targetIndex = queue.poll();

				distance = dist[targetIndex] + 1;

				if (min != -1 && distance > min) {
					continue;
				}

				for (int i = 0; i < dx.length; i++) {
					int nx;
					if (dx[i] == 2) {
						nx = targetIndex * dx[i];
					} else {
						nx = targetIndex + dx[i];
					}

					if (nx < 0 || nx >= dist.length)
						continue;

					if (nx == K) {
						min = min == -1 ? dist[nx] : Math.min(dist[nx], min);
//						System.out.println("here : " + min);
					}

					if (dist[nx] == -1) {
						dist[nx] = distance;
						queue.add(nx);
					}
				}
			}

			System.out.println(min);
//			for (int i : dist) {
//				System.out.print(i + " ");
//			}
//			System.out.println();
		}
	}

}
