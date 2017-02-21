package sorting.quicksort2_3;

import java.util.Arrays;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdRandom;

public class Quick {
	public static final int M = 10;//ת������M�����ֵ�� ϵͳ�йأ�����5~15֮�������ֵͨ�������������⡣
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
		sort(a, 0, a.length-1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi) {
//		if (hi<=lo) {
//			return;
//		}
		//ע�� ת������M�����ֵ�� ϵͳ�йأ�����5~15֮�������ֵͨ�������������⡣
		if (hi - lo <=  M) {//�Ľ���С����ʹ�ò������� 
			Insertion.sort(a);
			return;
		}
		int j = partition(a, lo, hi);
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}
	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo; // ��ɨ��ָ��, ����1��Ϊ lo �ᱻѡΪ�з�Ԫ��
		int j = hi + 1;//��ɨ��ָ�룬��1��Ϊ--j
		Comparable v = a[lo];//�з�Ԫ��
		while (true) {
			while (less(a[++i],v)) {
				if (i == hi) {
					break;
				}
			}
			while (less(v, a[--j])) {
				if (j == lo) {
					break;
				}
			}
			if (j <= i) {
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
		for(int i = 1; i<a.length; i++){
			if (less(a[i], a[i-1])) {
				return false;
			}
		}
		return true;
	}
}
