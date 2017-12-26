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
	static boolean check;
	
	static void init() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		s = sc.nextInt();
		t = new int[n];
		for (int i = 0; i < n; ++i) {
			t[i] = sc.nextInt();
		}
		x = new int[n];
	}
	
	static void attempt(int i) {
		if (check) {
			return;
		}
//		System.out.println("atempt : " + i);
		for (int v = 0; v <= 1; ++v) {
			x[i] = v;
			sum += x[i] * t[i];
			if (i == n - 1) {
				if (sum == s) {
					printResult();
					check = true;
					return;
				}
			} else if (sum <= s) { // i < n - 1
//				System.out.println("xi = " + x[i]);
//				System.out.println("i = " + i + ", " + "sum = " + sum);
				attempt(i + 1);
			}
			sum -= x[i] * t[i];
		}
	}
	
	static void printResult() {
//		System.out.println(++count + ". ");
		for (int i = 0; i < n; ++i) {
			if (x[i] != 0) {
				System.out.print(t[i] + " ");
			}
		}
//		System.out.println();
	}
	
	static void test() {
		init();
		attempt(0);
	}
	
	static void check() {
		if (!check) {
			System.out.print(-1);
		}
	}
	
	public static void main(String[] args) {
		test();
	}
	
}
