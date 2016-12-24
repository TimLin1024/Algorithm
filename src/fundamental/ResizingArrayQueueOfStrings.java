package fundamental;

public class ResizingArrayQueueOfStrings {
	
	private String[] ary = new String[1];
	private int N;
	
	public void enqueue(String str) {
		if (N == ary.length) {
			resizingArray(2*ary.length);
		}
		ary[N++] = str;
	}
	public String dequeue() {
		if (N > 0 && N == ary.length/4) {
			resizingArray(ary.length / 2);
		}
		return ary[--N];
	}
	public int size() {
		return N;
	}
	private void resizingArray(int max) {
		System.out.println("resizing ary to " + max);
		String[] tmp = new String[max];
		for (int i = 0; i < N; i++) {
			tmp[i] = ary[i];
		}
		ary = tmp;
	}
	public static void main(String[] args) {
		ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings();
		for (int i = 0; i < 40; i++) {
			queue.enqueue(i+"");
			System.out.println("queue.size() = " + queue.size());
		}
		for (int i = 0; i < 40; i++) {
			queue.dequeue();
		}
	}
}
