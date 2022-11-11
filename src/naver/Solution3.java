package naver;

import java.util.*;
import java.util.stream.Collectors;

public class Solution3 {

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();

        int N = 4;
        int[] A = {1, 3};
        int[] B = {2, 4};

        System.out.println(solution3.solution(N, A, B));
    }

    public int solution(int N, int[] A, int[] B) {
        // write your code in Java SE 8
        Map<Integer, Integer> graphCntMap = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            Set keySet = graphCntMap.keySet();
            if (keySet.contains(A[i])) {
                graphCntMap.put(A[i], graphCntMap.get(A[i]) + 1);
            } else {
                graphCntMap.put(A[i], 1);
            }

            if (keySet.contains(B[i])) {
                graphCntMap.put(B[i], graphCntMap.get(B[i]) + 1);
            } else {
                graphCntMap.put(B[i], 1);
            }
        }

        List<Integer> resList =
                graphCntMap.values()
                           .stream()
                           .sorted((o1, o2) -> o2.compareTo(o1))
                           .collect(Collectors.toList());

        int temp = N;
        int sum = 0;
        for (Integer integer : resList) {
            sum += integer * temp;
            temp--;
        }

        return sum;
    }
}