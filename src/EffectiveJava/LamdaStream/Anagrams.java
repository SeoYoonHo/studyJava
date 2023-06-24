package EffectiveJava.LamdaStream;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class Anagrams {
    public static void main(String[] args) {
        String[] words = {"asdf", "fdas", "sdfa", "dfas", "tuioe", "wwwwww"};
        Map<String, Set<String>> groups_noStream = new HashMap<>();

        // 스트림을 사용하지 않았다.
        for (String word : words) {
            groups_noStream.computeIfAbsent(alphabetize(word), s -> new TreeSet<>())
                           .add(word);
        }

        for (Set<String> group : groups_noStream.values()) {
            if (group.size() >= 1) {
                System.out.println(group.size() + ": " + group);
            }
        }

        // 스트림을 사용했으나 과하게 사용하여 코드 파악이 더 어려움
        Arrays.stream(words)
              .collect(groupingBy(word -> word.chars()
                                              .sorted()
                                              .collect(StringBuilder::new,
                                                      (sb, c) -> sb.append((char) c), StringBuilder::append)
                                              .toString()))
              .values()
              .stream()
              .filter(group -> group.size() >= 1)
              .map(group -> group.size() + ": " + group)
              .forEach(System.out::println);

        // 스트림을 적당히 사용한 예
        Arrays.stream(words)
              .collect(groupingBy(word -> alphabetize(word)))
              .values()
              .stream()
              .filter(group -> group.size() >= 1)
              .forEach(g -> System.out.println(g.size() + ": " + g));
    }

    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}
