package searching;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*顺序查找（基于无序链表）*/
public class SequentialSearchST<Key, Value> {
	private Node first;
	private int count;

	private class Node {
		// 链表节点的定义
		Key key;
		Value value;
		Node next;

		public Node(Key key, Value value, SequentialSearchST<Key, Value>.Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	public Value get(Key key) {
		for (Node tmp = first; tmp != null; tmp = tmp.next) {
			if (key.equals(tmp.key)) {
				return tmp.value;
			}
		}
		return null;
	}

	// 查找给定的键找到则更新其值，找不到则新建节点
	public void put(Key key, Value value) {
		for (Node tmp = first; tmp != null; tmp = tmp.next) {
			if (tmp.key.equals(key)) {
				tmp.value = value;
				return;
			}
		}
		first = new Node(key, value, first);
		count++;
	}

	/**
	 * Removes the specified key and its associated value from this symbol table
	 * (if the key is in this symbol table).
	 **/
	public void delete(Key key) {
		if (key == null) {
			throw new IllegalArgumentException("argument to delete is null");
		}
		first = delete(first, key);

	}

	// 递归方式
	private Node delete(Node x, Key key) {
		if (x == null) {
			return null;
		}
		if (key.equals(x.key)) {
			count--;
			return x.next;
		}
		x.next = delete(x.next, key);
		return x;
	}

	// 迭代删除
	public void iteraiveDelete(Key key) {
		if (key == null) {
			throw new IllegalArgumentException("argument to delete is null");
		}
		Node cur = null;
		Node prev = null;
		for (cur = prev = first; cur != null; cur = cur.next) {
			if (cur.key.equals(key)) {
				prev.next = cur.next;
				cur = null;// 避免对象游离
				count--;
				return;
			}
			prev = cur;
		}
	}

	public int size() {
		return count;
	}

	public Iterable<Key> keys() {
		Queue<Key> queue = new Queue<>();
		for (Node xNode = first; xNode != null; xNode = xNode.next) {
			queue.enqueue(xNode.key);
		}
		return queue;
	}

	public SequentialSearchST() {
	}

	public static void main(String[] args) {
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
		for (int i = 0; i < 8; i++) {
			String key = "key" + i;
			st.put(key, i);
		}
		st.delete("key4");
		st.iteraiveDelete("key5");
		for (String s : st.keys())
			StdOut.println(s + " " + st.get(s));

	}
}
