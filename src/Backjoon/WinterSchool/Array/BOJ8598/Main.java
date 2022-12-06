package Backjoon.WinterSchool.Array.BOJ8598;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            String[][] inputMap = new String[N][M];
            Integer[][] dist = new Integer[N][M];

            for (int i = 0; i < N; i++) {
                String temp = sc.next();
                inputMap[i] = temp.split("");
            }

            Queue<Point> pointQueue = new LinkedList<>();
            Point goal = new Point();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    switch (inputMap[i][j]) {
                        case "z" -> {
                            dist[i][j] = 0;
                            Point point = new Point();
                            point.x = i;
                            point.y = j;
                            pointQueue.add(point);
                            dist[i][j] = 1;
                        }
                        case "x" -> dist[i][j] = -1;
                        case "n" -> {
                            dist[i][j] = 0;
                            goal.x = i;
                            goal.y = j;
                        }
                        default -> dist[i][j] = 0;
                    }
                }
            }

//            printMap(dist);
//            System.out.println();

            while (!pointQueue.isEmpty()) {
                Point point = pointQueue.poll();

                int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
                int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};

                for (int i = 0; i < 8; i++) {
                    int nx = point.x + dx[i];
                    int ny = point.y + dy[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M || dist[nx][ny] != 0) {
                        continue;
                    }

                    dist[nx][ny] = dist[point.x][point.y] + 1;
                    Point point1 = new Point();
                    point1.x = nx;
                    point1.y = ny;
                    pointQueue.add(point1);
                }
            }

//            printMap(dist);
//            printMap(inputMap);
            String res = dist[goal.x][goal.y] == 0 ? "NIE" : dist[goal.x][goal.y] - 1 + "";
            System.out.println(res);
        }
    }

    public static <T> void printMap(T[][] map) {
        for (T[] strings : map) {
            for (T str : strings) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }
}