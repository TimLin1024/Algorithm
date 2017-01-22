package fundamental;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF {
	private int[] id;// ����id���Դ���Ϊ������
	private int count;// ��������

	public UF(int N) {
		// ��ʼ������id����
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

	// ��һ�ַ����� ���ҽ���id[p] �� id[q]��ֵ���ʱ��p��q����ͨ�ġ�
	// ����id[]��ֵ�����ֲ�ͬ�ķ�����ֵͬ������ͬһ����������ͬ�����ڲ�ͬ�ķ���
	public void union(int p, int q) {
		// ��p��q�鲢������ͬ�ķ�����
		int pID = find(p);
		int qID = find(q);
		// ���p��q��ͬһ������֮�У�����Ҫ��ȡ�κ��ж���
		if (pID == qID) {
			return;
		}
		// ��p�ķ���������Ϊq������
		for (int i = 0; i < id.length; i++) {
			if (id[i] == qID) {
				id[i] = pID;
			}
		}
		count--;
	}
	
	//�������ӣ�ÿһ����������Ӧ��id[]Ԫ�� ����ͬһ����������һ���Ĵ�������ƣ�Ҳ�������Լ���
	public int quick_find(int p) {
		//�ҳ�����������
		while (id[p] != p) {
			p = id[p]; 
		}
		return p;
	}

	//
	public void quick_union(int p ,int q) {
		//p��q�ĸ����� �����������ĸ��ڵ㣩
		int pRoot = quick_find(p);
		int qRoot = quick_find(q);
		if (pRoot == qRoot) {
			return;
		}
		id[pRoot] = qRoot;
		
		count--;//���Ǻ�������һ��
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
