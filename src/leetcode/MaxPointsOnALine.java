package leetcode;

//import java.awt.Point;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Problem Max points on a line: https://leetcode.com/problems/max-points-on-a-line/
 * @author Khanh Nguyen
 */
public class MaxPointsOnALine {

    public int maxPoints(int[][] p) {
        int len = p.length;
//        Point[] p = new Point[len];
        if (len <= 2) {
            return len;
        }
        int result = 0;
        for (int i = 0; i < len - 1; ++i) {
            for (int j = i+1; j < len; ++j) {
                int max = 1;
                boolean check = false;
                int a = p[i][0] - p[j][0];
                int b = p[i][1] - p[j][1];
                if (a == 0 && b == 0) {
                    ++max;
                } else {
                    check = true;
                    int g = gcd(a > 0 ? a : -a, b > 0 ? b : -b);
                    a /= g;
                    b /= g;
                }
                for (int k = 0; k < len; ++k) {
                    if (k != i && k != j) {
                        int c = p[i][0] - p[k][0];
                        int d = p[i][1] - p[k][1];
                        if (c == 0 && d == 0) {
                            ++max;
                        } else if (!check) {
                            ++max;
                            check = true;
                            a = c; b = d;
                            int g = gcd(a > 0 ? a : -a, b > 0 ? b : -b);
                            a /= g;
                            b /= g;
                        } else {
                            int g = gcd(c > 0 ? c : -d, d > 0 ? d : -d);
                            c /= g;
                            d /= g;
                            if ((a == c && b == d) || (a == -c || b == -d)) {
                                ++max;
                            }
                        }
                    }
                }
                if (max > result) {
                    result = max;
                }
            }
        }
        return result;
    }

    public int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

}
