package generation;

import java.util.Scanner;

class BinaryString {
	
	int n;
	int[] bs;
	Scanner sc = new Scanner(System.in);
	int count;
	
	void init() {
		n = sc.nextInt();
		bs = new int[n]; // by default, all element in array is O
	}
	
	void generate() {
		print();
		int index = n - 1;
		int count = 0;
		while (true) {
			boolean isDone = true;
			for (int i = n - 1; i >= 0; --i) {
				if (bs[i] == 0) {
					isDone = false;
					bs[i] = 1;
					for (int j = i + 1; j < n; ++j) {
						bs[j] = 0;
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
		for (int i = 0; i < n; ++i) {
			System.out.print(bs[i]);
		}
		System.out.print("\n");
	}
	
	public static void main(String[] args) {
		BinaryString b = new BinaryString();
		b.init();
		b.generate();
	}

}
