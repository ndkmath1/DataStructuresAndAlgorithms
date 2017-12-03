package sorting;

import java.util.Random;

class BubbleSort {
	
	void sort(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; ++i) {
			for (int j = n - 1; j > i; --j) {
				if (a[j] < a[j-1]) {
					swap(a, j, j - 1);
				}
			}
		}
	}
	
	void sort2(int[] a) {
		int n = a.length;
		for (int i = 0; i < n - 1; ++i) {
			for (int j = i + 1; j < n; ++j) {
				if (a[i] > a[j]) {
					swap(a, i, j);
				}
			}
		}
	}
	
	void swap(int[] a, int i, int j) {
		a[i] = a[i] + a[j];
		a[j] = a[i] - a[j];
		a[i] = a[i] - a[j];
	}
	
	void test() {
		int n = 20;
		int[] a = new int[n];
		Random rd = new Random();
		for (int i = 0; i < n; ++i) {
			a[i] = rd.nextInt(n);
		}
		System.out.println("Before sort:");
		printArray(a);
		System.out.println("\nAfter sort:");
		sort(a);
		printArray(a);
	}
	
	void printArray(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; ++i) {
			System.out.print(a[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		new BubbleSort().test();
	}

}
