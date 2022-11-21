package Backjoon.WinterSchool.BOJ2135;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        try (Scanner sc = new Scanner(System.in)) {
            String inputStr = sc.next();

//            System.out.println(main.runLengthEncoding(inputStr));
//            System.out.println(main.improvedRunLengthEncoding(inputStr));

            int size = inputStr.length();
//            int rle = main.runLengthEncoding(inputStr);
            int imprle = main.improvedRunLengthEncoding(inputStr);
//            size = Math.min(size,rle);
            size = Math.min(size,imprle);

            System.out.println(size);
        }
    }

    public int runLengthEncoding(String str) {
        String prevStr = "";
        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (int i = 0; i < str.length(); i++) {
            String currStr = str.substring(i, i + 1);
            if (!prevStr.equals(currStr)) {
                if (count > 1) {
                    sb.append(count);
                }

                sb.append(currStr);
                count = 1;
            } else {
                count++;
            }

            prevStr = currStr;
        }

        if (count > 1) {
            sb.append(count);
        }

        System.out.println(sb.toString());

        return sb.length();
    }

    public int improvedRunLengthEncoding(String inputStr) {
        int strlen = inputStr.length();
        int[][] dp = new int[strlen + 1][strlen + 1];

        for (int i = 0; i < strlen; i++) {
            dp[i][i + 1] = 1;
        }

        for (int len = 2; len <= strlen; len++) {
            List<Integer> divList = get_div(len);

            for (int start = 0; start <= strlen - len; start++) {
                int compressed = len;

                for (Integer div : divList) {
                    if (can_compressed(inputStr, start, start + len, div)) {
                        compressed = Math.min(compressed, 2 + dp[start][start + div] + get_length(len / div));
                    }
                }

                for (int j = start + 1; j < start + len; j++) {
                    compressed = Math.min(compressed, dp[start][j] + dp[j][start + len]);
                }

                dp[start][start + len] = compressed;
            }
        }

//        printArr(dp);
        return dp[0][strlen];
    }

    public int get_length(int num) {
        int pivot = 1, ret = 0;

        while (num / pivot != 0) {
            pivot *= 10;
            ret++;
        }

        return ret;
    }

    public boolean can_compressed(String inputStr, int start, int end, int segment) {
        for (int i = start; i < end; i += segment) {
            if (!inputStr.substring(start, start + segment).equals(inputStr.substring(i, i + segment))) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> get_div(int num) {
        List<Integer> res = new ArrayList<>();

        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                res.add(i);
            }
        }

        return res;
    }

    public void printArr(int[][] inputArr) {
        for (int[] arr : inputArr) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
