package basic;

public class LargestSubsequence {
	
	static int[] a = {-2, 11, -4, 13, -5, 2};
	static int n = a.length;
	
	static void init() {
		
	}
	
	static void handle() {
		System.out.println("Algo 1: maxSum = " + algo1(a, 0, n - 1));
		System.out.println("Algo 2: maxSum = " + algo2(a, 0, n - 1));
		System.out.println("Algo 3: maxSum = " + algo3(a, 0, n - 1));
		System.out.println("Algo 4: maxSum = " + algo4(a, 0, n - 1));
	}
	
	/**
	 * Naive algorithm
	 * @param a
	 * @param minIndex
	 * @param maxIndex
	 * @return
	 */
	static int algo1(int[] a, int minIndex, int maxIndex) {
		int maxSum = a[minIndex];
		for (int i = minIndex; i <= maxIndex; ++i) {
			for (int j = i; j <= maxIndex; ++j) {
				int sum = 0;
				for (int k = i; k <= j; ++k) {
					sum += a[k];
				}
				if (sum > maxSum) {
					maxSum = sum;
				}
			}
		}
		return maxSum;
	}
	
	/**
	 * Improve naive algorithm
	 * @param a
	 * @param minIndex
	 * @param maxIndex
	 * @return
	 */
	static int algo2(int[] a, int minIndex, int maxIndex) {
		int maxSum = a[0];
		for (int i = minIndex; i <= maxIndex; ++i) {
			int sum = 0;
			for (int j = i; j <= maxIndex; ++j) {
				sum += a[j];
				if (maxSum < sum) {
					maxSum = sum;
				}
			}
		}
		return maxSum;
	}
	
	/**
	 * Recursion algorithm
	 * @param a
	 * @param first
	 * @param last
	 * @return
	 */
	static int algo3(int[] a, int first, int last) {
		if (first == last) {
			return a[first];
		} else {
			int m = (first + last) / 2;
			int maxLeft = algo3(a, first, m);
			int maxRight = algo3(a, m + 1, last);
			int maxMiddle = maxLeft(a, first, m) + maxRight(a, m + 1, last);
			return Math.max(maxLeft, Math.max(maxMiddle, maxRight));
		}
	}
	
	static int maxLeft(int[] a, int minIndex, int endIndex) {
		int maxLeft = a[endIndex];
		for (int i = endIndex - 1; i >= minIndex; --i) {
			int u = maxLeft + a[i];
			if (u > maxLeft) {
				maxLeft = u;
			}
		}
		return maxLeft;
	}
	
	static int maxRight(int[] a, int beginIndex, int maxIndex) {
		int maxRight = a[beginIndex];
		for (int i = beginIndex + 1; i <= maxIndex; ++i) {
			int u = maxRight + a[i];
			if (u > maxRight) {
				maxRight = u;
			}
		}
		return maxRight;
	}
	
	/**
	 * Dynamic Programming algorithm
	 * @param a
	 * @param first
	 * @param last
	 * @return
	 */
	static int algo4(int[] a, int first, int last) {
		int sMax = a[first];
		int maxEndHere = a[first];
		int iMax = first;
		for (int i = first + 1; i <= last; ++i) {
			int u = a[i];
			int v = maxEndHere + a[i];
			if (u > v) {
				maxEndHere = u;
			} else {
				maxEndHere = v;
			}
			if (maxEndHere > sMax) {
				sMax = maxEndHere;
				iMax = i;
			}
		}
		return sMax;
	}
	
	public static void main(String[] args) {
		handle();
	}

}
