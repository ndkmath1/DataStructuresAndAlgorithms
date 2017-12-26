package hustoj;


import java.util.Scanner;

/**
 * 
 * @author khanh
 * Problem 1008: http://bkict.org/hustoj/problem/show/1008
 *
 */
public class CombinationEnumeration {

	private int n, k, x[];
	private int pos;
	private int count;
	private boolean check;

	private void readData() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		pos = sc.nextInt();
		x = new int[k + 1];
	}

	private void attempt(int i) {
		if (check) {
			return;
		}
		for (int v = x[i - 1] + 1; v <= n - k + i; ++v) {
			x[i] = v;
			if (i == k) {
				++count;
				if (count == pos) {
					check = true;
					print();
					return;
				}
			} else {
				attempt(i + 1);
			}
		}
	}

	private void print() {
		for (int i = 1; i <= k; ++i) {
			System.out.print(x[i] + " ");
		}
//		System.out.println();
	}
	
	private void check() {
		if (!check) {
			System.out.print("-1");
		}
	}

	public static void main(String[] args) {
		CombinationEnumeration c = new CombinationEnumeration();
		c.readData();
		// x[0] = 0; not need, by default all element in array is 0
		c.attempt(1);
		c.check();
	}

}
