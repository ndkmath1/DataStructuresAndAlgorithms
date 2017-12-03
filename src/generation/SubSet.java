package generation;

import java.util.Scanner;

class SubSet {

	int n, k;
	int[] x;
	Scanner sc = new Scanner(System.in);
	int count;

	void init() {
		n = sc.nextInt();
		k = sc.nextInt();
		x = new int[k];
	}

	void generate() {
		for (int i = 1; i <= k; ++i) {
			x[i - 1] = i;
		}
		print();
		while (true) {
			boolean isDone = true;
			for (int i = k - 1; i >= 0; --i) {
				if (x[i] <= n - k + i) {
					isDone = false;
					++x[i];
					for (int j = i + 1; j < k; ++j) {
						x[j] = x[j - 1] + 1;
					}
					print();
					break;
				}
			}
			if (isDone) {
				break;
			}
		}
	}

	void print() {
		System.out.print(++count + ". ");
		for (int i = 0; i < k; ++i) {
			System.out.print(x[i]);
		}
		System.out.print("\n");
	}

	public static void main(String[] args) {
		SubSet ss = new SubSet();
		ss.init();
		ss.generate();
	}

}
