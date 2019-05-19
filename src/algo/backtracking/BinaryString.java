package algo.backtracking;

public class BinaryString {

    static int n = 10;
    static int a[] = new int[n];

    public static void backtrack(int i) {
        for (int v = 0; v <= 1; ++v) {
            a[i] = v;
            if (i == n - 1) {
                printArray(a);
            } else {
                backtrack(i + 1);
            }
        }
    }

    static void printArray(int[] a) {
        for (int i = 0; i < a.length; ++i) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        backtrack(0);
    }

}
