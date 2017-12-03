package dynamicprogramming;

import java.util.Scanner;

class Fibonacci {
	
	int n;
	int[] s;
	Scanner sc = new Scanner(System.in);
	
	void init() {
		n = sc.nextInt();
		s = new int[n+1];
		for (int i = 0; i <= n; ++i) {
			s[i] = -1;
		}
	}
	
	int fib(int n) {
		if (s[n] == -1) {
			if (n <= 1) {
				s[n] = n;
			} else {
				s[n] = fib(n-1) + fib(n-2);
			}
		}
		return s[n];
	}
	
	void test() {
		init();
		System.out.print("f(" + n + ") = " + fib(n));
	}
	
	public static void main(String[] args) {
		new Fibonacci().test();
	}
	
}
