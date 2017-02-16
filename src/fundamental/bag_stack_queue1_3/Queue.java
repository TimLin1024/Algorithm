package fundamental.bag_stack_queue1_3;

import java.util.Iterator;


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
		} else {
			oldLast.next = last;
		}
		N++;// �������Ƕ�N���в���
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

	public int size() {
		return N;
	}

	@Override
	public Iterator<Item> iterator() {
		return new Itr();
	}
	
	private class Itr implements Iterator<Item>{
		Node current = first;
		@Override
		public boolean hasNext() {
			
			return current != null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
		
	}
	
	public static void main(String[] args) {
		Queue<String> queue = new Queue<>();
		while (!StdIn.isEmpty()) {
			String string = StdIn.readString();
			if (!string.equals("-")) {
				queue.enqueue(string);
			} else if (!queue.isEmpty()) {
				StdOut.println(queue.dequeue() + " ");
			}
		}
		StdOut.println("(" + queue.size() + " left in the queue.)");
	}

}
