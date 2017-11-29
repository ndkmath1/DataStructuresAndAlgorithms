package backtracking;

import java.util.Scanner;

/**
 * 
 * @author khanh
 *
 */
public class CombinationEnumeration {

	private int n, k, x[];

	private void readData() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		x = new int[k + 1];
	}

	private void attemp(int i) {
		for (int v = x[i - 1] + 1; v <= n - k + i; ++v) {
			x[i] = v;
			if (i == k) {
				print();
			} else {
				attemp(i + 1);
			}
		}
	}

	private void print() {
		for (int i = 1; i <= k; ++i) {
			System.out.print(x[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		CombinationEnumeration ce = new CombinationEnumeration();
		ce.readData();
		//x[0] = 0; not need, by default all element in array is 0
		ce.attemp(1);
	}

}
