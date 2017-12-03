package backtracking;

import java.util.Scanner;

/**
 * 
 * @author khanh 
 * Enumeration A^{k}_{n}
 */
class Arrangement {

	int n, k;
	int[] x;
	boolean[] mark; // default, element in mark array is false
	Scanner sc = new Scanner(System.in);
	int count;

	void readData() {
		n = sc.nextInt();
		k = sc.nextInt();
		x = new int[k];
		mark = new boolean[n];
	}

	void attempt(int i) {
		for (int v = 0; v < n; ++v) {
			if (!mark[v]) {
				x[i] = v;
				if (i == k - 1) {
					print();
				} else {
					mark[v] = true;
					attempt(i + 1);
					mark[v] = false;
				}
			}
		}
	}

	void print() {
		System.out.print(++count + ". ");
		for (int i = 0; i < k; ++i) {
			System.out.print(x[i] + 1);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Arrangement a = new Arrangement();
		a.readData();
		a.attempt(0);
	}

}
