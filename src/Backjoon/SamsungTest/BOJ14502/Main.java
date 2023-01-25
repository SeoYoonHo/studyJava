package Backjoon.SamsungTest.BOJ14502;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] inputMap = new int[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    inputMap[i][j] = sc.nextInt();
                }
            }

            bfs(inputMap);
            printArr(inputMap);
        }
    }

    public static void bfs(int[][] inputMap) {
        int[][] distanceMap = new int[inputMap.length][inputMap[0].length];
        Queue<Point> pointQueue = new LinkedList<>();

        for (int i = 0; i < inputMap.length; i++) {
            for (int j = 0; j < inputMap[0].length; j++) {
                if (inputMap[i][j] == 2) {
                    pointQueue.add(new Point(i, j));
                    distanceMap[i][j] = 1;
                } else if (inputMap[i][j] == 1) {
                    distanceMap[i][j] = -1;
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!pointQueue.isEmpty()) {
            Point point = pointQueue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (nx < 0 || nx >= inputMap.length || ny < 0 || ny >= inputMap[0].length || distanceMap[nx][ny] != 0) {
                    continue;
                }

                distanceMap[nx][ny] += distanceMap[point.x][point.y] + 1;
                pointQueue.add(new Point(nx, ny));
            }
        }

        printArr(distanceMap);
    }

    public static void printArr(int[][] arr) {
        for (int[] arrs : arr) {
            for (int i : arrs) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
