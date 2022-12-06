package Backjoon.WinterSchool.Array.BOJ10807;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bf.readLine();
        String integerString = bf.readLine();
        int V = Integer.parseInt(bf.readLine());

        StringTokenizer tokenizer = new StringTokenizer(integerString, " ");

        int res = 0;
        while (tokenizer.hasMoreElements()) {
            if (V == Integer.parseInt(tokenizer.nextToken())) {
                res++;
            }
        }

        bw.write(res + "\n");

        bw.flush();
        bf.close();
        bw.close();
    }
}
