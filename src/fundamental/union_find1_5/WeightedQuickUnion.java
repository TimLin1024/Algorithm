package fundamental.union_find1_5;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

public class WeightedQuickUnion {
	private int[] id;// ���������飬�ɴ�������
	private int[] sz;// (�ɴ���������)�������ڵ�����Ӧ�ķ����Ĵ�С
	private int count;// ��ͨ������ ����

	public WeightedQuickUnion(int N) {
		count = N;// һ��ʼÿ���ڵ������ͬ����ͨ����
		id = new int[N];
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
		}
		sz = new int[N];
		for (int i = 0; i < sz.length; i++) {
			sz[i] = 1;// ÿһ����ͨ������ֻ��һ��Ԫ�أ���˾�Ϊ1
		}
	}

	public int count() {
		return count;
	}

	public int find(int p) {
		// ���������ҵ� ���ڵ�
		while (p != id[p]) {
			p = id[p];
		}
		return p;
	}

	public int findCompress(int p) {
		// ���������ҵ� ���ڵ�
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
		if (pRoot == qRoot) { // ���ﲻ�ܸ�ΪpRoot != qRoot,Ȼ��ֱ�ӽ��� ���� ����µĲ�����
								// ��Ϊcount--���ڲ��������½��е�
			return;
		}
		if (sz[pRoot] > sz[qRoot]) {
			id[qRoot] = pRoot;
			sz[pRoot] = sz[pRoot] + sz[qRoot];
		} else if (sz[pRoot] < sz[qRoot]) {
			id[qRoot] = pRoot;
			sz[qRoot] = sz[pRoot] + sz[qRoot];
		}
		count--;// ��ͨ����ͨ����������1
	}

	public static void main(String[] args) {
		int[] ary = In.readInts("medium.txt");
		WeightedQuickUnion weightedQuickUnion = new WeightedQuickUnion(ary[0]);
		for (int i = 1; i < ary.length; i += 2) {
			weightedQuickUnion.union(ary[i],ary[i+1]);
		}
	}
}