package sorting.priority_queue2_4;


/*
 * 无序数组实现的优先队列
 * 
 * 不足，没有对数组大小进行更改
 * 没有检查上越界和下越界
 * */
public class UnOrderedArrayMaxPQ<Key extends Comparable<Key>> {
	private Key[] pq;
	private int n;

	public UnOrderedArrayMaxPQ(int capacity) {
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
		pq[n] = key;
		n++;
	}

	public Key delMax() {
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (less(max, i)) {
				max = i;
			}
		}
		exch(max, n - 1);
		--n;
		return pq[n];
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
