package backtracking;

import java.util.Scanner;

public class ArrangementRepeat {

	int n, k, x[];
	Scanner sc = new Scanner(System.in);
	int count = 0; // not need assign, by default count is 0

	void init() {
		n = sc.nextInt();
		k = sc.nextInt();
		x = new int[k];
	}

	void attempt(int i) {
		for (int v = 0; v < n; ++v) {
			x[i] = v;
			if (i == k - 1) {
				print();
			} else {
				attempt(i + 1);
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
		ArrangementRepeat ar = new ArrangementRepeat();
		ar.init();
		ar.attempt(0);
	}

}
