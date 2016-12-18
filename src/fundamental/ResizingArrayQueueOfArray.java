package fundamental;

import java.util.Iterator;

import lib.StdIn;
import lib.StdOut;

public class ResizingArrayQueueOfArray<Item> implements Iterable<Item>{
	
	private Item a[];
	private int N = 0;
	
	public ResizingArrayQueueOfArray(int cap) {
		a = (Item[]) new Object[cap]; 
	}
	
	public Item dequeue() {
		return a[--N];
	}
	
	public void enqueue(Item item) {
		a[N++] = item;
	}
	
	public int size() {
		return N;
	}
	
	public boolean isEmpty () {
		return N == 0;
	}
	
	public static void main(String[] args) {
		ResizingArrayQueueOfArray<String> queue = new ResizingArrayQueueOfArray<>(100);
		System.out.println(StdIn.isEmpty());
		while (!StdIn.isEmpty()) {
			queue.enqueue(StdIn.readString());
		}
		queue.enqueue("fixed");
		System.out.println(queue.isEmpty());
		while(!queue.isEmpty()){
			StdOut.print(queue.dequeue() + " ");
		}
		System.out.println("Finish");
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
