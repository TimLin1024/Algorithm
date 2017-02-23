package sorting.priority_queue2_4;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.Transaction;

//һ�����ȶ��е�����
public class TopM {
	public static void main(String[] args) {
		// ��ӡ������������M��
		int M = Integer.parseInt(args[0]);
		MinPQ<Transaction> pq = new MinPQ<>(M + 1);
		while (StdIn.hasNextLine()) {
			pq.insert(new Transaction(StdIn.readLine()));
			if (pq.size() > M) {
				pq.delMin();//������ȶ����д���M+1��Ԫ����ɾ��������С��Ԫ��
			}
		}
		Stack<Transaction> stack = new Stack<>();
		while (!pq.isEmpty()) {
			stack.push(pq.delMin());
		}
		for(Transaction t : stack){
			System.out.println(t);
		}
	}
}
