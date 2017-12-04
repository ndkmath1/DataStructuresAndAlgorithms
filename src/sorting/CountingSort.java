package sorting;

import java.util.Random;

public class CountingSort {
	
	int[] countingSort(int[] a) {
		int n = a.length;
		int[] result = new int[n];
		int k = findMax(a);
		int[] b = new int[k + 1]; // by default, all element in array is 0
		for (int i = 0; i < n; ++i) {
			b[a[i]]++;
		}
		for (int i = 1; i <= k; ++i) {
			b[i] += b[i - 1];
		}
		for (int i = 0; i < n; ++i) {
			result[b[a[i]] - 1] = a[i];
			--b[a[i]];
		}
		return result;
	}
	
	int findMax(int[] a) {
		int n = a.length;
		int max = a[0];
		for (int i = 1; i < n; ++i) {
			if (a[i] > max) {
				max = a[i];
			}
		}
		return max;
	}
	
	void printArray(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; ++i) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
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
		int[] result = countingSort(a);
		printArray(result);
	}
	
	public static void main(String[] args) {
		new CountingSort().test();
	}

}
