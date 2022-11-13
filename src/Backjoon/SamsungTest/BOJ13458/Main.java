package Backjoon.SamsungTest.BOJ13458;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // 시험장 수
            int N = sc.nextInt();
            // 시험장별 응시자 수
            List<Integer> A = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                Integer temp = sc.nextInt();
                A.add(temp);
            }

            // 총감독관이 감시 응시자수
            int B = sc.nextInt();
            // 부감독관 감시 응시자수
            int C = sc.nextInt();

            long sum = 0;
            for (int i = 0; i < N; i++) {
                sum += 1;

                int remain = A.get(i) - B;
                if(remain < 0)
                    continue;

                if (remain % C == 0) {
                    sum += remain / C;
                } else {
                    sum += remain / C + 1;
                }
            }

            System.out.println(sum);
        }
    }
}
