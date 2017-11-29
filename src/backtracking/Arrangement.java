package backtracking;

import java.util.Scanner;

/**
 * 
 * @author khanh 
 * Enumeration A^{k}_{n}
 */
public class Arrangement {

	private int n, k, x[], mark[];
	private Scanner sc = new Scanner(System.in);

	private void readData() {
		n = sc.nextInt();
		k = sc.nextInt();
		x = new int[k];
		mark = new int[n];
	}

	private void attempt(int i) {
		for (int v = 0; v < n; ++v) {
			if (mark[v] == 0) {
				x[i] = v;
				mark[v] = 1; // mark already assign
			} else {
				continue;
			}
			if (i == k - 1) {
				print();
			} else {
				attempt(i + 1);
				
			}
		}
	}
	
	private void reset() {
		for (int i = 0; i < n; ++i) {
			mark[i] = 0;
		}
	}

	private void print() {
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
