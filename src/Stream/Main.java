package Stream;

import Stream.quiz1.User;
import Stream.quiz4.Trader;
import Stream.quiz4.Transaction;
import Stream.quiz6.Student;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.quiz1();
        main.quiz2();
        main.quiz3();
        main.quiz4();
        main.quiz5();
        main.quiz6();
    }

    public void quiz1() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("김프로", "축구:농구:야구", "구기종목 좋아요"));
        userList.add(new User("정프로", "개발:당구:축구,", "개발하는데 뛰긴 싫어"));
        userList.add(new User("앙몬드", "피아노", "죠르디가 좋아요 좋아좋아너무좋아"));
        userList.add(new User("죠르디", "스포츠댄스:개발", "개발하는 죠르디 좋아"));
        userList.add(new User("박프로", "골프:야구", "운동이 좋아요"));
        userList.add(new User("정프로", "개발:축구:농구", "개발도 좋고 운동도 좋아"));

        // 각 취미를 선호하는 인원수
        Map<String, Integer> hobbyCntMap1 = userList.stream().flatMap(user -> Arrays.stream(user.getHobby().split(":")))
                                                    .collect(Collectors.toMap(hobby -> hobby, hobby -> 1, (oldValue, newValue) -> newValue += oldValue));

        // 각 취미를 선호하는 정씨정 인원수
        Map<String, Integer> hobbyCntMap2 = userList.stream().filter(user -> user.getName().startsWith("정"))
                                                    .flatMap(user -> Arrays.stream((user.getHobby().split(":"))))
                                                    .collect(Collectors.toMap(hobby -> hobby, hobby -> 1, (oldValue, newValue) -> newValue += oldValue));

        String aa = "좋아좋아좋아";
        aa.replaceAll("좋아", "");

        // 소개내용에 좋아가 몇번 등장하는지 계산
        Optional<Integer> quiz3 = userList.stream()
                                          .map(user -> (user.getIntro().length() - user.getIntro().replaceAll("좋아", "")
                                                                                       .length()) / 2)
                                          .reduce((a, b) -> Integer.sum(a, b));

        System.out.println(quiz3.get());
    }

    public void quiz2() {
        List<String> WORDS = Arrays.asList("TONY", "a", "hULK", "B", "america", "X", "nebula", "Korea");

        //2.1 List에 저장된 단어들의 접두사가 각각 몇개씩 있는지 Map<String, Integer>으로 변환하여라
        Map<String, Integer> preCntMap = WORDS.stream()
                                              .collect(Collectors.toMap(word -> word.substring(0, 1), word -> 1, (oldWord, newWord) -> newWord += oldWord));

        System.out.println(preCntMap);

        //2.2 List에 저장된 단어들 중에서 단어의 길이가 2 이상인 경우에만, 모든 단어를 대문자로 변환하여 스페이스로 구분한 하나의 문자열로 합한 결과를 반환하여라. ex) ["Hello", "a", "Island", "b"] -> “HI”
        WORDS.stream().filter(word -> word.length() > 1).map(String::toUpperCase)
             .forEach(word -> System.out.print(word + " "));
        System.out.println();
    }

    public void quiz3() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        //3.1 위와 같은 숫자 리스트가 있을 때 모든 숫자 쌍의 배열 리스트를 반환하여라.
        //ex) numbers1 = [1,2,3], numbers2 = [3,4] -> [(1,3), (1,4), (2,3), (2,4), (3,3), (3,4)]
        List<Integer[]> answer1 = numbers1.stream()
                                          .flatMap(num1 -> numbers2.stream().map(num2 -> new Integer[]{num1, num2}))
                                          .collect(Collectors.toList());
        answer1.forEach(intArr -> System.out.println(intArr[0] + ", " + intArr[1]));

        //3.2 위와 같은 숫자 리스트가 있을 때 모든 숫자 쌍의 곱이 가장 큰 값을 반환하여라.
        //ex) numbers1 = [1,2,3], numbers2 = [3,4] -> 12
        Optional<Integer> answer2 = numbers1.stream().flatMap(num1 -> numbers2.stream().map(num2 -> num1 * num2))
                                            .reduce((oldNum, newNum) -> oldNum > newNum ? oldNum : newNum);
        System.out.println(answer2.get());
    }

    public void quiz4() {
        Trader kyu = new Trader("Kyu", "Seoul");
        Trader ming = new Trader("Ming", "Gyeonggi");
        Trader hyuk = new Trader("Hyuk", "Incheon");
        Trader hwan = new Trader("Hwan", "Seoul");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(kyu, 2019, 30000),
                new Transaction(kyu, 2020, 12000),
                new Transaction(ming, 2020, 40000),
                new Transaction(ming, 2020, 7100),
                new Transaction(hyuk, 2019, 5900),
                new Transaction(hwan, 2020, 4900)
        );

        // 4.1 2020년에 일어난 모든 거래 내역을 찾아 거래값을 기준으로 오름차순 정렬하라.
        List<Transaction> answer1 = transactions.stream().filter(transaction -> transaction.getYear() == 2020)
                                                .sorted(Comparator.comparing(transaction -> transaction.getValue()))
                                                .collect(Collectors.toList());
        System.out.println(answer1);

        // 4.2 거래 내역이 있는 거래자가 근무하는 모든 도시를 중복 없이 나열하라.
        List<String> answer2 = transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct()
                                           .collect(Collectors.toList());
        System.out.println(answer2);

        // 4.3 서울에서 근무하는 모든 거래자를 찾아서 이름순서대로 정렬하라.
        List<Trader> answer3 = transactions.stream()
                                           .filter(transaction -> "Seoul".equals(transaction.getTrader().getCity()))
                                           .map(transaction -> transaction.getTrader()).distinct()
                                           .sorted(Comparator.comparing(trader -> trader.getName()))
                                           .collect(Collectors.toList());
        System.out.println(answer3);

        // 4.4 모든 거래자의 이름을 순서대로 정렬하라
        List<String> answer4 = transactions.stream().map(transaction -> transaction.getTrader().getName())
                                           .sorted(Comparator.comparing(s -> s))
                                           .distinct()
                                           .collect(Collectors.toList());
        System.out.println(answer4);

        // 4.5 부산에 거래자가 있는지를 확인하라.
        List<Transaction> answer5 = transactions.stream().filter(transaction -> "Busan".equals(transaction.getTrader()
                                                                                                          .getCity()))
                                                .collect(Collectors.toList());
        System.out.println(answer5);

        // 4.6 서울에 거주하는 거래자의 모든 거래 내역을 구하라.
        List<Transaction> answer6 = transactions.stream().filter(transaction -> "Seoul".equals(transaction.getTrader()
                                                                                                          .getCity()))
                                                .collect(Collectors.toList());
        System.out.println(answer6);

        // 4.7 모든 거래 내역중에서 최댓값과 최솟값을 구하라. 단, 최댓값은 reduce를 이용하고 최솟값은 stream의 min()을 이용하라.
        Optional<Transaction> answer7_1 = transactions.stream()
                                                      .reduce((transaction1, transaction2) -> transaction1.getValue() > transaction2.getValue() ? transaction1 : transaction2);


        Optional<Transaction> answer7_2 = transactions.stream()
                                                      .min(Comparator.comparing(transaction -> transaction.getValue()));
        System.out.println(answer7_1);
        System.out.println(answer7_2);
    }

    public void quiz5() {
        String[] strArr = {"aaa", "bb", "c", "dddd"};

        // 5.1 문자열 배열 String[] strArr = {"aaa","bb","c","dddd"}의 모든 문자열의 길이를 더한 결과를 출력하여라.
        Optional<Integer> answer1 = Arrays.stream(strArr).map(s -> s.length())
                                          .reduce((integer, integer2) -> integer + integer2);
        System.out.println(answer1);

        // 5.2 문자열 배열 String[] strArr = {"aaa","bb","c","dddd"}의 문자열 중에서 가장 긴 것의 길이를 출력하시오.
        Optional<String> answer2 = Arrays.stream(strArr).max(Comparator.comparing(s -> s.length()));
        System.out.println(answer2.get().length());

        // 5.3 임의의 로또번호(1~45)를 정렬해서 출력하시오.
        List<Integer> answer3 = new Random().ints(10, 1, 45).sorted().boxed().collect(Collectors.toList());
        System.out.println(answer3);

        // 5.4 두 개의 주사위를 굴려서 나온 눈의 합이 6인 경우를 모두 출력하시오.
        List<Integer[]> answer4 = IntStream.rangeClosed(1, 6).boxed()
                                           .flatMap(integer -> IntStream.rangeClosed(1, 6).boxed()
                                                                        .map(integer1 -> new Integer[]{integer, integer1}))
                                           .filter(integers -> integers[0] + integers[1] == 6)
                                           .collect(Collectors.toList());

        answer4.forEach(integers -> System.out.println(integers[0] + ", " + integers[1]));
    }

    public void quiz6() {
        Student[] stuArr = new Student[]{
                new Student("나자바", true, 1, 1, 300),
                new Student("김지미", false, 1, 1, 250),
                new Student("김자바", true, 1, 1, 200),
                new Student("이지미", false, 1, 2, 150),
                new Student("남자바", true, 1, 2, 100),
                new Student("안지미", false, 1, 2, 50),
                new Student("황지미", false, 1, 3, 100),
                new Student("강지미", false, 1, 4, 150),
                new Student("이자바", true, 1, 3, 200),
                new Student("나자바", true, 2, 1, 300),
                new Student("김지미", false, 2, 1, 250),
                new Student("김자바", true, 2, 1, 200),
                new Student("이지미", false, 2, 2, 150),
                new Student("남자바", true, 2, 2, 100),
                new Student("안지미", false, 2, 2, 50),
                new Student("황지미", false, 2, 3, 100),
                new Student("강지미", false, 2, 4, 150),
                new Student("이자바", true, 2, 3, 200)
        };

        //문제 6.1
        //stuArr에서 불합격(150점 미만)한 학생의 수를 남자와 여자로 구별하여라. (Boolean, List)
        Map<Boolean, List<Student>> answer1 =  Arrays.stream(stuArr).filter(student -> student.getScore() < 150).collect(Collectors.groupingBy(Student::isMale));
        System.out.println(answer1);


        //문제 6.2
        //각 반별 총점을 학년 별로 나누어 구하여라 (Map<Integer, Map<Integer, Integer>>)
        Map answer2 = Arrays.stream(stuArr).collect(Collectors.groupingBy(Student::getBan, Collectors.groupingBy(Student::getHak, Collectors.summingInt(Student::getScore))));
        System.out.println(answer2);
    }
}
