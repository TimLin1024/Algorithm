package sorting.elementary2_1;

import edu.princeton.cs.algs4.In;

public class ShellSort {
	public static void sort(Comparable[] a) {
		int h = 1;
		int N = a.length;
		while (h < N / 3) {
			h = 3 * h + 1;
		}
		while (h >= 1) {
			// 将数组变为h有序
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
					exch(a, j, j - h);
				}
			}
			h /= 3;
		}
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable tComparable = a[i];
		a[i] = a[j];
		a[j] = tComparable;
	}

	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	private static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[] a = In.readStrings("tinyW.txt");
		sort(a);
		assert isSorted(a);
		show(a);
	}
}
