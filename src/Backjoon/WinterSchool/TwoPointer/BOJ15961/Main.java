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
            Deque<Integer> queue = shushiListClass.queue;

            List<Integer> shushiList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                shushiList.add(sc.nextInt());
            }

//            System.out.println(shushiList);
//            System.out.println();

            int start = 0;
            int end = 0;
            int max = 0;

            while (start < N - 1) {
                if (queue.size() < k) {
                    int endIndex = end % N;
                    shushiListClass.addLast(shushiList.get(endIndex), c);
                    end++;
                } else {
                    shushiListClass.removeFirst(c);
                    int endIndex = end % N;
                    shushiListClass.addLast(shushiList.get(endIndex), c);
                    start++;
                    end++;
                }

                if (queue.size() > 1 && Objects.equals(queue.peekFirst(), queue.peekLast())) {
                    shushiListClass.removeFirst(c);
                    start++;


                }
//                System.out.println(shushiListClass);
//                System.out.println("start : " + start + ", end : " + end);

                int tempMax =
                        shushiListClass.coupDishCnt == 0 ? 1 + shushiListClass.dishCnt : shushiListClass.dishCnt;
                max = Math.max(max, tempMax);
                if (max == k + 1) {
                    break;
                }
            }

            System.out.println(max);
        }
    }

    public static class ShushiList {
        Deque<Integer> queue = new LinkedList<>();
        int coupDishCnt = 0;
        int dishCnt = 0;

        public void removeFirst(int c) {
            dishCnt--;
            if (queue.peekFirst() == c) {
                coupDishCnt--;
            }
            queue.removeFirst();
        }

        public void addLast(int i, int c) {
            dishCnt++;
            if (i == c) {
                coupDishCnt++;
            }
            queue.add(i);
        }

        @Override
        public String toString() {
            return "ShushiList{" +
                    "queue=" + queue +
                    ", coupDishCnt=" + coupDishCnt +
                    ", dishCnt=" + dishCnt +
                    '}';
        }
    }
}
