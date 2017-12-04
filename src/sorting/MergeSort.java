package sorting;

import java.util.Random;

public class MergeSort {
	
	void mergeSort(int[] a, int low, int hight) {
		if (low < hight) {
			int mid = (low + hight) / 2;
			mergeSort(a, low , mid);
			mergeSort(a, mid + 1, hight);
			merge(a, low , mid, hight);
		}
	}
	
	void merge(int[] a, int low, int mid, int hight) {
		int first1 = low, last1 = mid;
		int first2 = mid + 1, last2 = hight;
		int numElement = hight - low + 1;
		int[] temp = new int[numElement];
		int i = 0;
		for (; first1 <= last1 && first2 <= last2; ++i) {
			if (a[first1] <= a[first2]) {
				temp[i] = a[first1];
				++first1;
			} else {
				temp[i] = a[first2];
				++first2;
			}
		}
		for (; first1 <= last1; ++i, ++first1) {
			temp[i] = a[first1];
		}
		for (; first2 <= last2; ++i, ++first2) {
			temp[i] = a[first2];
		}
		// copy temp to a
		for (int j = 0; j < numElement; ++j) {
			a[low + j] = temp[j];
		}
	}
	
	void swap(int[] a, int i, int j) {
		if (i != j) {
			a[i] ^= a[j];
			a[j] ^= a[i];
			a[i] ^= a[j];
		}
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
		mergeSort(a, 0, a.length - 1);
		printArray(a);
	}
	
	void printArray(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; ++i) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	void printArray(int[] a, int low, int hight) {
		for (int i = low; i <= hight; ++i) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		new MergeSort().test();
	}

}
