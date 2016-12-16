import java.util.Iterator;
import java.util.ListIterator;

import org.omg.CORBA.Current;


public class Bag<Item> implements Iterable<Item>{
	
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

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}
	private class ListIterator implements Iterator<Item> {//��Ҫд��ListIterator<Item> ��Ϊ�Ѿ�����
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
		public boolean isEmpty(){
			return first == null;
		}
		public int size() {
			return N;
		}
		
	}
	
}
