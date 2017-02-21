package sorting.quicksort2_3;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;
import fundamental.algorithm_analysis1_4.Stopwatch;

public class Quick3Way {
	
	/**
	 *     < v     = v -------未排序 ---  ---- > v 
	 * lo  --      lt  --     i    --- gt   --    hi
	 * 
	 * */
	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) {
			return;
		}
		int lt = lo;
		int i = lo+1;
		int gt = hi;
		Comparable v = a[lo];
		while (i<=gt) {
			int cmp = a[i].compareTo(v);
			if (cmp < 0) {
				exch(a, i++, lt++);
			}else if (cmp > 0) {
				exch(a, i, gt--);
			}else {
				i++;
			}
		}//现在 a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi] 成立
		sort(a, lo, lt-1);
		sort(a, gt+1, hi);
	}
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable tComparable = a[i];
		a[i] = a[j];
		a[j] = tComparable;
	}
	
	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length-1);
	}
	
	public static void main(String[] args) {
		int MAX = 100;
		Integer[] aIntegers = new Integer[MAX];
		for (int i = 0; i < aIntegers.length; i++) {
			aIntegers[i] = StdRandom.uniform(-MAX, MAX);
		}
		System.out.println("Original: " + Arrays.toString(aIntegers));
		Stopwatch stopwatch = new Stopwatch();
		sort(aIntegers);
		System.out.println("time: " + stopwatch.elapsedTime());
		System.out.println("Sorted: " + Arrays.toString(aIntegers));
	}
}
