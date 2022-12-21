package Backjoon.WinterSchool.HashTree.BOJ21939;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            TreeMap<Integer, TreeSet<Integer>> questionMap = new TreeMap<>();

            for (int i = 0; i < N; i++) {
                int questionNum = sc.nextInt();
                int level = sc.nextInt();

                if (questionMap.containsKey(level)) {
                    questionMap.get(level).add(questionNum);
                } else {
                    TreeSet<Integer> tempSet = new TreeSet<>();
                    tempSet.add(questionNum);
                    questionMap.put(level, tempSet);
                }
            }

            int M = sc.nextInt();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < M + 1; i++) {
                String commandStr = sc.nextLine();
                sb.append(commandExecute(commandStr, questionMap));
            }

//            System.out.println();
            System.out.print(sb);
        }
    }

    public static String commandExecute(String commandStr, TreeMap<Integer, TreeSet<Integer>> questionMap) {
//        System.out.println(commandStr);
        String res = "";
        String[] splitCommand = commandStr.split(" ");

        switch (splitCommand[0]) {
            case "add":
                Integer questionNum = Integer.parseInt(splitCommand[1]);
                Integer level = Integer.parseInt(splitCommand[2]);

                if (questionMap.containsKey(level)) {
                    questionMap.get(level).add(questionNum);
                } else {
                    TreeSet<Integer> tempSet = new TreeSet<>();
                    tempSet.add(questionNum);
                    questionMap.put(level, tempSet);
                }
                break;
            case "recommend":
                int recommendType = Integer.parseInt(splitCommand[1]);

                if (recommendType == 1) {
                    res = questionMap.get(questionMap.lastKey()).last() + "\n";
                } else {
                    res = questionMap.get(questionMap.firstKey()).first() + "\n";
                }
                break;
            case "solved":
                Integer solveQuestionNum = Integer.parseInt(splitCommand[1]);
                List<Integer> removeList = new ArrayList<>();

                for (Integer lev : questionMap.keySet()) {
                    if (questionMap.get(lev).contains(solveQuestionNum)) {
                        questionMap.get(lev).remove(solveQuestionNum);

                        if (questionMap.get(lev).isEmpty()) {
                            removeList.add(lev);
                        }
                    }
                }

                for (Integer removeLev : removeList) {
                    questionMap.remove(removeLev);
                }

                break;
        }

        return res;
    }
}
