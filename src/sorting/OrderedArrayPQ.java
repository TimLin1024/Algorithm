package sorting;

/**
 * 有序数组实现链表
 * 
 **/
public class OrderedArrayPQ<Key extends Comparable<Key>> {

	private Key[] pq;
	private int n;
	
	public OrderedArrayPQ(int capacity) {
		pq = (Key[]) new Comparable[capacity];
		n = 0;
	}
	
	public boolean isEmpty() {
		return n == 0;
	}

	public int size() {
		return n;
	}

	public void insert(Key key) {
		int flag = 0;
		//找到合适的位置
		for (int i = 0; i < pq.length; i++) {
			if (key.compareTo(pq[i]) <= 0) {
				flag = i;
				break;
			}
		}
		for (int k = n; k > flag; k--) {
			pq[k] = pq[k-1];
		}
		pq[flag] = key;
		n++;
	}

	public Key delMax() {
		return pq[--n];
	}

	/****************************
	 * Helper functions
	 *************************/
	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}

	private void exch(int i, int j) {
		Key tmp = pq[i];
		pq[i] = pq[j];
		pq[j] = tmp;
	}

	/***********************
	 * Test routine.
	 ***********************/
	public static void main(String[] args) {
		UnOrderedArrayMaxPQ<String> pq = new UnOrderedArrayMaxPQ<>(10);
		pq.insert("this");
		pq.insert("is");
		pq.insert("a");
		pq.insert("test");
		while (!pq.isEmpty()) {
			System.out.println(pq.delMax());
		}
	}
}
