package Backjoon.WinterSchool.HashTree.BOJ18870;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            List<Integer> integerList = new ArrayList<>();
            TreeSet<Integer> sortSet = new TreeSet<>();

            for (int i = 0; i < N; i++) {
                int temp = sc.nextInt();
                integerList.add(temp);
                sortSet.add(temp);
            }

//            System.out.println(sortSet);
            Map<Integer, Integer> sortMap = new HashMap<>();

            int index = 0;
            for (Integer integer : sortSet) {
                sortMap.put(integer, index);
                index++;
            }
//            System.out.println(sortMap);

            StringBuilder sb = new StringBuilder();
            for (Integer integer : integerList) {
                sb.append(sortMap.get(integer));
                sb.append(" ");
            }

            System.out.println(sb);
        }
    }
}
