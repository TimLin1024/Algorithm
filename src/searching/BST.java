package searching;

import edu.princeton.cs.algs4.Queue;

public class BST<Key extends Comparable<Key>, Value> {
	private Node root;

	private class Node {
		private Key key;
		private Value value;
		private Node left;
		private Node right;
		private int N;// 以该节点为根的子树中的节点总数

		public Node(Key key, Value value, int n) {
			this.key = key;
			this.value = value;
			N = n;
		}
	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {
		if (node == null) {
			return 0;
		}
		return node.N;
	}

	public Value get(Key key) {
		return get(root, key);
	}

	private Value get(Node node, Key key) {
		if (node == null) {
			return null;
		}
		int cmp = key.compareTo(node.key);
		if (cmp < 0) {
			return get(node.left, key);
		} else if (cmp > 0) {
			return get(node.right, key);
		} else {
			return node.value;
		}
	}

	public void put(Key key, Value value) {
		root = put(root, key, value);
	}

	private Node put(Node x, Key key, Value value) {
		if (x == null) {
			return new Node(key, value, 1);
		}
		// 树非空
		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			x.left = put(x.left, key, value);
		} else if (cmp > 0) {
			x.right = put(x.right, key, value);
		} else {
			x.value = value;
		}
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	public Key min() {
		return min(root).key;
	}

	// 最小值在最左边
	public Node min(Node x) {
		if (x.left == null) {
			return x;
		}
		return min(x.left);
	}

	public Key max() {
		return max(root).key;
	}

	// 最大值在最右边
	public Node max(Node x) {
		if (x.right == null) {
			return x;
		}
		return max(x.right);
	}

	public Key ceiling(Key key) {
		Node x = ceiling(root, key);
		if (x == null) {
			return null;
		} else
			return x.key;
	}

	private Node ceiling(Node xNode, Key key) {
		if (xNode == null) {
			return null;
		}
		int cmp = key.compareTo(xNode.key);
		if (cmp == 0) {
			return xNode;
		}
		if (cmp < 0) {
			Node tNode = ceiling(xNode.left, key);
			if (tNode != null) {
				return tNode;
			} else {
				return xNode;
			}
		}
		return ceiling(xNode.right, key);
	}

	public Key floor(Key key) {
		Node xNode = floor(root, key);
		if (xNode == null) {
			return null;
		}
		return xNode.key;
	}

	private Node floor(Node x, Key key) {
		if (x == null) {
			return null;
		}
		int cmp = key.compareTo(x.key);
		if (cmp == 0) {
			return x;
		}
		if (cmp < 0) {
			return floor(x.left, key);
		}

		Node t = floor(x.right, key);
		if (t != null) {
			return t;
		} else {
			return x;
		}
	}

	// 找到排名為num的键(从小到大)
	public Key select(int num) {
		return select(root, num).key;
	}

	private Node select(Node x, int num) {
		if (x == null) {
			return null;
		}
		int t = size(x.left);// 左子树的节点数量
		if (t > num) {
			return select(x.left, num);
		} else if (t < num) {
			return select(x.right, num - t - 1);
		} else {
			return x;
		}
	}

	public int rank(Key key) {
		return rank(key, root);
	}

	private int rank(Key key, Node x) {
		// 返回以x为根节点的子树中小于key 的键的数量（为什么书中为x.key）
		if (x == null) {
			return 0;
		}
		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			return rank(key, x.left);
		} else if (cmp > 0) {
			return 1 + size(x.left) + rank(key, x.right);
		} else {
			return size(x.left);
		}
	}

	public void deleteMin() {
		root = deleteMin(root);
	}

	private Node deleteMin(Node x) {
		if (x.left == null) {// 不断检索左子树直至遇见 空左链接
			return x.right;
		}
		x.left = deleteMin(x.left);// 把右子树 赋给 上 一节点的 左链接
		x.N = size(x.left) + size(x.right) + 1; // 更新链接和节点计数器
		return x;
	}

	public void delete(Key key) {
		root = delete(root, key);
	}

	public Node delete(Node x, Key key) {
		if (x == null) {
			return null;
		}
		int cmp = key.compareTo(x.key);
		// 前面if 和 else if 先找到要删除的节点。
		if (cmp < 0) {
			x.left = delete(x.left, key);
		} else if (cmp > 0) {
			x.right = delete(x.right, key);
		} else {
			if (x.right == null) {
				return x.left;
			}
			if (x.left == null) {
				return x.right;
			}
			Node t = x;
			x = min(x.right);
			x.right = deleteMin(t.right);// 删除右子树中的最小的节点，返回的值赋给 新结点的右链接
			x.left = t.left;
		}
		x.N = size(x.left) + size(x.right) + 1;// 更新节点的值
		return x;
	}

	public Iterable<Key> keys() {
		return keys(min(), max());
	}

	public Iterable<Key> keys(Key lo, Key hi) {
		Queue<Key> queue = new Queue<>();
		keys(root, queue, lo, hi);
		return queue;
	}

	private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
		if (x == null) {
			return;
		}
		int cmplo = lo.compareTo(x.key);
		int cmphi = hi.compareTo(x.key);
		// （递归地 ）查找根节点的左子树
		if (cmplo < 0) {
			keys(x.left, queue, lo, hi);
		}
		// 比较一下根节点
		if (cmplo <= 0 && cmphi >= 0) {
			queue.enqueue(x.key);
		}
		// （递归地 ）查找根节点的右子树
		if (cmphi > 0) {
			keys(x.right, queue, lo, hi);
		}

	}

	public int height() {
		return height(root);
	}

	private int height(Node x) {
		if (x == null) {
			return -1;
		}
		return 1 + Math.max(height(x.left), height(x.right));
	}

	public static void main(String[] args) {
		int num = 9;
		BST<String, Integer> st = new BST<>();
		String test = "S E A R C H E X A M P L E";
		String[] keys = test.split(" ");
		for (int i = 0; i < keys.length; i++) {
			st.put(keys[i], i);
		}
		System.out.println("size = " + st.size());
		System.out.println("min = " + st.min());
		System.out.println("max = " + st.max());
		System.out.println();

		System.out.println("testing key");
		System.out.println("------------");
		for (String string : st.keys()) {
			System.out.println(string + " " + st.get(string));
		}
		System.out.println();

		System.out.println("Testing select");
		System.out.println("-------------");
		for (int i = 0; i < st.size(); i++) {
			System.out.println(i + " " + st.select(i));
		}
		System.out.println();

		// test rank, floor, ceiling
		System.out.println("key rank floor ceil");
		System.out.println("-------------------");
		for (char c = 'A'; c <= 'Z'; c++) {
			String string = c + "";
			System.out.format("%2s %4d %4s %4s\n", string, st.rank(string), st.floor(string), st.ceiling(string));
		}
	}
}
