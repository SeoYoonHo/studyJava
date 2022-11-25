package KakaoM;

import java.util.*;

class Solution3 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();

//        int N = 2;
//        String S = "1A 2F 1C";

        int N = 50;
        String S = "1A 3C 2B 20G 5A";

//        int N = 1;
//        String S = "";

        System.out.println(solution3.solution(N, S));
    }

    public int solution(int N, String S) {
        // write your code in Java SE 8
        String[] seatArr = S.split(" ");
        Map<Integer, List<String>> seatMap = new HashMap<>();

        for (String seat : seatArr) {
            if(seat.equals("")){
                break;
            }
            Integer line = Integer.parseInt(seat.substring(0, seat.length() - 1));
            String col = seat.substring(seat.length() - 1);

            if (!col.equals("A") && !col.equals("K")) {
                if (seatMap.containsKey(line)) {
                    seatMap.get(line)
                           .add(col);
                } else {
                    List<String> tempList = new ArrayList<>();
                    tempList.add(col);
                    seatMap.put(line, tempList);
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (seatMap.containsKey(i)) {
                boolean left = true;
                boolean right = true;
                boolean middle = true;
                List<String> lineSeat = seatMap.get(i);

                for (String seat : lineSeat) {
                    if ("B".equals(seat) || "C".equals(seat)) {
                        left = false;
                    } else if ("D".equals(seat) || "E".equals(seat)) {
                        left = false;
                        middle = false;
                    } else if ("F".equals(seat) || "G".equals(seat)) {
                        middle = false;
                        right = false;
                    } else {
                        right = false;
                    }

                    if (!left && !middle && !right) {
                        break;
                    }
                }

                if (left || middle || right) {
                    count++;
                }
            } else {
                count += 2;
            }
        }

        return count;
    }

}