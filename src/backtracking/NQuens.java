package backtracking;

import java.util.Scanner;

class NQuens {
	
	// array a: mark queen position,
	// b: mark cross northeast - southwest,
	// c: mark cross southeast - northwest
	static boolean[] a, b, c;
	static int nQ;
	static int[] x;
	static int count = 0;
	static Scanner sc = new Scanner(System.in);
	
	static void init() {
		nQ = sc.nextInt();
		a = new boolean[nQ]; // default, a[i] = false
		b = new boolean[2 * nQ - 1];
		c = new boolean[2 * nQ - 1];
		x = new int[nQ];
	}
	
	static void attempt(int i) { // row
		for (int j = 0; j < nQ; ++j) { // col
			if (!a[j] && !b[i + j] && !c[i - j + nQ - 1]) {
				x[i] = j;
				if (i == nQ - 1) {
					printResult();
				} else {
					a[j] = true;
					b[i + j] = true;
					c[i - j + nQ - 1] = true;
					attempt(i + 1);
					a[j] = false;
					b[i + j] = false;
					c[i - j + nQ - 1] = false;
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
