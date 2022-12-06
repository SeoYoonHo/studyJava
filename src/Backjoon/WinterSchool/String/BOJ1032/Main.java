package Backjoon.WinterSchool.String.BOJ1032;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());
        List<char[]> chars = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String temp = bf.readLine();
            chars.add(temp.toCharArray());
        }

        int size = chars.get(0).length;
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < size; i++) {
            boolean flag = false;
            char ch = chars.get(0)[i];

            for (int j = 1; j < chars.size(); j++) {
                if (ch != chars.get(j)[i]) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                res.append("?");
            } else {
                res.append(ch);
            }
        }

        bw.write(res + "\n");

        bw.flush();
        bf.close();
        bw.close();
    }
}
