package sorting.elementary2_1;

import java.awt.Color;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;

public class Insertion {
	public static void sort(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
					exch(a, j-1, j);
			}
			show(a,i);
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
	private static void draw() {
	}
	private static void show(Comparable[] a,int num) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		StdDraw.clear();
		StdDraw.setXscale(0,a.length+10);
		StdDraw.setYscale(0,200);
		StdDraw.setPenColor(Color.RED);
		StdDraw.setPenRadius(0.01);
		
		for (int i = 0; i < a.length; i++) {
			if (i > num) {
				StdDraw.setPenColor(Color.GRAY);
			}
			StdDraw.line(i, 0, i, Double.parseDouble((String) a[i]));
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
	}

}
