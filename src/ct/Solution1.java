package ct;

public class Solution1 {

    public static void main(String[] args) {

        Solution1 sol = new Solution1();
        int res = sol.Solution(0);
        System.out.println(res);

    }

    public int Solution(int N) {
        String strN = String.valueOf(N);
        String res = "";
        int findIndex = -1;

        if (N > 0) {
            for (int i = 0; i < strN.length(); i++) {
                if (5 >= strN.charAt(i) - '0') {
                    findIndex = i;
//                    System.out.println(strN.charAt(i) + ", " + i);
                    break;
                }
            }


            if (findIndex == -1) {
                res = strN + "5";
            } else {
                res = strN.substring(0, findIndex) + "5" + strN.substring(findIndex, strN.length());
            }

            System.out.println(res);

        } else if (N < 0) {
            for (int i = 0; i < strN.length(); i++) {
                if (5 <= strN.charAt(i) - '0') {
                    findIndex = i;
                    System.out.println(strN.charAt(i) + ", " + i);
                    break;
                }
            }


            if (findIndex == -1) {
                res = strN + "5";
            } else {
                res = strN.substring(0, findIndex) + "5" + strN.substring(findIndex, strN.length());
            }
        } else {
            res = "50";
        }

        return Integer.valueOf(res);
    }

}
