package Backjoon.SamsungTest.BOJ12100;

import java.util.*;

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

            Map<String, Integer> maxMap = new HashMap<>();
            maxMap.put("max", 0);
            main.solution(inputMap, 0, maxMap);
            System.out.println(maxMap.get("max"));
        }
    }

    public void solution(Integer[][] inputMap, int count, Map<String, Integer> maxMap) {
        if (count == 5) {
            Integer max = maxValue(inputMap);
            if (maxMap.get("max") < max) {
                maxMap.put("max", max);
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            Integer[][] tempInputMap = copyMap(inputMap);
            moveMap(tempInputMap, i);
            solution(tempInputMap, count + 1, maxMap);
        }
    }

    public void moveMap(Integer[][] inputMap, int direction) {
        // direction
        // 0:left, 1:up, 2:right, 3:down
        Deque<SumInteger> integerQueue = new LinkedList<>();

        for (int i = 0; i < direction; i++) {
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

        for (int i = 0; i < direction; i++) {
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

    public Integer[][] copyMap(Integer[][] inputMap) {
        Integer[][] res = new Integer[inputMap.length][inputMap[0].length];

        for (int i = 0; i < inputMap.length; i++) {
            System.arraycopy(inputMap[i], 0, res[i], 0, inputMap[i].length);
        }

        return res;
    }

    public int maxValue(Integer[][] inputMap) {
        int max = 0;
        for (Integer[] integers : inputMap) {
            for (Integer integer : integers) {
                max = integer > max ? integer : max;
            }
        }

        return max;
    }


    static class SumInteger {
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
