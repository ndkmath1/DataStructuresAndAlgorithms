package sorting;

import java.util.Random;

public class QuickSort {
	
	void quickSort(int[] a, int low, int hight) {
		if (low < hight) {
			int p = partition(a, low, hight);
			quickSort(a, low, p - 1);
			quickSort(a, p + 1, hight);
		}
	}
	
	// pivot = mid element
	int partition(int[] a, int low, int hight) {
		int pivot = a[(low + hight) / 2];
		int i = low, j = hight;
		while (true) {
			while (a[i] <= pivot) {
				i++;
			}
			while (a[j] >= pivot) {
				--j;
			}
			if (i < j) {
				swap(a, i, j);
			} else {
				break;
			}
		}
		return i;
	}
	
	// pivot =  last element
	int partition2(int[] a, int low, int hight) {
		int pivot = a[hight];
		int i = 0, j = 0;
		while (true) {
			for(;a[i] <= pivot && i < hight - 1; ++i);
			for(;a[j] >= pivot && j < hight - 1; ++j);
			if (i != j) {
				swap(a, i, j);
			}
		}
		
	}
	
	// pivot = first element
	int partition3(int[] a, int low, int hight) {
		return 0;
	}
	
	// pivot = random element
	int partition4(int[] a, int low, int hight) {
		return 0;
	}
	
	// do not using this method when i = j
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
		quickSort(a, 0, a.length - 1);
		printArray(a);
	}
	
	void printArray(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; ++i) {
			System.out.print(a[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		new QuickSort().test();
	}
	
}
