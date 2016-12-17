

public class FixedCapacityStackOfString {
	private String [] a;
	private int N;
	
	public FixedCapacityStackOfString(int cap) {
		a = new String[cap];
	}
	public void push(String item) {
		a[N++] = item;
	}
	public String pop(){
		if (!isEmpty()) {
			return a[--N];
		}
		return null;
	}
	public boolean isEmpty(){
		 return N == 0;
	}
	
	public int size(){
		return N;
	}
	
	public boolean isFull(){
		return N == a.length;
	}
	
	public static void main(String[] args) {
		FixedCapacityStackOfString s = new FixedCapacityStackOfString(100);
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-")) {
				s.push(item);
			}else {
				StdOut.print(s.pop() + " ");
			}
		}
		StdOut.println("(" + s.size() + "left on stack)");
	}
	
	
}
