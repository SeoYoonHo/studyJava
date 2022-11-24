package Backjoon.WinterSchool.BOJ5211;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<String> aMusic = new HashSet<>();
        aMusic.add("A");
        aMusic.add("D");
        aMusic.add("E");
        Set<String> cMusic = new HashSet<>();
        cMusic.add("C");
        cMusic.add("F");
        cMusic.add("G");

        String sheetMusic = bf.readLine();

        String[] sheetArr = sheetMusic.split("\\|");
        int aFirstCnt = 0;
        int cFirstCnt = 0;
        String first;
        for (String str : sheetArr) {
            first = str.substring(0, 1);

            if (aMusic.contains(first)) {
                aFirstCnt++;
            } else if (cMusic.contains(first)) {
                cFirstCnt++;
            }
        }

        if (aFirstCnt > cFirstCnt) {
            bw.write("A-minor");
        } else if (aFirstCnt < cFirstCnt) {
            bw.write("C-major");
        } else {
            String last = sheetArr[sheetArr.length - 1].substring(sheetArr[sheetArr.length - 1].length() -1);
            if (aMusic.contains(last)) {
                bw.write("A-minor");
            } else if (cMusic.contains(last)) {
                bw.write("C-major");
            }
        }

        bw.newLine();
        bw.flush();
        bf.close();
        bw.close();
    }
}
