package stringsearching;

public class Naive {
	
	/**
	 * Return first position matching of pattern p in text t
	 * @param t text
	 * @param p pattern
	 * @return
	 */
	int naiveSM(char[] t, char[] p) {
		int n = t.length;
		int m = p.length;
		int max = n - m;
		for (int i = 0; i <= max; ++i) {
			int j = 0;
			for (; j < m && p[j] == t[i + j]; ++j);
			if (j == m) {
				return i;
			}
		}
		return -1;
	}
	
	int naiveSMShiftRight(char[] t, char[] p) {
		int n = t.length;
		int m = p.length;
		int max = n - m;
		for (int i = 0; i <= max; ++i) {
			int j = m - 1;
			for (; j >= 0 &&  p[j] == t[i + j]; --j);
			if (j == -1) {
				return i;
			}
		}
		return -1;
	}
	
	void test() {
		String ts = "abcmnpq aaaxyzt aaaxyzt";
		char[] t = ts.toCharArray();
		String ps = "aaaxyzt";
		char[] p = ps.toCharArray();
		System.out.println("naiveSM: " + naiveSM(t, p));
	}
	
	public static void main(String[] args) {
		new Naive().test();
	}

}
