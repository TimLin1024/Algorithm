package fundamental;
import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;




public class Stack <Item> implements Iterable<Item>{

	private Node first = null;
	private int N;
	private class Node {
		Item item;
		Node next;
	}
	public boolean isEmpty(){
		return first == null;
	}
	public int size() {
		return N;
	}
	public void push(Item item) {
		Node oldFist = first;
		first = new Node();
		first.item = item;
		first.next = oldFist;
		N++;
	}
	public Item pop() {
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	public Item peek() {
		return first.item;
	}
	
	@Override
	public Iterator<Item> iterator() {
		return null;
	}
	
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			if (!s.equals("-")) {
				stack.push(s);
			}else if (!s.isEmpty()) {
				StdOut.print(stack.pop() + " ");
			}
		}
		StdOut.println("(" + stack.size() + " left on stack)");
	}
}
