package Backjoon.SamsungTest.BOJ13460;

import java.awt.*;
import java.util.Scanner;

public class Main {
    public static int cnt = -1;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            String[][] inputMap = new String[N][M];
            Point redPoint = new Point();
            Point bluePoint = new Point();

            for (int i = 0; i < N; i++) {
                String tempStr = sc.next();
                for (int j = 0; j < M; j++) {
                    inputMap[i][j] = tempStr.substring(j, j + 1);
                    if (inputMap[i][j].equals("R")) {
                        redPoint.setLocation(i, j);
                    } else if (inputMap[i][j].equals("B")) {
                        bluePoint.setLocation(i, j);
                    }
                }
            }

//            printArr(inputMap);

            solution(inputMap, redPoint, bluePoint, -1, 0);

            System.out.println( cnt);
        }
    }

    public static void solution(String[][] inputMap, Point redPoint, Point bluePoint, int prevDirection, int count) {

        if(cnt > 0 && count >= cnt){
            return;
        }

        if(count > 10 ){
            return;
        }
        else if (inputMap[redPoint.x][redPoint.y].equals("O") && !inputMap[bluePoint.x][bluePoint.y].equals("O")) {
//            System.out.println();
//            printArr(inputMap);
            cnt = count;
            return;
        }

        for (int i = 0; i < 4; i++) {
            String[][] tempMap = copyMap(inputMap);
            Point tempRedPoint = new Point();
            tempRedPoint.setLocation(redPoint);
            Point tempBluePoint = new Point();
            tempBluePoint.setLocation(bluePoint);

            if (prevDirection != i) {
                moveMap(tempMap, tempRedPoint, tempBluePoint, i);
                solution(tempMap, tempRedPoint, tempBluePoint, i, count + 1);
            }
        }


    }

    public static int moveMap(String[][] inputMap, Point redPoint, Point bluePoint, int direction) {
        int count = 0;
        boolean move = true;
        boolean move1, move2;
        // direction
        // 0:left, 1:right, 2:up, 3:down

        switch (direction) {
            case 0:
                while (move) {
                    if (redPoint.y < bluePoint.y) {
                        move1 = moveBall(inputMap, redPoint, direction, "R");
                        move2 = moveBall(inputMap, bluePoint, direction, "B");
                    } else {
                        move1 = moveBall(inputMap, bluePoint, direction, "B");
                        move2 = moveBall(inputMap, redPoint, direction, "R");
                    }
                    move = move1 || move2;
                }

                break;
            case 1:
                while (move) {
                    if (redPoint.y < bluePoint.y) {
                        move1 = moveBall(inputMap, bluePoint, direction, "B");
                        move2 = moveBall(inputMap, redPoint, direction, "R");
                    } else {
                        move1 = moveBall(inputMap, redPoint, direction, "R");
                        move2 = moveBall(inputMap, bluePoint, direction, "B");
                    }
                    move = move1 || move2;
                }

                break;
            case 2:
                while (move) {
                    if (redPoint.x < bluePoint.x) {
                        move1 = moveBall(inputMap, redPoint, direction, "R");
                        move2 = moveBall(inputMap, bluePoint, direction, "B");
                    } else {
                        move1 = moveBall(inputMap, bluePoint, direction, "B");
                        move2 = moveBall(inputMap, redPoint, direction, "R");
                    }
                    move = move1 || move2;
                }

                break;
            case 3:
                while (move) {
                    if (redPoint.x > bluePoint.x) {
                        move1 = moveBall(inputMap, bluePoint, direction, "B");
                        move2 = moveBall(inputMap, redPoint, direction, "R");
                    } else {
                        move1 = moveBall(inputMap, redPoint, direction, "R");
                        move2 = moveBall(inputMap, bluePoint, direction, "B");
                    }
                    move = move1 || move2;
                }

                break;

        }

        return count;
    }

    public static boolean moveBall(String[][] inputMap, Point point, int direction, String str) {
        boolean isMove = false;

        if (inputMap[point.x][point.y].equals("O")) {
            return false;
        }

        switch (direction) {
            case 0:
                if (inputMap[point.x][point.y - 1].equals(".")) {
                    inputMap[point.x][point.y] = ".";
                    inputMap[point.x][--point.y] = str;
                    isMove = true;
                } else if (inputMap[point.x][point.y - 1].equals("O")) {
                    inputMap[point.x][point.y] = ".";
                    point.y--;
                    isMove = true;
                }
                break;
            case 1:
                if (inputMap[point.x][point.y + 1].equals(".")) {
                    inputMap[point.x][point.y] = ".";
                    inputMap[point.x][++point.y] = str;
                    isMove = true;
                } else if (inputMap[point.x][point.y + 1].equals("O")) {
                    inputMap[point.x][point.y] = ".";
                    point.y++;
                    isMove = true;
                }
                break;
            case 2:
                if (inputMap[point.x - 1][point.y].equals(".")) {
                    inputMap[point.x][point.y] = ".";
                    inputMap[--point.x][point.y] = str;
                    isMove = true;
                } else if (inputMap[point.x - 1][point.y].equals("O")) {
                    inputMap[point.x][point.y] = ".";
                    point.x--;
                    isMove = true;
                }
                break;
            case 3:
                if (inputMap[point.x + 1][point.y].equals(".")) {
                    inputMap[point.x][point.y] = ".";
                    inputMap[++point.x][point.y] = str;
                    isMove = true;
                } else if (inputMap[point.x + 1][point.y].equals("O")) {
                    inputMap[point.x][point.y] = ".";
                    point.x++;
                    isMove = true;
                }
                break;
        }

        return isMove;
    }

    public static String[][] copyMap(String[][] inputMap) {
        String[][] res = new String[inputMap.length][inputMap[0].length];

        for (int i = 0; i < inputMap.length; i++) {
            for (int j = 0; j < inputMap[i].length; j++) {
                res[i][j] = inputMap[i][j];
            }
        }

        return res;
    }



    public static void printArr(String[][] arr) {
        for (String[] strs : arr) {
            for (String str : strs) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }
}
