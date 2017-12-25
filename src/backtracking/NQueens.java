package backtracking;

import java.util.Scanner;

public class NQueens {
	
	static int nQ;
	static int[] x;
	static int count;
	
	static void init() {
		Scanner sc = new Scanner(System.in);
		nQ = sc.nextInt();
		x = new int[nQ];
	}
	
	static void attempt(int i) {
		for (int j = 0; j < nQ; ++j) {
			boolean b = true;
			for (int k = 0; k < i; ++k) {
				if (x[k] == j || x[k] + k == j + i || x[k] - k == j - i) {
					b = false;
					break;
				}
			}
			if (b) {
				x[i] = j;
				if (i == nQ - 1) {
					printResult();
				} else {
					attempt(i + 1);
				}
			}
		}
	}
	
	static void printResult() {
		System.out.print(++count + ". ");
		for (int i = 0; i < nQ; ++i) {
			System.out.print(x[i] + 1 + " ");
		}
		System.out.println();
	}
	
	static void test() {
		init();
		attempt(0);
	}
	
	public static void main(String[] args) {
		test();
	}

}
