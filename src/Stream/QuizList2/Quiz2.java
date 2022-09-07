package Stream.QuizList2;

import Stream.QuizList1.quiz4.Trader;
import Stream.QuizList1.quiz4.Transaction;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Quiz2 {

    public void quiz1() {
        String[] alphabetList = new String[]{
                "ABCAAC",
                "AABBCC",
                "CCCCCC",
                "CCBBAA",
                "CCCAAA"
        };

        // 1. alphabetList 각각의 스트링에 있는 고유한 알파벳 개수가 들어있는
        // List<Long> 형태의 배열을 반환하시오.
        List answer1 = Arrays.stream(alphabetList).map(s -> s.chars().distinct().count()).collect(Collectors.toList());
        System.out.println(answer1);

        // 2. alphabetList 각각의 스트링에 대해 알파벳을 키로,
        // 키에 해당하는 알파벳 개수를 값으로 하는
        // List<Map<String, Long>> 형태의 배열을 반환하시오.
        List answer2 = Arrays.stream(alphabetList)
                             .map(s -> s.chars().boxed()
                                        .collect(Collectors.groupingBy(integer -> Character.toString((char) integer.intValue()), Collectors.counting())))
                             .collect(Collectors.toList());
        System.out.println(answer2);


        // 3. alphabetList 각각의 스트링에 대해 알파벳을 키로,
        // 키에 해당하는 알파벳의 index 배열을 값으로 하는
        // List<Map<String, List<Integer>>> 형태의 배열을 반환하시오.
        List<Map<String, List<Integer>>> answer3 = Arrays.stream(alphabetList)
                                                         .map(s -> s.split(""))
                                                         .map(s -> IntStream.range(0, s.length)
                                                                            .boxed()
                                                                            .collect(Collectors.groupingBy(i -> s[i])))
                                                         .collect(Collectors.toList());
        System.out.println(answer3);
    }
    public void quiz2() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Trader> traders = Arrays.asList(raoul, mario, alan, brian);

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //1.2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리하시오.
        List<Integer> answer1 = transactions.stream().filter(transaction -> transaction.getYear() == 2011)
                                            .map(transaction -> transaction.getValue()).sorted()
                                            .collect(Collectors.toList());
        System.out.println(answer1);

        //2. 거래자가 근무하는 모든 도시를 중복 없이 나열하시오.
        List answer2 = transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct()
                                   .collect(Collectors.toList());
        System.out.println(answer2);

        //3.케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오.(중복 제거)
        List answer3 = transactions.stream().map(transaction -> transaction.getTrader())
                                   .filter(trader -> trader.getCity().equals("Cambridge")).distinct()
                                   .sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());
        System.out.println(answer3);

        //4.모든 거래자의 이름을 알파벳순으로 정렬해서 반환하시오.
        List answer4 = transactions.stream().map(transaction -> transaction.getTrader().getName()).distinct()
                                   .sorted().collect(Collectors.toList());
        System.out.println(answer4);

        //5.밀라노에 거래자가 있는가?
        boolean isMilan = transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("Milan"))
                                      .count() > 0;
        System.out.println(isMilan);

        //6.케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하시오.
        List answer6 = transactions.stream()
                                   .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                                   .map(transaction -> transaction.getValue()).collect(Collectors.toList());
        System.out.println(answer6);


        //7.전체 트랜잭션 중 최댓값은 얼마인가?
        Transaction answer7 = transactions.stream().max(Comparator.comparing(Transaction::getValue)).get();
        System.out.println(answer7);
    }


}
