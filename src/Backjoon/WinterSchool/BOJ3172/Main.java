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
        for (int i = 0; i < N; i++) {
            char[] arr = bf.readLine()
                           .toCharArray();
            wordArr.add(arr);
        }

        long cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                cnt += main.compareChar(wordArr.get(i), wordArr.get(j));
            }
        }

        bw.write(cnt + "\n");

        bw.flush();
        bf.close();
        bw.close();
    }

    public int compareChar(char[] str1, char[] str2) {
        int len = Math.min(str1.length, str2.length);
        int resCnt = 0;
        int compare1 = 0;
        boolean flag1 = true;
        boolean flag2 = true;
        int compare2 = 0;
        for (int i = 0; i < len; i++) {
            if(flag1) {
                if (str1[i] > str2[i]) {
                    compare1 = 1;
                    flag1 = false;
                } else if (str1[i] < str2[i]) {
                    compare1 = -1;
                    flag1 = false;
                }
            }

            if(flag2) {
                if (str1[str1.length - 1 - i] > str2[str2.length - 1 - i]) {
                    compare2 = 1;
                    flag2 = false;
                } else if (str1[str1.length - 1 - i] < str2[str2.length - 1 - i]) {
                    compare2 = -1;
                    flag2 = false;
                }
            }

            if(!flag1 && !flag2){
                break;
            }
        }

        if (compare1 < 0) {
            if (compare2 > 0) {
                resCnt++;
            }
        } else {
            if (compare2 < 0) {
                resCnt++;
            }
        }

        return resCnt;
    }

    public void prinStr(char[] str) {
        for (char c : str) {
            System.out.print(c);
        }
        System.out.println();
    }
}
