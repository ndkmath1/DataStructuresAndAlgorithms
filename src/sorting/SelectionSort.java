package sorting;

import java.util.Random;

public class SelectionSort {

	void selectionSort(int[] a) {
		int n = a.length;
		for (int i = 0; i < n - 1; ++i) {
			int min = i;
			for (int j = i + 1; j < n; ++j) {
				if (a[j] < a[min]) {
					min = j;
				}
			}
			if (min != i) {
				swap(a, i, min);
			}
		}
	}

	void swap(int[] a, int i, int j) {
		a[i] ^= a[j];
		a[j] ^= a[i];
		a[i] ^= a[j];
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
		selectionSort(a);
		printArray(a);
	}

	void printArray(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; ++i) {
			System.out.print(a[i] + " ");
		}
	}

	public static void main(String[] args) {
		new SelectionSort().test();
	}

}
