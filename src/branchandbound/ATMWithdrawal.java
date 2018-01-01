package branchandbound;

import java.util.Scanner;

public class ATMWithdrawal {
	
	static int n;
	static int s;
	static int[] t, tMax;
	static int[] x; // store result
	static int sum, c, cBest;
	static int[] xBest;
	
	static void init() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		s = sc.nextInt();
		t = new int[n];
		for (int i = 0; i < n; ++i) {
			t[i] = sc.nextInt();
		}
		x = new int[n];
		tMax = new int[n];
		tMax[n - 1] = t[n - 1];
		for (int i = n - 2; i >= 0; --i) {
			tMax[i] = tMax[i + 1];
			if (tMax[i] < t[i]) {
				tMax[i] = t[i];
			}
		}
		cBest = n + 1;
		xBest = new int[n];
	}
	
	static void attempt(int i) {
		if (c + (s - sum) / tMax[i] >= cBest) {
			return;
		}
		for (int v = 0; v <= 1; ++v) {
			x[i] = v;
			sum += x[i] * t[i];
			c = c + x[i];
			if (i == n - 1) {
				if (sum == s && c < cBest) {
					cBest = c;
					for (int k = 0; k < n; ++k) {
						xBest[k] = x[k];
					}
				}
			} else if (sum <= s) {
				attempt(i + 1);
			}
			sum -= x[i] * t[i];
			c = c - x[i];
		}
	}
	
	static void test() {
		init();
		attempt(0);
		if (cBest < n + 1) {
			printResult();
		} else {
			System.out.print(-1);
		}
	}
	
	static void printResult() {
		System.out.println(cBest);
		for (int i = 0; i < n; ++i) {
			if (xBest[i] != 0) {
				System.out.print(t[i] + " ");
			}
		}
	}
	
	public static void main(String[] args) {
		test();
	}
	
}
