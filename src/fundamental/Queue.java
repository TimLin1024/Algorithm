package fundamental;
import java.util.Iterator;

import javax.lang.model.element.Element;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;



public class Queue<Item> implements Iterable<Item> {

	private Node first;
	private Node last;
	private int N;

	private class Node {
		Item item;
		Node next;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void enqueue(Item item) {
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) {
			first = last;
		}else {
			oldLast.next = last;
		}
		N++;//老是忘记对N进行操作
	}
	
	public Item dequeue() {
		Item item = first.item;
		first = first.next;
		if (isEmpty()) {
			last = null;
		}
		N--;
		return item;
	}
	public int size(){
		return N;
	}
	@Override public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		Queue<String> queue = new Queue<>();
		while (!StdIn.isEmpty()) {
			String string = StdIn.readString();
			if (!string.equals("-")) {
				queue.enqueue(string);
			}else if (!queue.isEmpty()) {
				StdOut.println( queue.dequeue() + " ");
			}
		}
		StdOut.println("(" + queue.size() + " left in the queue.)");
	}

}
