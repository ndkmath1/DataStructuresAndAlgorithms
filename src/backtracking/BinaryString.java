package backtracking;

import java.util.Scanner;

/**
 * 
 * @author khanh
 *
 */
public class BinaryString {
	
	private int n, bs[];

	private void readData() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		bs = new int[n];
	}

	private void attempt(int i) {
		for (int v = 0; v <= 1; ++v) {
			bs[i - 1] = v;
			if (i == n) {
				print();
			} else {
				attempt(i + 1);
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
		BinaryString b = new BinaryString();
		b.readData();
		b.attempt(1);
	}

}
