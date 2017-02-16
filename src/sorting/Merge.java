package sorting;

import java.util.Arrays;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdRandom;
import fundamental.algorithm_analysis1_4.Stopwatch;

public class Merge {
	private static Comparable[] aux;// �鲢����ĸ�������
	private static final int CUTOFF = 3;

	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length];// һ���Է���ռ�
		sort(a, 0, a.length - 1);// length-1 Ҫ�ǵã���ȻԽ��
	}

	// �Զ����µĹ鲢����
	/**
	 * ����˼�� �ǹ���֤���㷨����ȷ����������Ļ����� ����ܽ�����������������ô����ͨ���鲢��������������������������
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
		sort(a, lo, mid);// �������
		sort(a, mid + 1, hi);// �ұ�����
		if (less(a[mid], a[mid + 1])) {// �Ľ� ����������� ĩԪ��С�� ����������ʼԪ�� ��ô�Ͳ�����б�������
			return;
		}
		merge(a, lo, mid, hi);// �鲢���
	}

	// ԭ�ع鲢�����漰������Ԫ�ظ��Ƶ�һ�����������У��ٰѹ鲢�Ľ���Ż�ԭ������
	public static void merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo;
		int j = mid + 1;

		for (int k = lo; k <= hi; k++) {// ע����lo �� hi ������a.length
			aux[k] = a[k];
		}
		for (int k = lo; k <= hi; k++) {
			if (i > mid) { // ��벿���Ѿ���Խ�硱��,����벿���Ѿ��þ�
				a[k] = aux[j++];
			} else if (j > hi) {// �Ұ벿���Ѿ���Խ�硱��,���Ұ벿���Ѿ��þ�
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
	 * �Ľ��� ����Ԫ�ظ��Ƶ��������顣��ʡ���Ƶ����ڹ鲢�ĸ��������ʱ�䣨���ռ䲻�У���
	 * Ҫ������һ�㣬��Ҫ�����������򷽷���һ�ֽ����ݴ������������򵽸������飬 һ�ֽ����ݴӸ�������������������
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
