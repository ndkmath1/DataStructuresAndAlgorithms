package hustoj;

import java.util.Scanner;

/**
 * 
 * @author khanh 
 * Enumeration A^{k}_{n}
 * Problem 1009: http://bkict.org/hustoj/problem/show/1009
 */
public class PermutationEnumeration {

	int n, k;
	int[] x;
	boolean[] mark; // default, element in mark array is false
	Scanner sc = new Scanner(System.in);
	int count;
	boolean check = false;

	void readData() {
		n = sc.nextInt();
		k = sc.nextInt();
		x = new int[n];
		mark = new boolean[n];
	}

	void attempt(int i) {
		if (check) {
			return;
		}
		for (int v = 0; v < n; ++v) {
			if (!mark[v]) {
				x[i] = v;
				if (i == n - 1) {
					++count;
					if (count == k) {
						check = true;
						print();
						return;
					}
				} else {
					mark[v] = true;
					attempt(i + 1);
					mark[v] = false;
				}
			}
		}
	}

	void print() {
//		System.out.print(++count + ". ");
		for (int i = 0; i < n; ++i) {
			System.out.print((x[i] + 1) + " ");
		}
//		System.out.println();
	}
	
	void check() {
		if (!check) {
			System.out.print("-1");
		}
	}

	public static void main(String[] args) {
		PermutationEnumeration a = new PermutationEnumeration();
		a.readData();
		a.attempt(0);
		a.check();
	}

}