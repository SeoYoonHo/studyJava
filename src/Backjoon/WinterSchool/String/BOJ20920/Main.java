package Backjoon.WinterSchool.String.BOJ20920;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String countStr = bf.readLine();
        String[] countStrArr = countStr.split(" ");
        int N = Integer.parseInt(countStrArr[0]);
        int M = Integer.parseInt(countStrArr[1]);

        Map<String, Integer> wordCount = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String str = bf.readLine();

            if (str.length() >= M) {
                Integer cnt = wordCount.get(str);
                cnt = (cnt == null) ? 1 : (cnt + 1);
                wordCount.put(str, cnt);
            }
        }

        String[] wordArr = wordCount.keySet().toArray(new String[0]);
        Arrays.parallelSort(wordArr, (o1, o2) -> {
            if (wordCount.get(o1) > wordCount.get(o2)) {
                return -1;
            } else if (wordCount.get(o1) < wordCount.get(o2)) {
                return 1;
            } else {
                int len1 = o1.length();
                int len2 = o2.length();
                if (len1 > len2) {
                    return -1;
                } else if (len1 < len2) {
                    return 1;
                } else {
                    return o1.compareTo(o2);
                }
            }
        });

        for (String word : wordArr) {
            bw.write(word);
            bw.newLine();
        }

        bw.flush();
        bf.close();
        bw.close();
    }
}
