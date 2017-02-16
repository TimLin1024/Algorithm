package sorting;

import java.util.Arrays;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdRandom;
import fundamental.algorithm_analysis1_4.Stopwatch;

public class Merge {
	private static Comparable[] aux;// 归并所需的辅助数组
	private static final int CUTOFF = 3;

	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length];// 一次性分配空间
		sort(a, 0, a.length - 1);// length-1 要记得，不然越界
	}

	// 自顶向下的归并排序
	/**
	 * 分治思想 是归纳证明算法能正确将数组排序的基础： 如果能将两个子数组排序，那么就能通过归并两个子数组来将整个数组排序
	 */
	private static void sort(Comparable[] a, int lo, int hi) {
		// if (hi <= lo) {
		// return;
		// }
		if (hi - lo <= CUTOFF - 1) {
			Insertion.sort(a);
			return;
		}
		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid);// 左边排序
		sort(a, mid + 1, hi);// 右边排序
		if (less(a[mid], a[mid + 1])) {// 改进 如果左子数组 末元素小于 右子数组起始元素 那么就不需进行本次排序
			return;
		}
		merge(a, lo, mid, hi);// 归并结果
	}

	// 原地归并。将涉及的所有元素复制到一个辅助数组中，再把归并的结果放回原数组中
	public static void merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo;
		int j = mid + 1;

		for (int k = lo; k <= hi; k++) {// 注意是lo 和 hi 而不是a.length
			aux[k] = a[k];
		}
		for (int k = lo; k <= hi; k++) {
			if (i > mid) { // 左半部分已经“越界”了,即左半部分已经用尽
				a[k] = aux[j++];
			} else if (j > hi) {// 右半部分已经“越界”了,即右半部分已经用尽
				a[k] = aux[i++];
			} else if (less(aux[j], aux[i])) {
				a[k] = aux[j++];
			} else {
				a[k] = aux[i++];
			}
		}
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	/*
	 * 改进： 不将元素复制到辅助数组。节省复制到用于归并的辅助数组的时间（但空间不行）。
	 * 要做到这一点，需要调用两种排序方法，一种将数据从输入数组排序到辅助数组， 一种将数据从辅助数组排序到输入数组
	 **/
	/*
	 * Eliminate the copy to the auxiliary array. Save time (but not space) by
	 * switching the role of the input and auxiliary array in each recursive
	 * call.
	 */
	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				aux[k] = a[j++];
			else if (j > hi)
				aux[k] = a[i++];
			else if (less(a[j], a[i]))
				aux[k] = a[j++];
			else
				aux[k] = a[i++];
		}
	}

	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(aux, a, lo, mid);
		sort(aux, a, mid + 1, hi);
		merge(a, aux, lo, mid, hi);
	}

	public static void main(String[] args) {
		final int MAX = 1000;
		Integer[] a = new Integer[MAX];
		for (int i = 0; i < a.length; i++) {
			a[i] = StdRandom.uniform(-MAX, MAX);
		}
		System.out.println("Original array " + Arrays.toString(a));
		Merge.sort(a);
  		System.out.println("Sorted array " + Arrays.toString(a));
	}
}
