package fundamental;
import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item>{

	private Item[] a = (Item[])new Object[1];
	private int N = 0;
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public void push(Item item) {
		if (N == a.length) {
			resize(a.length * 2);
		}
		a[N++] = item;
	}
	
	public Item pop() {
		Item item = a[--N];
		a[N] = null;
		if (N > 0 && N == a.length/4) {
			resize(a.length/2);
		}
		return item;
	}
	
	private void resize(int cap) {
		Item[] tmp =(Item[]) new Object[cap];
		for(int i = 0; i < N; i++){
			tmp[i] = a[i];
		}
		a = tmp;
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator<Item> implements Iterator<Item>{
		private int i = N;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i > 0;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			return (Item) a[--i];
		}
		
		public void remove(){
			
		}
	}
}
