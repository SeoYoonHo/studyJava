package Backjoon.WinterSchool.HashTree.BOJ1755;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Map<Integer, String> numberMap = new HashMap<>();
            numberMap.put(0, "zero");
            numberMap.put(1, "one");
            numberMap.put(2, "two");
            numberMap.put(3, "three");
            numberMap.put(4, "four");
            numberMap.put(5, "five");
            numberMap.put(6, "six");
            numberMap.put(7, "seven");
            numberMap.put(8, "eight");
            numberMap.put(9, "nine");

            List<Num> numberList = new ArrayList<>();

            int M = sc.nextInt();
            int N = sc.nextInt();

            for (int i = M; i <= N; i++) {
                int temp = i;
                int r = (int) Math.log10(temp);
                StringBuilder sb = new StringBuilder();
                for (int k = r; k >= 0; k--) {
                    int tenPow = (int) Math.pow(10, k);
                    int num = temp / tenPow;
                    temp -= num * tenPow;
                    sb.append(numberMap.get(num));
                    sb.append(" ");
                }

                numberList.add(new Num(sb.toString(), i));
            }

            numberList.sort(Comparator.comparing(o -> o.numStr));

            for (int i = 0; i < numberList.size(); i++) {
                if (i != 0 && i % 10 == 0) {
                    System.out.println();
                }

                System.out.print(numberList.get(i).num + " ");
            }
        }
    }

    static class Num {
        String numStr;
        int num;

        public Num(String numStr, int num) {
            this.numStr = numStr;
            this.num = num;
        }

        @Override
        public String toString() {
            return "Num{" +
                    "numStr='" + numStr + '\'' +
                    ", num=" + num +
                    '}';
        }
    }
}
