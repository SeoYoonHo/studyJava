package Stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.quiz1();
        main.quiz2();
        main.quiz3();

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
        Map<String, Integer> hobbyCntMap1 = userList.stream().flatMap(user -> Arrays.stream(user.getHobby().split(":"))).collect(Collectors.toMap(hobby -> hobby, hobby -> 1, (oldValue, newValue) -> newValue += oldValue));

        // 각 취미를 선호하는 정씨정 인원수
        Map<String, Integer> hobbyCntMap2 = userList.stream().filter(user -> user.getName().startsWith("정")).flatMap(user -> Arrays.stream((user.getHobby().split(":")))).collect(Collectors.toMap(hobby -> hobby, hobby -> 1, (oldValue, newValue) -> newValue += oldValue));

        String aa = "좋아좋아좋아";
        aa.replaceAll("좋아", "");

        // 소개내용에 좋아가 몇번 등장하는지 계산
        Optional<Integer> quiz3 = userList.stream().map(user -> (user.getIntro().length() - user.getIntro().replaceAll("좋아", "").length()) / 2).reduce((a, b) -> Integer.sum(a, b));

        System.out.println(quiz3.get());
    }

    public void quiz2() {
        List<String> WORDS = Arrays.asList("TONY", "a", "hULK", "B", "america", "X", "nebula", "Korea");

        //2.1 List에 저장된 단어들의 접두사가 각각 몇개씩 있는지 Map<String, Integer>으로 변환하여라
        Map<String, Integer> preCntMap = WORDS.stream().collect(Collectors.toMap(word -> word.substring(0, 1), word -> 1, (oldWord, newWord) -> newWord += oldWord));

        System.out.println(preCntMap);

        //2.2 List에 저장된 단어들 중에서 단어의 길이가 2 이상인 경우에만, 모든 단어를 대문자로 변환하여 스페이스로 구분한 하나의 문자열로 합한 결과를 반환하여라. ex) ["Hello", "a", "Island", "b"] -> “HI”
        WORDS.stream().filter(word -> word.length() > 1).map(String::toUpperCase).forEach(word -> System.out.print(word + " "));
        System.out.println();
    }

    public void quiz3() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        //3.1 위와 같은 숫자 리스트가 있을 때 모든 숫자 쌍의 배열 리스트를 반환하여라.
        //ex) numbers1 = [1,2,3], numbers2 = [3,4] -> [(1,3), (1,4), (2,3), (2,4), (3,3), (3,4)]
        List<Integer[]> answer1 = numbers1.stream().flatMap(num1 -> numbers2.stream().map(num2 -> new Integer[]{num1, num2})).collect(Collectors.toList());
        answer1.forEach(intArr -> System.out.println(intArr[0] + ", " + intArr[1]));

        //3.2 위와 같은 숫자 리스트가 있을 때 모든 숫자 쌍의 곱이 가장 큰 값을 반환하여라.
        //ex) numbers1 = [1,2,3], numbers2 = [3,4] -> 12
        Optional<Integer> answer2 = numbers1.stream().flatMap(num1 -> numbers2.stream().map(num2 -> num1 * num2)).reduce((oldNum,newNum) -> oldNum > newNum ? oldNum : newNum);
        System.out.println(answer2.get());
    }
}
