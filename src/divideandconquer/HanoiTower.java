package divideandconquer;

import java.util.Scanner;

public class HanoiTower {
	
	static void move(String src, String dst, String tmp, int nDisk) {
		if (nDisk == 1) {
			System.out.println("Move one disk from " + src + " to " + dst);
		} else {
			move(src, tmp, dst, nDisk - 1);
			move(src, dst, tmp, 1);
			move(tmp, dst, src, nDisk - 1);
		}
	}
	
	static void test() {
		Scanner sc = new Scanner(System.in);
		move("S", "D", "T", sc.nextInt());
	}
	
	public static void main(String[] args) {
		test();
	}

}
