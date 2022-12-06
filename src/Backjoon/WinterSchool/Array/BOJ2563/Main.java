package Backjoon.WinterSchool.Array.BOJ2563;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            int[][] map = new int[100][100];

            List<Polygon> polygonList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                Polygon temp = new Polygon();
                Point leftBottom = new Point();
                Point rightTop = new Point();
                temp.leftBottom = leftBottom;
                temp.rightTop = rightTop;

                leftBottom.x = sc.nextInt() - 1;
                leftBottom.y = sc.nextInt() - 1;
                rightTop.x = leftBottom.x + 10;
                rightTop.y = leftBottom.y + 10;

                polygonList.add(temp);
            }

            for (Polygon polygon : polygonList) {
                for (int i = polygon.leftBottom.x; i < polygon.rightTop.x; i++) {
                    for (int j = polygon.leftBottom.y; j < polygon.rightTop.y; j++) {
                        map[i][j] = 1;
                    }
                }
            }

            int res = 0;
            for (int[] ints : map) {
                for (int a : ints) {
                    if(a == 1){
                        res++;
                    }
                }
            }

            System.out.println(res);
        }
    }
    static class Polygon {
        Point leftBottom;
        Point rightTop;

        @Override
        public String toString() {
            return "Polygon{" +
                    "leftBottom=" + leftBottom +
                    ", rightTop=" + rightTop +
                    '}';
        }
    }
}
