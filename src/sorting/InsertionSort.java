package sorting;

import java.util.Random;

public class InsertionSort {
	
	void insertionSort(int[] a) {
		int n = a.length;
		for (int i = 1; i < n; ++i) {
			insert(a, i);
		}
	}
	
	void insert(int[] a, int i) {
		int v = a[i];
		int j = i - 1;
		for (; j >= 0 && v < a[j]; --j) {
			swap(a, j, j + 1);
		}
		a[j+1] = v;
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
		insertionSort(a);
		printArray(a);
	}
	
	void printArray(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; ++i) {
			System.out.print(a[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		new InsertionSort().test();
	}
	
}
