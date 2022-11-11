package naver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();

        String S = "aaaa";
        int[] C = {3, 4, 5, 6};

        System.out.println(solution1.solution(S, C));

    }

    public int solution(String S, int[] C) {
        // write your code in Java SE 8
        int sum = 0;
        String preStr = "";
        HashMap<String, List<Integer>> strMap = new HashMap<>();

        for (int i = 0; i < S.length(); i++) {
            String currentStr = S.substring(i, i + 1);

            if (preStr.equals(currentStr)) {
                if (strMap.keySet()
                          .contains(currentStr)) {
                    strMap.get(currentStr)
                          .add(C[i]);
                } else {
                    List<Integer> tempList = new ArrayList<Integer>();
                    tempList.add(C[i - 1]);
                    tempList.add(C[i]);
                    strMap.put(currentStr, tempList);
                }
            }

            preStr = currentStr;
        }

        System.out.println(strMap);


        for (List<Integer> integers : strMap.values()) {
            int tempMax = 0;
            int tempSum = 0;
            for (Integer integer : integers) {
                if (tempMax < integer) {
                    tempMax = integer;
                }
                tempSum += integer;
            }

            sum += tempSum - tempMax;
        }

        return sum;
    }
}