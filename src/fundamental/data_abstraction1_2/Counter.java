package fundamental.data_abstraction1_2;

import edu.princeton.cs.algs4.StdRandom;

public class Counter {
	private final String name;
	private int count;
	public Counter(String id) {
		name = id;
	}
	public void increment() {
		++count;
	}
	public int tally() {
		return count;
	}
	@Override
	public String toString() {
		return count+ " " + name;
	}
	public static void main(String[] args) {
		int T = 100000;
		Counter head = new Counter("head");
		Counter tail = new Counter("tail");
		for (int i = 0; i < T; i++) {
			if (StdRandom.bernoulli(0.5)) {
				head.increment();
			}else{
				tail.increment();
			}
		}
		System.out.println(head);
		System.out.println(tail);
		System.out.println("delta: " + Math.abs(head.tally() - tail.tally()));
	}
}
