package fundamental;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;
//练习1.1中部分题目的解答
public class Ex1_1 {

	public static int mystery(int a, int b) {
		if (b == 0) {
			return 0;
		}
		if (b % 2 == 0) {
			return mystery(a + a, b / 2);
		}
		return mystery(a + a, b / 2) + a;
	}

	public static int mysteryMuti(int a, int b) {
		if (b == 0) {
			return 1;
		}
		if (b % 2 == 0) {
			return mystery(a * a, b / 2);
		}
		return mystery(a * a, b / 2) * a;
	}

	public static String exR1(int n) {
		if (n <= 0) {
			return "";
		}
		return exR1(n - 3) + n + exR1(n - 2) + n;
	}

	public static void testHistogram() {

		int[] a = new int[10];
		for (int i = 0; i < a.length; i++) {
			a[i] = 3;
		}
		System.out.println(Arrays.toString(histogram(a, 10)));
	}

	public static int[] histogram(int[] a, int M) {
		int[] returnAry = new int[M];
		for (int i = 0; i < a.length; i++) {
			if (a[i] < M) {
				returnAry[a[i]]++;
			}
		}
		return returnAry;
	}

	public static int lg(int N) {
		if (N <= 1) {
			return 0;
		}
		if (N == 2) {
			return 1;
		}
		int x = 1;
		int count = 0;
		while (x < N) {
			x *= 2;
			++count;
		}
		return count - 1;
	}

	public static void testPrintBoolean() {
		boolean[][] bs = new boolean[5][5];
		for (int i = 0; i < bs.length; i++) {
			for (int j = 0; j < bs[i].length; j++) {
				if (j % 2 != 0) {
					bs[i][j] = true;
				}
				bs[3][3] = false;
			}
		}
		printBoolean(bs);
	}

	public static void testTransportation() {
		int[][] matrix = new int[4][6];
		int count = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++, count++) {
				matrix[i][j] = count;
			}
		}
		transportMatrix(matrix);
	}

	public static void ex_1_1_4() {
		int f = 0;
		int g = 1;
		for (int i = 0; i <= 15; i++) {
			System.out.println(f);
			f = f + g;
			g = f - g;
		}
	}

	public static void ex_1_1_12() {
		int N = 10;
		int[] a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = 9 - i;
		}
		for (int i = 0; i < N; i++) {
			a[i] = a[a[i]];
		}
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	public static void transportMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
		int[][] tmp = new int[matrix[0].length][matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				tmp[j][i] = matrix[i][j];
			}
		}

		for (int i = 0; i < tmp.length; i++) {
			System.out.println(Arrays.toString(tmp[i]));
		}

	}

	public static void ex_1_1_7() {
		// int sum = 0;
		// for (int i = 1; i < 1000; i++) {
		// for (int j = 0; j < i; j++) {
		// sum++;
		// }
		// }
		// System.out.println(sum);
		// }
		double num = 16.0;
		while (Math.abs(num - 16.0 / num) > .001) {
			num = (16.0 / num + num) / 2.0;
		}
		StdOut.printf("%.3f\n", num);
	}

	public static String toBinaryStr(int n) {
		String s = "";
		for (; n > 0; n /= 2) {
			s = (n % 2) + s;
		}
		return s;
	}

	public static void printBoolean(boolean[][] bs) {
		for (int i = 0; i < bs.length; i++) {
			for (int j = 0; j < bs[i].length; j++) {
				if (bs[i][j]) {
					System.out.print('*');
				} else {
					System.out.print(' ');
				}
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		System.out.println(lg(5));
		System.out.println(exR1(6));
		System.out.println(mysteryMuti(2, 25));
		System.out.println(mysteryMuti(1, 11));
		System.out.println(mysteryMuti(2, 11));

	}
}
