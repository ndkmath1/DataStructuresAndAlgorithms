package backtracking;

import java.util.Scanner;

/**
 * Let n is positive number, analysis n such that n is sum of positive number
 * 
 * @author khanh
 *
 */
public class AnalysisNumber {

	static int n, count;
	static int[] t, x;

	static void init() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		x = new int[n + 1];
		t = new int[n + 1];
		x[0] = 1;
		t[0] = 0;
	}

	static void attempt(int i) {
		for (int v = x[i - 1]; v <= (n - t[i - 1]) / 2; ++v) {
			x[i] = v;
			t[i] = t[i - 1] + x[i];
			attempt(i + 1);
		}
		x[i] = n - t[i - 1];
		printResult(i);
	}

	static void printResult(int i) {
		System.out.print(++count + ". ");
		for (int k = 1; k <= i; ++k) {
			System.out.print(x[k] + " ");
		}
		System.out.println();
	}

	static void test() {
		init();
		attempt(1);
	}

	public static void main(String[] args) {
		test();
	}

}
