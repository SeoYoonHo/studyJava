package ct.naver;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

        solution2.solution(0, 1, 8);

    }

    public String solution(int A, int B, int C) {
        // write your code in Java SE 8
        List<String> maxStrList = new ArrayList<>();
        maxStrList.add("");


        sol("", A, B, C, maxStrList);
//        System.out.println("max : " + maxStrList.get(0));
        return maxStrList.get(0);
    }

    public void sol(String str, int A, int B, int C, List<String> maxStrList) {
        int length = str.length();
        if (length > 2) {
            String lastStr = str.substring(length - 3, length);
            if (lastStr.equals("aaa") || lastStr.equals("bbb") || lastStr.equals("ccc")) {
                return;
            }
        }

        if(str.length() > maxStrList.get(0).length()){
            maxStrList.remove(0);
            maxStrList.add(str);
        }

//        if (A == 0 && B == 0 && C == 0) {
//            System.out.println(str);
//        }

        for (int i = 0; i < 3; i++) {
            if (A > 0) {
                sol(str + "a", A - 1, B, C, maxStrList);
            }

            if (B > 0) {
                sol(str + "b", A, B - 1, C, maxStrList);
            }

            if (C > 0) {
                sol(str + "c", A, B, C - 1, maxStrList);
            }
        }
    }
}