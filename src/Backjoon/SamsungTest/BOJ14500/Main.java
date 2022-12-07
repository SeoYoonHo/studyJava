package Backjoon.SamsungTest.BOJ14500;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] map = new int[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int sum = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    for (int type = 1; type <= 13; type++) {
                        Point initialPoint = new Point();
                        initialPoint.x = i;
                        initialPoint.y = j;
                        sum = Math.max(sumTer(map, getPointsTer(initialPoint, type)), sum);
//                        System.out.print(sum + " ");
                    }
                }
//                System.out.println();
            }

//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < M; j++) {
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }

            System.out.println(sum);
        }
    }

    public static List<Point> getPointsTer(Point point, int type) {
        List<Point> res = new ArrayList<>();
        res.add(point);
        Point point2 = new Point();
        Point point3 = new Point();
        Point point4 = new Point();

        switch (type) {
            case 1:
                point2.y = point.y + 1;
                point3.y = point.y + 2;
                point4.y = point.y + 3;
                point2.x = point.x;
                point3.x = point.x;
                point4.x = point.x;
                res.add(point2);
                res.add(point3);
                res.add(point4);
                break;
            case 2:
                point2.y = point.y;
                point3.y = point.y;
                point4.y = point.y;
                point2.x = point.x + 1;
                point3.x = point.x + 2;
                point4.x = point.x + 3;
                res.add(point2);
                res.add(point3);
                res.add(point4);
                break;
            case 3:
                point2.y = point.y + 1;
                point3.y = point.y;
                point4.y = point.y + 1;
                point2.x = point.x;
                point3.x = point.x + 1;
                point4.x = point.x + 1;
                res.add(point2);
                res.add(point3);
                res.add(point4);
                break;
            case 4:
                point2.y = point.y;
                point3.y = point.y;
                point4.y = point.y + 1;
                point2.x = point.x + 1;
                point3.x = point.x + 2;
                point4.x = point.x + 2;
                res.add(point2);
                res.add(point3);
                res.add(point4);
                break;
            case 5:
                point2.y = point.y + 1;
                point3.y = point.y + 2;
                point4.y = point.y + 2;
                point2.x = point.x;
                point3.x = point.x;
                point4.x = point.x - 1;
                res.add(point2);
                res.add(point3);
                res.add(point4);
                break;
            case 6:
                point2.y = point.y + 1;
                point3.y = point.y + 1;
                point4.y = point.y + 1;
                point2.x = point.x;
                point3.x = point.x + 1;
                point4.x = point.x + 2;
                res.add(point2);
                res.add(point3);
                res.add(point4);
                break;
            case 7:
                point2.y = point.y + 1;
                point3.y = point.y + 2;
                point4.y = point.y;
                point2.x = point.x;
                point3.x = point.x;
                point4.x = point.x + 1;
                res.add(point2);
                res.add(point3);
                res.add(point4);
                break;
            case 8:
                point2.y = point.y;
                point3.y = point.y + 1;
                point4.y = point.y + 1;
                point2.x = point.x + 1;
                point3.x = point.x + 1;
                point4.x = point.x + 2;
                res.add(point2);
                res.add(point3);
                res.add(point4);
                break;
            case 9:
                point2.y = point.y + 1;
                point3.y = point.y + 1;
                point4.y = point.y + 2;
                point2.x = point.x;
                point3.x = point.x - 1;
                point4.x = point.x - 1;
                res.add(point2);
                res.add(point3);
                res.add(point4);
                break;
            case 10:
                point2.y = point.y + 1;
                point3.y = point.y + 2;
                point4.y = point.y + 1;
                point2.x = point.x;
                point3.x = point.x;
                point4.x = point.x + 1;
                res.add(point2);
                res.add(point3);
                res.add(point4);
                break;
            case 11:
                point2.y = point.y + 1;
                point3.y = point.y + 1;
                point4.y = point.y + 1;
                point2.x = point.x - 1;
                point3.x = point.x;
                point4.x = point.x + 1;
                res.add(point2);
                res.add(point3);
                res.add(point4);
                break;
            case 12:
                point2.y = point.y + 1;
                point3.y = point.y + 1;
                point4.y = point.y + 2;
                point2.x = point.x - 1;
                point3.x = point.x;
                point4.x = point.x;
                res.add(point2);
                res.add(point3);
                res.add(point4);
                break;
            case 13:
                point2.y = point.y;
                point3.y = point.y + 1;
                point4.y = point.y;
                point2.x = point.x + 1;
                point3.x = point.x + 1;
                point4.x = point.x + 2;
                res.add(point2);
                res.add(point3);
                res.add(point4);
                break;
        }

        return res;
    }

    public static int sumTer(int[][] map, List<Point> points) {
        int sum = 0;

        for (Point point : points) {
            if (point.x < 0 || point.x >= map.length || point.y < 0 || point.y >= map[0].length) {
                return 0;
            }

            sum += map[point.x][point.y];
        }

        return sum;
    }
}
