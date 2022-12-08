package Backjoon.SamsungTest.BOJ14500;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] map = new int[N][M];
            int[][] visit = new int[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int sum = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    PolygonPoint polygonPoint = new PolygonPoint();
                    Point stPoint = new Point(i, j);
                    polygonPoint.point = stPoint;
                    polygonPoint.sum = map[i][j];
                    sum = Math.max(maxSum(map, visit, polygonPoint), sum);

                    for (int type = 1; type <= 4; type++) {
                        sum = Math.max(sum,sumTer(map, getPointsTer(stPoint, type)));
                    }
                }
            }

            System.out.println(sum);
        }
    }

    public static int maxSum(int[][] map, int[][] visit, PolygonPoint startPoint) {
        int max = 0;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        Queue<PolygonPoint> queue = new LinkedList<>();
        queue.add(startPoint);
        visit[startPoint.point.x][startPoint.point.y] = 1;

        while (!queue.isEmpty()) {
            PolygonPoint stPolyPoint = queue.poll();

            if (stPolyPoint.depth == 3) {
                max = Math.max(max, stPolyPoint.sum);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                Point point = new Point();
                point.x = stPolyPoint.point.x + dx[i];
                point.y = stPolyPoint.point.y + dy[i];

                if (point.x < 0 || point.x >= map.length || point.y < 0 || point.y >= map[0].length ||
//                        visit[point.x][point.y] == 1 ||
                        stPolyPoint.isContain(point)) {
                    continue;
                }

                PolygonPoint polygonPoint = new PolygonPoint();
                polygonPoint.point = point;
                polygonPoint.prevPoint = stPolyPoint;
                polygonPoint.depth = stPolyPoint.depth + 1;
                polygonPoint.sum = polygonPoint.prevPoint.sum + map[point.x][point.y];
                queue.add(polygonPoint);
            }
        }


        return max;
    }

    static class PolygonPoint {
        Point point;
        PolygonPoint prevPoint;
        int depth;
        int sum;

        boolean isContain(Point inputPoint) {
            if (point.x == inputPoint.x && point.y == inputPoint.y) {
                return true;
            } else if (prevPoint == null) {
                return false;
            } else {
                return prevPoint.isContain(inputPoint);
            }
        }

        @Override
        public String toString() {
            return "PolygonPoint{" + "point=" + point + ", prevPoint=" + prevPoint + ", depth=" + depth + ", sum=" +
                    sum + '}';
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
                point4.y = point.y + 1;
                point2.x = point.x;
                point3.x = point.x;
                point4.x = point.x + 1;
                res.add(point2);
                res.add(point3);
                res.add(point4);
                break;
            case 2:
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
            case 3:
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
            case 4:
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
