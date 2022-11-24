package Backjoon.WinterSchool.BOJ3172;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());
        List<char[]> wordArr = new ArrayList<>();
        List<char[]> wordReverseArr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            char[] arr = bf.readLine().toCharArray();
            wordArr.add(arr);
            wordReverseArr.add(main.reverseString(arr));
        }

        long cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j && !main.isLove(wordArr.get(i), wordArr.get(j), wordReverseArr.get(i),
                        wordReverseArr.get(j))) {
                    cnt++;
                }
            }
        }

        bw.write(cnt + "\n");

        bw.flush();
        bf.close();
        bw.close();
    }

    public boolean isLove(char[] str1, char[] str2, char[] str1Resver, char[] str2Reverse) {
        boolean res = true;
        int compare1 = compareChar(str1, str2);

        if (compare1 < 0) {
            int reverseCompare = compareChar(str1Resver, str2Reverse);
            if (reverseCompare > 0) {
                res = false;
            }
        }

        return res;
    }

    public int compareChar(char[] str1, char[] str2) {
        int len = Math.min(str1.length, str2.length);
        int compare = 0;
        for (int i = 0; i < len; i++) {
            if (str1[i] > str2[i]) {
                return 1;
            } else if (str1[i] < str2[i]) {
                return -1;
            }
        }

        return compare;
    }

    public char[] reverseString(char[] s) {
        char[] res = new char[s.length];
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            res[i] = s[s.length - i - 1];
            res[s.length - i - 1] = temp;
        }

        if (s.length % 2 == 1) {
            res[s.length / 2] = s[s.length / 2];
        }
        return res;
    }

    public void prinStr(char[] str) {
        for (char c : str) {
            System.out.print(c);
        }
        System.out.println();
    }
}
