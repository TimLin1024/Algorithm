package fundamental;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF {
	private int[] id;// 分量id（以触点为索引）
	private int count;// 分量数量

	public UF(int N) {
		// 初始化分量id数组
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}

	public int count() {
		return count;
	}

	public boolean connected(int p, int q) {
		return find(q) == find(p);
	}

	public int find(int p) {
		return id[p];
	}

	// 第一种方法， 当且仅当id[p] 与 id[q]的值相等时，p和q是连通的。
	// 即以id[]的值来区分不同的分量。值同就属于同一个分量，不同就属于不同的分量
	public void union(int p, int q) {
		// 将p和q归并到到相同的分量中
		int pID = find(p);
		int qID = find(q);
		// 如果p和q在同一个分量之中，则不需要采取任何行动。
		if (pID == qID) {
			return;
		}
		// 将p的分量重命名为q的名称
		for (int i = 0; i < id.length; i++) {
			if (id[i] == qID) {
				id[i] = pID;
			}
		}
		count--;
	}
	
	//建立链接，每一个触点所对应的id[]元素 都是同一个分量中另一个的触点的名称（也可能是自己）
	public int quick_find(int p) {
		//找出分量的名称
		while (id[p] != p) {
			p = id[p]; 
		}
		return p;
	}

	//
	public void quick_union(int p ,int q) {
		//p和q的根触点 （类似于树的根节点）
		int pRoot = quick_find(p);
		int qRoot = quick_find(q);
		if (pRoot == qRoot) {
			return;
		}
		id[pRoot] = qRoot;
		
		count--;//老是忽略了这一点
	}

	public static void main(String[] args) {
		int N = StdIn.readInt();
		UF uf = new UF(N);
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (uf.connected(p, q)) {
				StdOut.println(p + " " + q);
			}
		}
		StdOut.println(uf.count() + "components");
	}
}
