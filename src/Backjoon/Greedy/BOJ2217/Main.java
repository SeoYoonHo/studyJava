package Backjoon.Greedy.BOJ2217;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			int N = sc.nextInt();
			ArrayList<Integer> weight = new ArrayList<Integer>();

			for (int i = 0; i < N; i++) {
				int temp = sc.nextInt();
				weight.add(temp);
			}

			weight.sort((o1, o2) -> o2.compareTo(o1));
			int maximumWeiht = weight.get(0);

			for (int i = 1; i < weight.size(); i++) {
				int temp = weight.get(i) * (i + 1);
				if (temp > maximumWeiht) {
					maximumWeiht = temp;
				}
			}

			System.out.println(maximumWeiht);
		}
	}
}
