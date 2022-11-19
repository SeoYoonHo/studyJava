package Backjoon.WinterSchool.BOJ2135;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        try (Scanner sc = new Scanner(System.in)) {
            String inputStr = sc.next();

//            System.out.println(main.runLengthEncoding(inputStr));
            System.out.println(main.improvedRunLengthEncoding(inputStr));
        }
    }

    public int runLengthEncoding(String str) {
        String prevStr = "";
        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (int i = 0; i < str.length(); i++) {
            String currStr = str.substring(i, i + 1);
            if (!prevStr.equals(currStr)) {
                if (count > 1) {
                    sb.append(count);
                }

                sb.append(currStr);
                count = 1;
            } else {
                count++;
            }

            prevStr = currStr;
        }

        if (count > 1) {
            sb.append(count);
        }

//        System.out.println(sb.toString());

        return sb.length();
    }

    public int improvedRunLengthEncoding(String str) {
        List<StringCount> stringCountList = firstEncode(str);
        System.out.println(stringCountList);

        for(StringCount stringCount : stringCountList){

        }

        return 0;
    }

    public List<StringCount> firstEncode(String str) {
        int curPos = 0;
        boolean isSub = false;
        List<StringCount> strCountList = new ArrayList<>();

        for (int length = 1; length <= str.length() / 2; length++) {
            String a = str.substring(0, length);

            int count = 1;
            curPos = count * length;

            while (curPos + length <= str.length()) {
                String b = str.substring(curPos, curPos + length);

                if (a.equals(b)) {
                    count++;
                    curPos = count * length;
                } else {
                    break;
                }
            }


            if (count > 1) {
                isSub = true;

                StringCount stringCount = new StringCount();
                stringCount.str = a;
                stringCount.count = count;

                StringCount remainStringCount = new StringCount();
                remainStringCount.str = str.substring(a.length() * (count));
                remainStringCount.count = 1;

                strCountList.add(stringCount);

                if(!remainStringCount.str.equals("")) {
                    strCountList.add(remainStringCount);
                }

                break;
            }
        }

        if (!isSub) {
            StringCount stringCount = new StringCount();
            stringCount.str = str;
            stringCount.count = 1;

            strCountList.add(stringCount);
        }

        return strCountList;
    }


    public static class StringCount {
        String str;
        Integer count;

        @Override
        public String toString() {
            return "StringCount{" +
                    "str='" + str + '\'' +
                    ", count=" + count +
                    '}';
        }
    }
}
