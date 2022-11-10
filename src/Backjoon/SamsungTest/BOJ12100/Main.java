package Backjoon.SamsungTest.BOJ12100;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();

            Integer[][] inputMap = new Integer[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    inputMap[i][j] = sc.nextInt();
                }
            }

            main.moveMap(inputMap, 2);
            main.printArr(inputMap);

        }
    }

    public void moveMap(Integer[][] inputMap, int direction) {
        // direction
        // 0:left, 1:down, 2:right, 3:up
        Deque<SumInteger> integerQueue = new LinkedList<>();

        for(int i=0;i<direction;i++){
            leftRotate(inputMap);
        }

        for (int i = 0; i < inputMap.length; i++) {
            for (int j = 0; j < inputMap[i].length; j++) {
                Integer integer = inputMap[i][j];
                if (integer != 0) {
                    SumInteger sumInteger = integerQueue.pollLast();
                    if (sumInteger == null) {
                        SumInteger tempInteger = new SumInteger();
                        tempInteger.val = integer;
                        integerQueue.add(tempInteger);

                    } else {
                        if (!sumInteger.isSum && sumInteger.val == integer) {
                            sumInteger.val *= 2;
                            sumInteger.isSum = true;
                            integerQueue.add(sumInteger);
                        } else {
                            SumInteger tempInteger = new SumInteger();
                            tempInteger.val = integer;
                            integerQueue.add(sumInteger);
                            integerQueue.add(tempInteger);
                        }
                    }
                }
                inputMap[i][j] = 0;
            }


            int k = 0;
            for (SumInteger sumInteger : integerQueue) {
                inputMap[i][k] = sumInteger.val;
                k++;
            }
            integerQueue.clear();
        }

        for(int i=0;i<direction;i++){
            rightRotate(inputMap);
        }
    }

    public void rightRotate(Integer[][] inputMap) {
        int n = inputMap.length;
        Integer[][] rotate = copyMap(inputMap);

        for (int i = 0; i < rotate.length; i++) {
            for (int j = 0; j < rotate[i].length; j++) {
                inputMap[i][j] = rotate[n - 1 - j][i];
            }
        }
    }

    public void leftRotate(Integer[][] inputMap) {
        int n = inputMap.length;
        Integer[][] rotate = copyMap(inputMap);

        for (int i = 0; i < rotate.length; i++) {
            for (int j = 0; j < rotate[i].length; j++) {
                inputMap[i][j] = rotate[j][n - i - 1];
            }
        }
    }

    public static Integer[][] copyMap(Integer[][] inputMap) {
        Integer[][] res = new Integer[inputMap.length][inputMap[0].length];

        for (int i = 0; i < inputMap.length; i++) {
            for (int j = 0; j < inputMap[i].length; j++) {
                res[i][j] = inputMap[i][j];
            }
        }

        return res;
    }

    public void printArr(Integer[][] arr) {
        for (Integer[] strs : arr) {
            for (Integer str : strs) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }

    class SumInteger {
        public int val = 0;
        public boolean isSum = false;

        @Override
        public String toString() {
            return "SumInteger{" +
                    "val=" + val +
                    ", isSum=" + isSum +
                    '}';
        }
    }

}
