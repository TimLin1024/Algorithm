package sorting.priority_queue2_4;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.TimeZone;

/**
 * �������ȶ��� ��Ӧ���У��������������Ѿ��������ȶ����е�Ԫ���Ǻ��б�Ҫ�� 
 * һ��ʵ�ֵķ������Ǹ�ÿһ��Ԫ�� һ������ 
 * ��Ҫ����ƽ������
 * 
 */
public class IndexMinPQ<Item extends Comparable<Item>> {

	private int maxN;// �������
	private int N;// ����
	private int[] pq;
	private int[] qp;
	private Item[] keys;

	public IndexMinPQ(int maxN) {
		if (maxN < 0) {
			throw new IllegalArgumentException();
		}
		this.maxN = maxN + 1;
		N = 0;
		pq = new int[maxN + 1];
		qp = new int[maxN + 1];
		keys = (Item[]) new Comparable[maxN + 1];
		for (int i = 0; i <= maxN; i++) {
			qp[i] = -1;
		}
	}

	public void insert(int i, Item item) {
		if (i < 0 || i >= maxN) {
			throw new IndexOutOfBoundsException();
		}
		if (contains(i)) {
			throw new IllegalArgumentException("index is already in priorty queue");
		}
		N++;
		qp[i] = N;
		pq[N] = i;
		keys[i] = item;
	}

	private void swim(int k) {
		while (k > 1 && less(k / 2, k)) {// ��1��ʼ
			exch(k / 2, k);
			k /= 2; // ������k�������¸�ֵ
		}
	}

	private void sink(int k) {
		while (2 * k <= N) {
			int j = 2 * k;
			if (less(j, j + 1)) {
				j++;
			}
			if (!less(k, j)) {
				break;
			}
			exch(k, j);
			// k *= 2;
			k = j;
		}
	}

	private void exch(int i, int j) {
		int tmp = pq[i];
		pq[i] = pq[j];
		pq[j] = tmp;
		qp[pq[i]] = i;
		qp[pq[j]] = j;

	}

	private boolean less(int i, int j) {
		return keys[i].compareTo(keys[j]) < 0;
	}

	public void change(int i, Item item) {
		if (i < 0 || i >= maxN) {
			throw new IndexOutOfBoundsException();
		}
		if (!contains(i)) {
			throw new NoSuchElementException("index is not in the priority queue");
		}
		keys[i] = item;
		swim(qp[i]);
		sink(qp[i]);
	}

	public boolean contains(int i) {
		if (i < 0 || i > maxN) {
			throw new IndexOutOfBoundsException();
		}
		return qp[i] != -1;
	}

	public void delete(int k) {

	}

	public Item minItem() {
		if (N == 0) {
			throw new NoSuchElementException();
		}
		return keys[pq[1]];
	}

	public int minIndex() {
		if (N == 0) {
			throw new NoSuchElementException();
		}
		return pq[1];
	}

	public int delMin() {
		if (N == 0) {
			throw new NoSuchElementException("Priority queue underflow");
		}
		int min = pq[1];
		exch(1, N--);
		sink(1);
		assert min == pq[N + 1];
		qp[min] = -1;
		keys[min] = null;
		pq[N + 1] = -1;
		return min;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

}
