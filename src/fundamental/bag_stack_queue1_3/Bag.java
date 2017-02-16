package fundamental.bag_stack_queue1_3;

import java.util.Iterator;
import java.util.ListIterator;

import org.omg.CORBA.Current;

public class Bag<Item> implements Iterable<Item> {

	private Node first;
	private int N;

	public void add(Item item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
	}

	private class Node {
		Item item;
		Node next;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return N;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item> {// 不要写成ListIterator<Item>
															// 因为已经有了
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

}
