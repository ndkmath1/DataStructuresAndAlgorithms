package branchandbound;

import java.util.Scanner;

/*
----------------------
Input: The first line contains two numbers m and n, m denote number city, n denote number edge.
Each of m subsequence line contains i, j, c (c = cost(vertex i, vertex j))
Sample input:
4 6
1 2 3
1 3 2
1 4 1
2 3 1
2 4 2
3 4 4
Output:
1->3->2->4->1
Cost: 6
----------------------
Sample input 2:
4 6
1 2 20
1 3 35
1 4 42
2 3 34
2 4 30
3 4 12
Output:
1->2->4->3->1
Cost: 97
----------------------
 */

public class TravellingSalesman {

	static int[][] c;
	static int nV;
	static int nE;
	static final int MAX_E = 100;
	static final int MAX_W = 1000000;
	static int minCost = MAX_E * MAX_W;
	static int[] x;
	static boolean[] mark;
	static int spending;
	static boolean check;
	static int[] bestWay;

	static void init() {
		Scanner sc = new Scanner(System.in);
		nV = sc.nextInt();
		x = new int[nV + 2];
		bestWay = new int[nV + 2];
		x[1] = x[nV + 1] = bestWay[1] = bestWay[nV + 1] = 1;
		mark = new boolean[nV + 1];
		mark[1] = true;
		c = new int[nV + 1][nV + 1]; // default, c[i][j] = 0
		nE = sc.nextInt();
		for (int i = 0; i < nE; ++i) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			c[v1][v2] = c[v2][v1] = sc.nextInt();
		}

	}

	static void attempt(int i) {
		for (int v = 2; v <= nV; ++v) {
			if (c[x[i - 1]][v] != 0 && !mark[v] && (spending + c[x[i - 1]][v] < minCost)) {
				mark[v] = true;
				spending += c[x[i - 1]][v];
				x[i] = v;
				if (i == nV) {
					spending += c[x[nV]][x[1]];
					if (spending < minCost) {
						check = true;
						minCost = spending;
						// copy array
//						bestWay = x;
						for (int j = 0; j < x.length; ++j) {
							bestWay[j] = x[j];
						}
//						printResult();
					}
					spending -= c[x[nV]][x[1]];
				} else {
					attempt(i + 1);
				}
				spending -= c[x[i - 1]][v];
				mark[v] = false;
			}
		}
	}

	static void printResult() {
//		for (int i = 1; i <= nV + 1; ++i) {
//			if (i == nV + 1) {
//				System.out.print(bestWay[i]);
//			} else {
//				System.out.print(bestWay[i] + "->");
//			}
//		}
//		System.out.print("\nCost: " + minCost);
		System.out.print(minCost);
	}

	static void test() {
		init();
		attempt(2);
		if (check) {
			printResult();
		} else {
			System.out.print(-1);
		}
	}

	public static void main(String[] args) {
		test();
	}

}
