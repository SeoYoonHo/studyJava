package Backjoon.DP.BOJ12852;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int N = sc.nextInt();
			
			if(N ==1 ) {
				System.out.println(0);
				System.out.print(1);
				return;
			}

			int[] minArr = new int[N + 1];
			ArrayList<Integer> hist = new ArrayList<Integer>();
			hist.add(0);

			for (int i = 2; i < N + 1; i++) {
				int min = minArr[i - 1] + 1;
				hist.add(i - 1);

				if (i % 2 == 0) {
					int temp = minArr[i / 2] + 1;
					if (temp < min) {
						min = temp;
						hist.remove(hist.size() - 1);
						hist.add(i / 2);
					}
				}

				if (i % 3 == 0) {
					int temp = minArr[i / 3] + 1;
					if (temp < min) {
						min = temp;
						hist.remove(hist.size() - 1);
						hist.add(i / 3);
					}
				}

				minArr[i] = min;
			}

//			for (int i : minArr) {
//				System.out.print(i + " ");
//			}
//			System.out.println();

			System.out.println(minArr[N]);

			int index = hist.get(N - 1);
			System.out.print(N + " " + index + " ");

//			boolean flag = true;
			while (index != 1) {
				System.out.print(hist.get(index - 1) + " ");
				index = hist.get(index - 1);
				if(index == 1) 
					break;
			}
//			System.out.println(hist);
		}
	}

}
