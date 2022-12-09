package Backjoon.WinterSchool.TwoPointer.BOJ1644;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            List<Integer> primeList = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                if (isPrime(i)) {
                    primeList.add(i);
                }
            }

            int start = 0;
            int end = 0;
            int count = 0;

            long sum = 0;
            while (start < primeList.size()) {
                if (sum < N) {
                    if (end < primeList.size()) {
                        end++;
                        sum += primeList.get(end - 1);
                    } else {
                        break;
                    }
                } else {
                    if (sum == N) {
                        count++;
                    }
//                    System.out.println("start : " + start + ", end : " + end);

                    sum -= primeList.get(start);
                    start++;
                }
            }


//            System.out.println(primeList);
            System.out.println(count);
        }
    }

    public static boolean isPrime(int n) {
        boolean res = true;

        if (n == 1) {
            return false;
        } else if (n == 2) {
            return true;
        }

        int s = (int) Math.sqrt(n);
        for (int i = 2; i <= s; i++) {
            if (n % i == 0) {
                res = false;
                break;
            }
        }

        return res;
    }
}
