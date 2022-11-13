package Backjoon.SamsungTest.BOJ14499;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int K = sc.nextInt();

            Point dicePoint = new Point(x, y);
            Dice dice = new Dice(dicePoint);

            int[][] inputMap = new int[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    inputMap[i][j] = sc.nextInt();
                }
            }

            List<Integer> dirList = new ArrayList<>();
            for (int i = 0; i < K; i++) {
                int temp = sc.nextInt();
                dirList.add(temp);
            }

            Main main = new Main();

            for (Integer direction : dirList) {
                boolean isTumble = main.tumbleDice(inputMap, dice, direction);
                if (isTumble) {
                    System.out.println(dice.getTopValue());
                }
            }

        }
    }

    public boolean tumbleDice(int[][] inputMap, Dice dice, int direction) {
        Point tempPoint = new Point(dice.currPoint);
        int mapLenX = inputMap.length;
        int mapLenY = inputMap[0].length;

        switch (direction) {
            case 1 -> tempPoint.y++;
            case 2 -> tempPoint.y--;
            case 3 -> tempPoint.x--;
            case 4 -> tempPoint.x++;
        }

        if (tempPoint.x < 0 || tempPoint.x > mapLenX - 1 || tempPoint.y < 0 || tempPoint.y > mapLenY - 1) {
            return false;
        }

        dice.moveDice(direction);
        dice.currPoint = tempPoint;
        if (inputMap[dice.currPoint.x][dice.currPoint.y] == 0) {
            inputMap[dice.currPoint.x][dice.currPoint.y] = dice.getBottomValue();
        } else {
            dice.setBottomValue(inputMap[dice.currPoint.x][dice.currPoint.y]);
            inputMap[dice.currPoint.x][dice.currPoint.y] = 0;
        }

        return true;
    }

    public void printArr(int[][] arr) {
        for (int[] list : arr) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static class Dice {
        int[] xArr = new int[3];
        int[] yArr = new int[4];

        public Point currPoint;

        public Dice(Point point) {
            this.currPoint = point;
        }

        public void moveDice(int direction) {
            int[] tempX = Arrays.copyOf(xArr, xArr.length);
            int[] tempY = Arrays.copyOf(yArr, yArr.length);
            switch (direction) {
                case 1 -> {
                    xArr[0] = tempY[3];
                    xArr[1] = tempX[0];
                    xArr[2] = tempX[1];
                    yArr[1] = xArr[1];
                    yArr[3] = tempX[2];
                }
                case 2 -> {
                    xArr[0] = tempX[1];
                    xArr[1] = tempX[2];
                    xArr[2] = tempY[3];
                    yArr[1] = xArr[1];
                    yArr[3] = tempX[0];
                }
                case 3 -> {
                    yArr[0] = tempY[1];
                    yArr[1] = tempY[2];
                    yArr[2] = tempY[3];
                    yArr[3] = tempY[0];
                    xArr[1] = yArr[1];
                }
                case 4 -> {
                    yArr[0] = tempY[3];
                    yArr[1] = tempY[0];
                    yArr[2] = tempY[1];
                    yArr[3] = tempY[2];
                    xArr[1] = yArr[1];
                }
            }
        }

        public int getTopValue() {
            return xArr[1];
        }

        public int getBottomValue() {
            return yArr[3];
        }

        public void setBottomValue(int val) {
            yArr[3] = val;
        }

        public void printDice() {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == 1) {
                        System.out.print(xArr[j] + " ");
                    } else if (j == 1) {
                        System.out.print(yArr[i] + " ");
                    } else {
                        System.out.print("0 ");
                    }
                }
                System.out.println();
            }
        }
    }
}
