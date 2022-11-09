package Backjoon.Greedy.BOJ1026;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			int N = sc.nextInt();
			ArrayList<Integer> A = new ArrayList<Integer>();
			ArrayList<Integer> B = new ArrayList<Integer>();

			for (int i = 0; i < 2 * N; i++) {
				int temp = sc.nextInt();
				if (i >= N)
					B.add(temp);
				else
					A.add(temp);
			}

			A.sort(null);
			B.sort((o1, o2) -> o2.compareTo(o1));

			int res = 0;
			for (int i = 0; i < A.size(); i++) {
				res += B.get(i) * A.get(i);
			}

			System.out.println(res);
		}
	}
}
