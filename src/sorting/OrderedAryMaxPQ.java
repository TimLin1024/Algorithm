package sorting;

import java.util.Arrays;

import edu.princeton.cs.algs4.Insertion;

public class OrderedAryMaxPQ<T extends Comparable<T>> {
	
	private T[] keys;
	private int N;
	
	public OrderedAryMaxPQ() {

	}

	public OrderedAryMaxPQ(int max) {
		keys = (T[]) new Object[max];
//		N = max;
	}

	public OrderedAryMaxPQ(T[] a) {
		N = a.length;
		keys = (T[])new Object[N];
		for (int i = 0; i < a.length; i++) {
			keys[i] = a[i];
		}
		Arrays.sort(a);
	}

	public void insert(T v) {
		if (N == keys.length / 2) {
			resizingAry(keys.length * 2);
		}
		keys[N++] = v;
		Quick.sort(keys);
	}

	public T max() {
		return keys[N];
	}

	public T delMax() {
		return keys[N--];
	}

	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	private void resizingAry(int len) {
		T[] tmp = (T[]) new Object[len];
		for (int i = 0; i < N; i++) {
			tmp[i] = keys[i];
		}
		keys = tmp;
		N = len;
	}
}
