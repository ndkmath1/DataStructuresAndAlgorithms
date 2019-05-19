package algo.sorting;

public class Sort {

    public int[] insertionSort(int[] a) {
        int len = a.length;
        for (int i = 1; i < len; ++i) {
            int last = a[i];
            int j = i;
            while (j > 1 && a[j-1] > a[j]) {
                swap(a, j-1, j);
                --j;
            }
            a[j] = last;
        }
        return a;
    }

    public int[] selectionSort(int[] a) {
        int len = a.length;
        for (int i = 0; i < len - 1; ++i) {
            int min = i;
            for (int j = i+1; j < len; ++j) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(a, min, i);
            }
        }
        return a;
    }

    public int[] bubbleSort(int[] a) {
        int n = a.length;
        for (int i = n - 1; i >= 1; --i) {
            for (int j = 1; j <= i; ++j) {
                if (a[j] < a[j - 1]) {
                    swap(a, j, j - 1);
                }
            }
        }
        return a;
    }

    public void swap(int[] a, int i, int j) {
        a[i] = a[j] - a[i] + (a[j] = a[i]);
    }

    public void printArray(int[] a) {
        for (int i = 0; i < a.length; ++i) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
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
        sort.bubbleSort(a);
        sort.printArray(a);

    }

}
