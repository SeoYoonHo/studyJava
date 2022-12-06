package Backjoon.WinterSchool.String.BOJ3172;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());
        List<Word> wordList = new ArrayList<>();
        List<Word> reverseWordList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String temp = bf.readLine();
            StringBuilder sb = new StringBuilder(temp);
            sb.reverse();

            Word word = new Word();
            word.str = temp;
            word.reverseStr = sb.toString();

            wordList.add(word);
            reverseWordList.add(word);
        }

        wordList.sort(Comparator.comparing(word -> word.str));
        reverseWordList.sort(Comparator.comparing(word -> word.reverseStr));

        for (int i = 0; i < reverseWordList.size(); i++) {
            wordList.get(i).order = i;
        }

        for (int i = 0; i < reverseWordList.size(); i++) {
            reverseWordList.get(i).reverseOrder = i;
        }

        main.makeWordTree(reverseWordList, 1, reverseWordList.size());

        Word rootWord = reverseWordList.get((1 + N) / 2 - 1);

        long sum = 0;

        for (Word word : wordList) {
            int temp = main.notLoveCnt(rootWord, word);
            sum += temp;
        }

        bw.write(sum + "\n");

        bw.flush();
        bf.close();
        bw.close();
    }

    public int notLoveCnt(Word rootWord, Word findWord) {
        if (rootWord == findWord) {
            rootWord.isChecked = true;
            return findWord.reverseOrder - (findWord.cnt + findWord.leftUpCnt);
        } else {
            if (rootWord.reverseOrder < findWord.reverseOrder) {
                if (rootWord.isChecked) {
                    rootWord.rightWord.leftUpCnt = rootWord.leftUpCnt + rootWord.cnt + 1;
                } else {
                    rootWord.rightWord.leftUpCnt = rootWord.leftUpCnt + rootWord.cnt;
                }
                return notLoveCnt(rootWord.rightWord, findWord);
            } else {
                rootWord.cnt++;
                rootWord.leftWord.leftUpCnt = rootWord.leftUpCnt;
                return notLoveCnt(rootWord.leftWord, findWord);
            }
        }
    }

    public void makeWordTree(List<Word> wordList, int begin, int end) {
        if (begin == end) {
            return;
        }
        int middle = (end + begin) / 2;
        Word middleWord = wordList.get(middle - 1);

        int leftEnd = middle - 1;
        int rightBegin = middle + 1;

        if (leftEnd >= begin) {
            int left = (begin + leftEnd) / 2;
            middleWord.leftWord = wordList.get(left - 1);
            makeWordTree(wordList, begin, leftEnd);
        }

        int right = (rightBegin + end) / 2;
        middleWord.rightWord = wordList.get(right - 1);
        makeWordTree(wordList, rightBegin, end);
    }

    public static class Word {
        String str;
        String reverseStr;
        int order;
        int reverseOrder;
        Word leftWord;
        Word rightWord;
        int cnt;
        int leftUpCnt;
        boolean isChecked;

        @Override
        public String toString() {
            return "Word{" +
                    "str='" + str + '\'' +
                    ", reverseStr='" + reverseStr + '\'' +
                    ", order=" + order +
                    ", reverseOrder=" + reverseOrder +
                    ", left=" + (leftWord == null ? "" : leftWord.str) +
                    ", right=" + (rightWord == null ? "" : rightWord.str) +
                    ", cnt=" + cnt +
                    ", leftUpCnt=" + leftUpCnt +
                    ", isChecked=" + isChecked +
                    '}';
        }
    }
}
