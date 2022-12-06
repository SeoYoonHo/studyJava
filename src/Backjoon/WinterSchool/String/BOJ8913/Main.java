package Backjoon.WinterSchool.String.BOJ8913;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            List<String> stringList = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                stringList.add(sc.next());
            }

            for (String str : stringList) {
                System.out.println(main.solution(str));
            }
        }
    }

    public int solution(String str) {
        int res = 0;
        if(str.equals("")){
            res = 1;
        }
//        System.out.println(str);

        List<SubIndex> subIndexList = getSubIndexList(str);
//        System.out.println(subIndexList);

        for (int i = 0; i < subIndexList.size(); i++) {
            SubIndex subIndex= subIndexList.get(i);
            int subSize = subIndex.end - subIndex.begin;
            if(res != 1 && subSize > 1) {
                String tempStr = removeSubstr(str, subIndexList, i);
                res = solution(tempStr);
            }
        }

        return res;
    }

    public String removeSubstr(String str, List<SubIndex> subIndexList, int index) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < subIndexList.size(); i++) {
            if (i != index) {
                SubIndex subIndex = subIndexList.get(i);
                sb.append(str, subIndex.begin, subIndex.end);
            }
        }

        return sb.toString();
    }

    public List<SubIndex> getSubIndexList(String str) {
        char pre = 'c';
        List<SubIndex> subIndexList = new ArrayList<>();
        int index = 0;

        for (int i = 0; i < str.length(); i++) {
            char curChar = str.charAt(i);

            if (pre != curChar && i != 0) {
                SubIndex subIndex = new SubIndex();
                subIndex.begin = index;
                subIndex.end = i;
                subIndexList.add(subIndex);
                index = i;
            }

            pre = curChar;
        }
        SubIndex subIndex = new SubIndex();
        subIndex.begin = index;
        subIndex.end = str.length();
        subIndexList.add(subIndex);

        return subIndexList;
    }

    public static class SubIndex {
        int begin;
        int end;

        @Override
        public String toString() {
            return "SubIndex{" +
                    "begin=" + begin +
                    ", end=" + end +
                    '}';
        }
    }
}
