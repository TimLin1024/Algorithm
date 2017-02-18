package fundamental.union_find1_5;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

public class WeightedQuickUnion {
	private int[] id;// 父链接数组，由触点索引
	private int[] sz;// (由触点索引的)各个根节点所对应的分量的大小
	private int count;// 连通分量的 数量

	public WeightedQuickUnion(int N) {
		count = N;// 一开始每个节点分属不同的连通分量
		id = new int[N];
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
		}
		sz = new int[N];
		for (int i = 0; i < sz.length; i++) {
			sz[i] = 1;// 每一个连通分量都只有一个元素，因此均为1
		}
	}

	public int count() {
		return count;
	}

	public int find(int p) {
		// 跟随链接找到 根节点
		while (p != id[p]) {
			p = id[p];
		}
		return p;
	}

	public int findCompress(int p) {
		// 跟随链接找到 根节点
		int root = p;
		while (root != id[root]) {
			root = id[root];
		}
		;
		while (p != root) {
			int newP = id[p];
			id[p] = root;
			p = newP;
		}
		return root;
	}

	public void union(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot == qRoot) { // 这里不能改为pRoot != qRoot,然后直接进行 不等 情况下的操作。
								// 因为count--是在不等条件下进行的
			return;
		}
		if (sz[pRoot] > sz[qRoot]) {
			id[qRoot] = pRoot;
			sz[pRoot] = sz[pRoot] + sz[qRoot];
		} else if (sz[pRoot] < sz[qRoot]) {
			id[qRoot] = pRoot;
			sz[qRoot] = sz[pRoot] + sz[qRoot];
		}
		count--;// 连通后，连通分量总数少1
	}

	public static void main(String[] args) {
		int[] ary = In.readInts("medium.txt");
		WeightedQuickUnion weightedQuickUnion = new WeightedQuickUnion(ary[0]);
		for (int i = 1; i < ary.length; i += 2) {
			weightedQuickUnion.union(ary[i],ary[i+1]);
		}
	}
}