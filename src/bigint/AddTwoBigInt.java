package bigint;

import java.util.Scanner;

public class AddTwoBigInt {
	
	static String add(String a, String b) {
		int carry = 0;
		String result = "";
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
		for (int i = la - 1; i >= 0; --i) {
			int x = a.charAt(i) - '0';
			int y = b.charAt(i) - '0';
			int sum = x + y + carry;
			carry = sum / 10;
			result = (char) (sum % 10 + '0') + result;
		}
//		System.out.println("carry = " + carry);
		if (carry > 0) { // carry = 1
			result = '1' + result;
		}
		return result;
	}
	
	static void test() {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		System.out.println("a + b = " + add(a, b));
	}
	
	public static void main(String[] args) {
		test();
	}
	
}
