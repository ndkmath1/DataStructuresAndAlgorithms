package backtracking;

import java.util.Scanner;

/**
 * A ATM machine have n coins of money in denominations: t1, t2, ..., tn
 * Find a payment method such that sum of money equal S
 * Sample Input:
10 390 
200 10 20 20 50 50 50 50 100 100
 * @author khanh
 *
 */
public class ATMWithdrawal {
	
	static int n;
	static int[] t;
	static int[] x;
	static int s;
	static int sum, count;
	static int c, cBest;
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
		cBest = n + 1;
		xBest = new int[n];
	}
	
	static void attempt(int i) {
		for (int v = 0; v <= 1; ++v) {
			x[i] = v;
			sum += x[i] * t[i];
			c += x[i];
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
			c -= x[i];
		}
	}
	
	static void printResult() {
		System.out.println(cBest);
		for (int i = 0; i < n; ++i) {
			if (x[i] != 0) {
				System.out.print(t[i] + " ");
			}
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
	
	public static void main(String[] args) {
		test();
	}
	
}
