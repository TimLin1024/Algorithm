package fundamental;

import java.util.Iterator;
import java.util.Scanner;

import javax.xml.soap.Node;

import org.omg.CORBA.Current;

public class Ex_1_3_12IterableStack<Item> implements Iterable<Item> {

	private Node first = null;
	private int N;// 栈元素数目



	public void push(Item item) {
		Node oldFirst = first;
		first = new Node();// 刚刚忘记要new出一个新节点
		first.item = item;
		first.next = oldFirst;
		N++;
	}

	public Item pop() {
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}

	public int size() {
		return N;
	}

	private class Node {
		Item item;
		Node next;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public static Ex_1_3_12IterableStack<String> copy(Ex_1_3_12IterableStack<String> stack) {
		Ex_1_3_12IterableStack<String> copyStack = new Ex_1_3_12IterableStack<>();
		for(String s : stack){
			copyStack.push(s);
		}
		copyStack.push("copy test");
		return copyStack;
	}

	@Override
	public Iterator<Item> iterator() {

		return new Itr();
	}

	private class Itr implements Iterator<Item> {
		Node current = first;
		@Override
		public boolean hasNext() {
			return current!=null;
		}
		@Override
		public void remove() {
			
			Iterator.super.remove();
		}
		@Override
		public Item next() {
			Item i = current.item;
			current = current.next;
			return i;
		}

	}

	public static void main(String[] args) {
//		Ex_1_3_12IterableStack<String> stack = new Ex_1_3_12IterableStack<>();
//		Scanner scanner = new Scanner(System.in);
//		while (scanner.hasNext()) {
//			String s = scanner.next();
//			if (s != null) {
//				stack.push(s);
//			}
//		}
//		System.out.println("There " + stack.size() + " elements left in stack");
//		while (!stack.isEmpty()) {
//			System.out.println(stack.pop() + " ");
//		}
		Ex_1_3_12IterableStack<String> stack = new Ex_1_3_12IterableStack<>();
		for (int i = 1; i < 5; i++) {
			stack.push("i " + i);
		}
		for(String s1 : stack){
			System.out.println("before copying " + s1);
		}
		Ex_1_3_12IterableStack<String> copy = copy(stack);
		System.out.println("After copying");
		for(String s : copy){
			System.out.println(s);
		}
	}


}
