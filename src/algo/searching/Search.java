package algo.searching;

import algo.sorting.Sort;

public class Search {

    public int binarySearch(int[] a, int key, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (a[mid] == key) {
            return mid;
        } else if (a[mid] > key) {
            return binarySearch(a, key, left, mid - 1);
        } else {
            return binarySearch(a, key, mid + 1, right);
        }
    }

    public int binarySearchNonRecursive(int[] a, int key, int left, int right) {
        while (true) {
            System.out.println("left = " + left + " | right = " + right);
            if (left > right) {
                return -1;
            }
            int mid = (left + right) / 2;
            if (a[mid] == key) {
                return mid;
            } else if (a[mid] > key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        int a[] = new int[]{1, 3, 7, 2, 4, 2, 3, 8, 4, 9, 5};
//        iSort.printArray(a);
//        iSort.swap(a, 0, 1);
//        iSort.printArray(a);
//        System.out.println();
        sort.printArray(a);
//        sort.insertionSort(a);
        sort.selectionSort(a);
        sort.printArray(a);

        Search search = new Search();
        int index = search.binarySearchNonRecursive(a, -100, 0, a.length - 1);
        System.out.println("index = " + index);
    }

}
