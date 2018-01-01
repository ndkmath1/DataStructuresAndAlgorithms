package searching;

public class BinarySearch {
	
	// recusive
	int binarySearch(int[] a, int left, int right, int key) {
		if (left <= right) {
			int mid = (left + right) / 2;
			if (a[mid] > key) {
				return binarySearch(a, left, mid - 1, key);
			} else if (a[mid] < key) {
				return binarySearch(a, mid + 1, right, key);
			} else {
				return mid;
			}
		}
		return -1;
	}
	
	// non recusive
	int binarySearchNonRec(int[] a, int key) {
		int n = a.length;
		int lower = 0, upper = n - 1;
		while (lower <= upper) {
			int mid = (lower + upper) / 2;
			if (a[mid] < key) {
				lower = mid + 1;
			} else if (a[mid] > key) {
				upper = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	
	void test() {
		
	}
	
	public static void main(String[] args) {
		new BinarySearch().test();
	}
	
}
