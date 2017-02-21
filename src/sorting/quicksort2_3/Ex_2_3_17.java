package sorting.quicksort2_3;

import java.util.Arrays;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdRandom;

public class Ex_2_3_17 {

	public static final int M = 10;// 转换参数M的最佳值与 系统有关，但是5~15之间的任意值通常都能令人满意。

	public static void main(String[] args) {
		int MAX = 100;
		Integer[] aIntegers = new Integer[MAX];
		for (int i = 0; i < aIntegers.length; i++) {
			aIntegers[i] = StdRandom.uniform(-MAX, MAX);
		}
		System.out.println("Original: " + Arrays.toString(aIntegers));
		sort(aIntegers);
		System.out.println("Sorted: " + Arrays.toString(aIntegers));
	}

	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		// if (hi<=lo) {
		// return;
		// }
		// 注： 转换参数M的最佳值与 系统有关，但是5~15之间的任意值通常都能令人满意。
		if (hi - lo <= M) {// 改进：小数组使用插入排序
			Insertion.sort(a);
			return;
		}
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}

	private static int partition(Comparable[] a, int lo, int hi) {
		//找出哨兵，将其放在数组的最右端a[length-1]
		int maxIndex = 0;
		for(int i = 0 ; i<a.length; i++){
			if (less(a[maxIndex],a[i])) {
				maxIndex = i;
			}
		}
		exch(a, maxIndex, a.length-1);
		
		int i = lo; // 左扫描指针, 不加1因为 lo 会被选为切分元素
		int j = hi + 1;// 右扫描指针，加1因为--j
		Comparable v = a[lo];// 切分元素
		while (true) {
			while (less(a[++i], v)) {
			
			}
			while (less(v, a[--j])) {
	
			}
			if (i >= j) {
				break;
			}
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
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
}
