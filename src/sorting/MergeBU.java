package sorting;

public class MergeBU {
	private static Comparable[] aux;//归并所需的辅助数组
	public static void sort(Comparable[] a) {

		
		//进行logN次两两归并
		int N = a.length;
		aux = new Comparable[N];
		for (int sz = 1; sz < N; sz = sz + sz) {//sz子数组的大小
			for (int lo = 0; lo < N - sz; lo += sz+sz) {//lo:子数组的索引
				merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1,N-1));
			}
		}
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
//			if (i > mid) { // 左半部分已经“越界”了,即左半部分已经用尽
//				a[k] = aux[j];
//				j++;
//			} else if (j > hi) {// 右半部分已经“越界”了,即右半部分已经用尽
//				a[k] = aux[i];
//				i++;
//			} else if (less(a[i], a[j])) {
//				a[k] = aux[i];
//				i++;
//			} else {
//				a[k] = aux[j];
//				j++;
//			}
		}
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	
}
