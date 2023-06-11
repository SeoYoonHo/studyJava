package ct;

public class Recursive {
    public static void main(String[] args) {
        Recursive recursive = new Recursive();

        int[][] ability = {{40, 10, 10}, {20, 5, 0}, {30, 30, 30}, {70, 0, 70}, {100, 100, 100}};

        recursive.solutino(ability);
    }

    public int solutino(int[][] ability) {
        printArr(ability);

        for (int i = 0; i < ability.length; i++) {
            rec(i, 0);
        }

        return 0;
    }

    public void rec(int i, int subject) {


        //선택 O
        rec(i+1,subject + 1);

        //선택 X
        rec(i+1,subject);
    }

    public void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
