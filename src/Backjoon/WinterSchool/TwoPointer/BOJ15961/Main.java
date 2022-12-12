package Backjoon.WinterSchool.TwoPointer.BOJ15961;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt(); // 초밥 접시수
            int d = sc.nextInt(); // 초밥의 종류 수
            int k = sc.nextInt(); // 연속 해서 먹는 접시 수
            int c = sc.nextInt(); // 쿠폰 번호

            ShushiList shushiListClass = new ShushiList();

            List<Integer> shushiList = shushiListClass.shushiList;
            Map<Integer, Integer> shushiContainMap = shushiListClass.shushiContainMap;
            shushiListClass.coupon = c;

            for (int i = 0; i < N; i++) {
                int temp = sc.nextInt();
                shushiList.add(temp);
                shushiContainMap.put(temp, 0);
            }

//            System.out.println(shushiContainMap);

            int max = 0;

            for (int i = 0; i < k; i++) {
                shushiListClass.addLast();
            }
            //start : 0, end : 4

            while (shushiListClass.start < N) {
                int tempMax =
                        shushiListClass.coupDishCnt == 0 ? 1 + shushiListClass.dishCnt : shushiListClass.dishCnt;
                max = Math.max(max, tempMax);
                if (max == k + 1) {
                    break;
                }

//                System.out.println(shushiListClass);
//                System.out.println("max : " + max);

                shushiListClass.removeFirst();
                shushiListClass.addLast();
            }

            System.out.println(max);
        }
    }

    public static class ShushiList {
        List<Integer> shushiList = new ArrayList<>();
        Map<Integer, Integer> shushiContainMap = new HashMap<>();
        int coupDishCnt = 0;
        int dishCnt = 0;
        int start = 0;
        int end = 0;
        int coupon;

        public void removeFirst() {
            Integer removeInteger = shushiList.get(start);
            shushiContainMap.put(removeInteger, shushiContainMap.get(removeInteger) - 1);
            start++;
            if (shushiContainMap.get(removeInteger) == 0) {
                dishCnt--;
                if (removeInteger == coupon) {
                    coupDishCnt--;
                }
            }
        }

        public void addLast() {
            int endIndex = end % shushiList.size();
            int shushi = shushiList.get(endIndex);

            if (shushiContainMap.get(shushi) == 0) {
                dishCnt++;
                if (shushi == coupon) {
                    coupDishCnt++;
                }
            }

            end++;
            shushiContainMap.put(shushi, shushiContainMap.get(shushi) + 1);
        }


        @Override
        public String toString() {
            return "ShushiList{" +
                    "shushiList=" + shushiList +
                    ", shushiContainMap=" + shushiContainMap +
                    ", coupDishCnt=" + coupDishCnt +
                    ", dishCnt=" + dishCnt +
                    ", start=" + start +
                    ", end=" + end +
                    ", coupon=" + coupon +
                    '}';
        }
    }
}
