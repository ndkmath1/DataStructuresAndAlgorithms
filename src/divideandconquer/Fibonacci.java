package divideandconquer;

import java.util.Scanner;

class Fibonacci {

	int n;
	Scanner sc = new Scanner(System.in);
	
	void init() {
		n = sc.nextInt();
	}

	int fib(int n) {
		if (n <= 1) {
			return n;
		}
		return fib(n - 1) + fib(n - 2);
	}
	
	void test() {
		init();
		System.out.print("f(" + n + ") = " + fib(n));
	}

	public static void main(String[] args) {
		new Fibonacci().test();
	}

}
