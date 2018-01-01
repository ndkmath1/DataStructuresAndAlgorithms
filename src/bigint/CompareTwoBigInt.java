package bigint;

import java.util.Scanner;

public class CompareTwoBigInt {

	static int compare(String a, String b) {
		int la = a.length();
		int lb = b.length();
		while (la < lb) {
			a = '0' + a;
			++la;
		}
		while (lb < la) {
			b = '0' + b;
			++lb;
		}
		for (int i = 0; i < la; ++i) {
			if (a.charAt(i) > b.charAt(i)) {
				return 1;
			} else if (a.charAt(i) < b.charAt(i)) {
				return -1;
			}
		}
		return 0;
	}

	static void test() {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		int r = compare(a, b);
		if (r > 0) {
			System.out.println(a + " > " + b);
		} else if (r < 0) {
			System.out.println(a + " < " + b);
		} else {
			System.out.println(a + " = " + b);
		}
	}

	public static void main(String[] args) {
		test();
	}

}
