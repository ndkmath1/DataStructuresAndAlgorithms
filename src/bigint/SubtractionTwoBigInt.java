package bigint;

import java.util.Scanner;

public class SubtractionTwoBigInt {
	
	static String subtract(String a, String b) {
		int compare = CompareTwoBigInt.compare(a, b);
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
		String result;
		if (compare == 0) {
			result = "0";
		} else if (compare > 0) { // a > b
			result = sub(a, b, la);
		} else { // compare < 0
			result = "-" + sub(b, a, la);
		}
		return result;
	}
	
	static String sub(String a, String b, int len) { // a > b and length(a) = length(b)
		String result = "";
		int borrow = 0;
		for (int i = len - 1; i >= 0; --i) {
			int s = a.charAt(i) - b.charAt(i) - borrow;
			if (s < 0) {
				s = s + 10;
				borrow = 1;
			} else {
				borrow = 0;
			}
			result = (char) (s + '0') + result;
		}
		StringBuilder str = new StringBuilder(result);
		while (str.length() > 1 && str.charAt(0) == '0') {
			str.deleteCharAt(0);
		}
		return str.toString();
	}
	
	static void test() {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		System.out.println("a - b = " + subtract(a, b));
	}
	
	public static void main(String[] args) {
		test();
	}
	
}
