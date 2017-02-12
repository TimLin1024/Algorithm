package searching;

import edu.princeton.cs.algs4.Queue;

/**
 * 有序表 二分查找，(基于有序数组)
 * 
 * 为什么要用数组的方式来存储？
 *  	二分查找似乎在数组中比较好实现，
 *  	二分查找的高效来自于能够快速通过索引取得任何子数组和链表的中间元素
 * 
 * 为什么要用两个数组？而不是只用一个数组通过用它的索引来获取值？
 * 		如果只用一个数组，那么索引的值只能为数字1,2,3,4,5...就算能用String来对应，也只是数字
 * 而使用两个数组可以，那么key的值就能是任意的对象了。对象有序地存储在数组中，
 * 进行二分查找，获取其在数组中的索引，然后用这个索引到value数组中去获取值。
 * 
 * 跟使用链表实现的表有何区别？
 * 
 * 
 */

public class BinarySearchST<Key extends Comparable<Key>, Value> {
	private Key[] mKeys;
	private Value[] mValues;
	private int N;

	public BinarySearchST(int capacity) {
		mKeys = (Key[]) new Comparable[capacity];
		mValues = (Value[]) new Object[capacity];
	}

	public int size() {
		return N;
	}

	public void put(Key key, Value value) {
		if (key == null)
			throw new IllegalArgumentException("first argument to put() is null");
		// 查找键，找到则更新值，否则创建新的元素
		int i = rank(key);
		if (i < N && mKeys[i].compareTo(key) == 0) {
			mValues[i] = value;
			return;
		}
		for (int j = N; j > i; j--) {
			mKeys[i] = mKeys[i - 1];
			mValues[i] = mValues[i - 1];
		}
		mKeys[i] = key;
		mValues[i] = value;
		N++;
	}

	public void deleteAuthority(Key key) {
		if (key == null){
			throw new IllegalArgumentException("argument to delete() is null");
		}
		
		if (isEmpty())
			return;

		// compute rank
		int i = rank(key);
		// key not in table
		if (i == N || mKeys[i].compareTo(key) != 0) {
			return;
		}

		for (int j = i; j < N - 1; j++) {
			mKeys[j] = mKeys[j + 1];
			mValues[j] = mValues[j + 1];
		}

		N--;
		mKeys[N] = null; // to avoid loitering
		mValues[N] = null;

		// resize if 1/4 full
		// if (N > 0 && N == mKeys.length/4) resize(mKeys.length/2);

		// assert check();
	}

	public void delete(Key key) {
		if (key == null) {
			throw new IllegalArgumentException("argument to delete() is null");
		}
		if (isEmpty()) {
			return;
		}
		int i = rank(key);

		if (i < N && mKeys[i].compareTo(key) == 0) {
			// 元素前移
			for (int j = i; j < N - 1; j++) {
				mKeys[j] = mKeys[j + 1];
				mValues[j] = mValues[j + 1];
			}
			N--;
			mKeys[N] = null;
			mValues[N] = null;
		}
	}

	public Value get(Key key) {
		if (isEmpty()) {
			return null;
		}
		int i = rank(key);
		if (i < N && mKeys[i].compareTo(key) == 0) {
			return mValues[i];
		} else {
			return null;
		}
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int rank(Key key) {
		int lo = 0;
		int hi = N - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (key.compareTo(mKeys[mid]) < 0) {
				hi = mid - 1;
			} else if (key.compareTo(mKeys[mid]) > 0) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		return lo;
	}

	// 递归版本
	public int rank(Key key, int lo, int hi) {
		if (hi < lo) {
			return lo;// 找不到就返回lo（小于它的键的数量）
		}
		int mid = lo + (hi - lo) / 2;
		if (key.compareTo(mKeys[mid]) < 0) {
			return rank(key, lo, mid - 1);
		} else if (key.compareTo(mKeys[mid]) > 0) {
			return rank(key, mid + 1, hi);
		} else {
			return mid;
		}
	}

	public Iterable<Key> keys() {
		Queue<Key> queue = new Queue<>();
		for (int i = 0; i < N; i++) {
			queue.enqueue(mKeys[i]);
		}
		return queue;
	}

	public static void main(String[] args) {
		int MAX = 10;
		BinarySearchST<String, Integer> st = new BinarySearchST<>(MAX);
		for (int i = 0; i < MAX; i++) {
			String key = "i" + i;
			st.put(key, i);
		}
		st.delete("i5");
		st.delete("i2");
		for (String s : st.keys()) {
			System.out.println(s + " " + st.get(s));
		}
	}
}
