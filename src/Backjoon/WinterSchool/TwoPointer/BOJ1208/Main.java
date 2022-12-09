package Backjoon.WinterSchool.TwoPointer.BOJ1208;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String countStr = bf.readLine();
        String[] countStrArr = countStr.split(" ");
        int N = Integer.parseInt(countStrArr[0]);
        int S = Integer.parseInt(countStrArr[1]);

        long[] inputArr = new long[N];
        long[] count = new long[1];

        String integerString = bf.readLine();
        StringTokenizer tokenizer = new StringTokenizer(integerString, " ");
        int index = 0;
        while (tokenizer.hasMoreElements()) {
            inputArr[index] = Integer.parseInt(tokenizer.nextToken());
            index++;
        }

        Map<Long, Integer> rightSumMap = getSumMap(inputArr);

        // S - Key값 = goal이 됨
        subSum(0, inputArr, 0, S, count, rightSumMap);

        long res = S == 0 ? count[0] - 1 : count[0];
        bw.write(res + "\n");

        bw.flush();
        bf.close();
        bw.close();
    }

    public static void subSum(long sum, long[] arr, int index, int goal, long[] count, Map<Long, Integer> rightSumMap) {
        if (index == arr.length / 2) {
//            System.out.println("sum : " + sum + ", rightSumCnt : " + rightSumMap.getOrDefault(goal - sum, 0));
            count[0] += rightSumMap.getOrDefault(goal - sum, 0);
            return;
        }

        subSum(sum, arr, index + 1, goal, count, rightSumMap);
        subSum(sum + arr[index], arr, index + 1, goal, count, rightSumMap);
    }

    public static Map<Long, Integer> getSumMap(long[] arr) {
        Map<Long, Integer> sumMap = new HashMap<>();
        subSum(0, arr, arr.length / 2, sumMap);
        return sumMap;
    }

    public static void subSum(long sum, long[] arr, int index, Map<Long, Integer> sumMap) {
        if (index == arr.length) {
            sumMap.computeIfPresent(sum, (key, value) -> value + 1);
            sumMap.putIfAbsent(sum, 1);
            return;
        }

        subSum(sum, arr, index + 1, sumMap);
        subSum(sum + arr[index], arr, index + 1, sumMap);
    }
}
