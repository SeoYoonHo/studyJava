package KakaoM;

import java.util.HashMap;
import java.util.Map;

class Solution2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

//        int N = 4;
//        int[] A = {1, 2, 4, 4, 3};
//        int[] B = {2, 3, 1, 3, 1};

        int N = 4;
        int[] A = {1,2,1,3};
        int[] B = {2,4,3,4};

        boolean res = solution2.solution(N, A, B);
        System.out.println(res);
    }

    public boolean solution(int N, int[] A, int[] B) {
        // write your code in Java SE 8
        Map<String, Boolean> loadMap = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            String key = A[i] + "," + B[i];
            loadMap.put(key, true);
        }

        for (int i = 0; i < N - 1; i++) {
            String key1 = (i + 1) + "," + (i + 2);
            String key2 = (i + 2) + "," + (i + 1);

            if (loadMap.get(key1) == null && loadMap.get(key2) == null) {
                return false;
            }
        }

        return true;
    }
}
