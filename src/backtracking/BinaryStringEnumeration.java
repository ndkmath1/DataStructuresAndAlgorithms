package backtracking;

import java.util.Scanner;

/**
 * 
 * @author khanh
 *
 */
public class BinaryStringEnumeration {

	private int n, bs[];

	private void readData() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		bs = new int[n];
	}

	private void attemp(int i) {
		for (int v = 0; v <= 1; ++v) {
			bs[i - 1] = v;
			if (i == n) {
				print();
			} else {
				attemp(i + 1);
			}
		}
	}

	private void print() {
		for (int i = 0; i < n; ++i) {
			System.out.print(bs[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		BinaryStringEnumeration bse = new BinaryStringEnumeration();
		bse.readData();
		bse.attemp(1);
	}

}
