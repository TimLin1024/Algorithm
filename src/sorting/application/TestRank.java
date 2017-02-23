package sorting.application;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.Exchanger;

import javax.swing.LayoutStyle;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Transaction;

public class TestRank {
	private static final int MAX = 40;
	public static void main(String[] args) {
		int count = 0;
		Integer[] a = new Integer[MAX];
		for (int i = 0; i < a.length; i++) {
			a[i] = StdRandom.uniform(0 ,MAX);
		}
		System.out.println(Arrays.toString(a));
		System.out.println(select(a, 8));
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
//		int[] counts = new int[a.length];
//		for (int i = 1; i < counts.length; i++) {
//			if (a[i] == a[i-1]) {
//				counts[a[i]] ++;
//			}
//		}
//		int maxF = 0;
//		for (int i = 0; i < counts.length; i++) {
//			if (counts[i] != 0) {
//				count++;
//				if (maxF < counts[i]) {
//					maxF = counts[i];
//				}
//			}
//		}
//		
//		System.out.println(Arrays.toString(counts));
//		System.out.println("maxF= " + maxF);
//		System.out.println("count= " + count);
	}
	
	public static Comparable select(Comparable[] a, int k) {
		StdRandom.shuffle(a);
		int lo = 0, hi = a.length-1;
		while (hi > lo) {
			int j = partition(a, lo, hi);
			if (j == k) {
				return a[j];
			}else if (j < k) {
				lo = j + 1;
			}else if (j > k) {
				hi = j - 1;
			}
		}
		return a[k];
	}
	
	public static int partition(Comparable[] a, int lo, int hi) {
		int i = lo;
		int j = hi+1;
		while (true) {
			while (less(a, ++i, lo)) {
				if (i == hi) {
					break;
				}
			}
			while (less(a, lo, --j)) {
				if (j == lo) {
					break;
				}
			}
			if (i >= j) {
				break;
			}
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	private static boolean less(Comparable[] a, int i, int j) {
		return a[i].compareTo(a[j]) < 0;
	}
}
