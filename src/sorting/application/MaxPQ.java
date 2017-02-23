package sorting.application;

import java.util.Comparator;

//基于堆的优先队列
public class MaxPQ<T extends Comparable<T>> {

	private T[] pq;// 基于堆的完全二叉树
	private int N = 0;// 存储于pq[1..N], pq[0]没有使用
	private Comparator<T> mComparator;
	
	public MaxPQ(int maxN) {
		pq = (T[]) new Comparable[maxN];
	}
	
	public MaxPQ(Comparator<T> comparator) {
		mComparator = comparator;
	}

	private boolean less(int i, int j) {
		if (mComparator == null) {
			return pq[i].compareTo(pq[j]) < 0;
		}else{
			return mComparator.compare(pq[i], pq[j]) < 0;
		}
	}

	private void exch(int i, int j) {
		T tmp = pq[i];
		pq[i] = pq[j];
		pq[j] = tmp;
	}
	//上浮只要看这个“儿子”与父节点
	private void swim(int k) {
		while (k > 1 && less(k / 2, k)) {// 父 小于 子
			exch(k / 2, k);
			k /= 2;
		}
	}
	//下沉需要先看“两个孩子”谁比较大，取大者跟父节点交换
	private void sink(int k) {
		while (2 * k <= N) {
			int j = 2 * k;
			if (less(j, j + 1)) {// 左右孩子谁大？
				j++;
			}
			if (!less(k, j)) {// 如果孩子比父节点小，跳出循环
				break;
			}
			exch(k, j);
			k = j;
		}
	}

	public void insert(T v) {
		pq[++N] = v;
		swim(N);
	}

//	public T max() {
//		return pq[1];
//	}

	public T delMax() {
		T max = pq[1];//从根节点得到最大元素
		exch(1, N--);//根节点与最后一个节点交换
		pq[N+1] = null;        //防止对象游离
		sink(1);//恢复堆序性
		return max;
	}
		
	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}


}