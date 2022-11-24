package Backjoon.WinterSchool.BOJ1302;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            Map<String, Integer> bookCount = new HashMap<>();
            for (int i = 0; i < N; i++) {
                String bookName = sc.next();
                if (bookCount.containsKey(bookName)) {
                    bookCount.put(bookName, bookCount.get(bookName) + 1);
                } else {
                    bookCount.put(bookName, 1);
                }
            }
//            System.out.println(bookCount);

            List<String> bookNameList = bookCount.keySet().stream()
                                                 .sorted(Comparator.comparing(bookCount::get)
                                                                   .reversed()
                                                                   .thenComparing(o -> (String) o))
                                                 .collect(Collectors.toList());
            System.out.println(bookNameList.get(0));
        }
    }
}
