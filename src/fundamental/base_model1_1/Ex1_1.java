package fundamental.base_model1_1;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import edu.princeton.cs.algs4.StdIn;
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

	public static long ex_1_1_19f(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return ex_1_1_19f(n - 1) + ex_1_1_19f(n - 2);
	}

	public static long fib(int N) {
		long[] f = new long[N + 1];
		fib(N, f);
		return f[N];
	}

	private static long fib(int N, long[] f) {
		if (f[N] == 0) {
			if (N == 1) {
				f[N] = 1;
			} else if (N > 1) {
				f[N] = fib(N - 1) + fib(N - 2);
			}
		}
		return f[N];
	}

	public static double lnNFactorial(int N) {
		if (N == 1 || N == 0) {
			return 0;
		}
		return Math.log1p(N) + lnNFactorial(N - 1);
	}

	// readAllStrings()的读取结果为字符串数组，凡是遇到空格或换行时自动创建新数组
	public static void ex1_1_21Answer() {
		String[] strings = StdIn.readAllStrings();
		int N = strings.length / 3;
		for (int i = 0; i < N; i++) {
			String name = strings[3 * i];
			int mathgrade = Integer.parseInt(strings[3 * i + 1]);
			int avggrade = Integer.parseInt(strings[3 * i + 2]);
			double percentage = (double) mathgrade / avggrade;
			StdOut.printf("%s" + "|" + "%d" + "|" + "%d" + "|" + "%.3f\n", name, mathgrade, avggrade, percentage);
		}
	}

	public static void ex1_1_21() {
		Scanner scanner = new Scanner(System.in);
		String string = null;
		File file = new File("str.txt");
		BufferedWriter bufferedWriter = null;
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		while (scanner.hasNext()) {
			string = scanner.nextLine();
			if (string.equals("exit")) {
				break;
			}
			try {
				bufferedWriter.write(string);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			while (bufferedReader.read() != -1) {
				String s = bufferedReader.readLine();
				String name = s.substring(0, s.indexOf(" "));
				String num = s.substring(s.indexOf(" ")).trim();
				System.out.println(name + "\t" + num);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 截取数字
	private static String getNumber(String content) {
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			return matcher.group(0);
		}
		return "";
	}

	// 截取非数字
	private static String getNonNumber(String content) {
		Pattern pattern = Pattern.compile("\\D+");
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			return matcher.group(0);
		}
		return "";
	}

	public static int rank(int key, int[] a) {
		if (a == null) {
			throw new IllegalArgumentException("ary can't be null");
		}
		return rank(key, a, 0, a.length - 1, 1);
	}

	public static int rank(int key, int[] a, int lo, int hi, int depth) {
		if (lo > hi) {
			return -1;
		}
		int mid = lo + (hi - lo) / 2;
		for (int i = 0; i < depth; i++) {
			System.out.print(" ");
		}
		System.out.println("lo:" + lo + ",hi:" + hi);
		if (a[mid] > key) {
			return rank(key, a, lo, mid - 1, ++depth);
		} else if (a[mid] < key) {
			return rank(key, a, mid + 1, hi, ++depth);
		} else {
			return mid;
		}
	}
	public static double binomial(int N, int k, double p) {
		return binomial(N, k, p,1);
	}
	public static double binomial(int N, int k, double p,int count) {
		if (N == 0 && k == 0){
			System.out.println("count: "+count);
			return 1.0;
		}
		if (N < 0 || k < 0){
			System.out.println("N < 0 || k < 0 "+count);
			return 0.0;
		}
		return (1.0 - p) * binomial(N - 1, k, p,++count) + p * binomial(N - 1, k - 1, p,++count);
	}

	public static void main(String[] args) {
		binomial(10, 5, 0.25);
	}
}
