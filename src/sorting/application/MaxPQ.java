package sorting.application;

import java.util.Comparator;

//���ڶѵ����ȶ���
public class MaxPQ<T extends Comparable<T>> {

	private T[] pq;// ���ڶѵ���ȫ������
	private int N = 0;// �洢��pq[1..N], pq[0]û��ʹ��
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
	//�ϸ�ֻҪ����������ӡ��븸�ڵ�
	private void swim(int k) {
		while (k > 1 && less(k / 2, k)) {// �� С�� ��
			exch(k / 2, k);
			k /= 2;
		}
	}
	//�³���Ҫ�ȿ����������ӡ�˭�Ƚϴ�ȡ���߸����ڵ㽻��
	private void sink(int k) {
		while (2 * k <= N) {
			int j = 2 * k;
			if (less(j, j + 1)) {// ���Һ���˭��
				j++;
			}
			if (!less(k, j)) {// ������ӱȸ��ڵ�С������ѭ��
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
		T max = pq[1];//�Ӹ��ڵ�õ����Ԫ��
		exch(1, N--);//���ڵ������һ���ڵ㽻��
		pq[N+1] = null;        //��ֹ��������
		sink(1);//�ָ�������
		return max;
	}
		
	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}


}