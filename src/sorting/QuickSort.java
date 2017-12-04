package sorting;

import java.util.Random;

public class QuickSort {
	
	void quickSort(int[] a, int low, int hight) {
		if (low < hight) {
			int p = partition2(a, low, hight);
//			System.out.println("pivot = " + a[p]);
//			System.out.println("a low p - 1");
//			printArray(a, low, p - 1);
//			System.out.println("a p + 1 hight");
			printArray(a, p + 1, hight);
			quickSort(a, low, p - 1);
			quickSort(a, p + 1, hight);
		}
	}
	
	// pivot = mid element
	int partition(int[] a, int low, int hight) {
		int pivot = a[(low + hight) / 2];
		int i = low, j = hight;
		
		return 0;
	}
	
	// pivot =  last element
	int partition2(int[] a, int low, int hight) {
		int pivot = a[hight];
		int i = low - 1;
		for (int j = low; j < hight; ++j) {
			if (a[j] <= pivot) {
				++i;
				swap(a, i, j);
			}
		}
		swap(a, i + 1, hight);
		return  i + 1;
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
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
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
		System.out.println();
	}
	
	void printArray(int[] a, int low, int hight) {
		for (int i = low; i <= hight; ++i) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		new QuickSort().test();
	}
	
}
