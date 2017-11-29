package backtracking;

import java.util.Scanner;

/**
 * 
 * @author khanh
 *
 */
public class CombinationEnumeration {
	
	private int n, k, x[];
	
	private void readData() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		x = new int[k];
	}
	
	private void attemp(int i) {
		
	}
	
	private void print() {
		
	}
	
	public static void main(String[] args) {
		CombinationEnumeration ce = new CombinationEnumeration();
		ce.readData();
		ce.attemp(1);
	}

}
