package Backjoon.SamsungTest.BOJ3190;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int time = 0;
        try (Scanner sc = new Scanner(System.in)) {
            List<Point> appleList = new ArrayList<>();
            Point headerPoint = new Point(0, 0);
            Direction direction = Direction.right;
            Map<Integer, String> headerDirectionMap = new HashMap<>();
            List<Point> snakeList = new ArrayList<>();
            snakeList.add(headerPoint);

            int N = sc.nextInt();
            int K = sc.nextInt();

            for (int i = 0; i < K; i++) {
                Point tempPoint = new Point();
                tempPoint.x = sc.nextInt() - 1;
                tempPoint.y = sc.nextInt() - 1;
                appleList.add(tempPoint);
            }

            int L = sc.nextInt();

            for (int i = 0; i < L; i++) {
                Integer tempTime = sc.nextInt();
                String tempDirection = sc.next();
                headerDirectionMap.put(tempTime, tempDirection);
            }

//            System.out.println(headerDirectionMap);
            int[][] map = main.getMap(N, appleList);
//            main.printArr(map);

            while (true) {
                main.moveSnake(map, snakeList, direction);

                time++;
//                System.out.println("time : " + time);
//                main.printArr(map);
//                System.out.println();

                String turnDir = headerDirectionMap.get(time);
                if (turnDir != null) {
                    if (turnDir.equals("L")) {
                        direction = direction.getLeftDirection();
                    } else {
                        direction = direction.getRightDirection();
                    }
                }
            }
        } catch (Exception e) {
//            System.out.println(e.getMessage());
            System.out.println(time + 1);
//            throw new RuntimeException(e);
        }
    }

    public void moveSnake(int[][] inputMap, List<Point> snakeList, Direction direction) throws Exception {
        Point headerPoint = snakeList.get(0);
        Point tailPoint = snakeList.get(snakeList.size() - 1);
        Point tempPoint = new Point(headerPoint);
        Point tempTailPoint = new Point(tailPoint);

        for (Point point : snakeList) {
            inputMap[point.x][point.y] = 0;
        }

        switch (direction) {
            case left -> headerPoint.y--;
            case right -> headerPoint.y++;
            case up -> headerPoint.x--;
            case down -> headerPoint.x++;
        }

        if (headerPoint.x < 0 || headerPoint.x > inputMap.length - 1 || headerPoint.y < 0 || headerPoint.y > inputMap.length - 1) {
            throw new Exception("game over");
        }

        if (snakeList.size() > 2) {
            for (int i = 1; i < snakeList.size(); i++) {
                if (snakeList.get(i)
                             .equals(headerPoint)) {
                    throw new Exception("game over");
                }
            }
        }

        for (int i = snakeList.size() - 1; i > 0; i--) {
            Point point = snakeList.get(i);
            if (i != 1) {
                Point frontPoint = snakeList.get(i - 1);
                point.x = frontPoint.x;
                point.y = frontPoint.y;
            } else {
                point.x = tempPoint.x;
                point.y = tempPoint.y;
            }
        }

        if (inputMap[headerPoint.x][headerPoint.y] == 1) {
            snakeList.add(tempTailPoint);
        }

        for (Point point : snakeList) {
            inputMap[point.x][point.y] = 2;
        }
    }

    public int[][] getMap(int N, List<Point> appleList) {
        int[][] map = new int[N][N];

        map[0][0] = 2;

        for (Point applePoint : appleList) {
            map[applePoint.x][applePoint.y] = 1;
        }

        return map;
    }

    public void printArr(int[][] inputMap) {
        for (int[] integers : inputMap) {
            for (int integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    enum Direction {
        left(0), up(1), right(2), down(3);
        final int value;

        Direction(int i) {
            this.value = i;
        }

        Direction getLeftDirection() {
            int val = value - 1;
            if (val == -1) {
                val = 3;
            }
            Direction[] values = Direction.values();
            return values[val];
        }

        Direction getRightDirection() {
            int val = value + 1;
            if (val == 4) {
                val = 0;
            }
            Direction[] values = Direction.values();
            return values[val];
        }
    }
}
