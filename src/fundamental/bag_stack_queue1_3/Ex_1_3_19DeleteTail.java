package fundamental.bag_stack_queue1_3;

import java.awt.event.ItemEvent;
import java.util.LinkedList;

import javax.xml.soap.Node;

public class Ex_1_3_19DeleteTail<Item> {
	Node first;
	private class Node {
		Node next;
		Item item;
	}
	
	public void deleteTail() {
		Node cursor = first;
		Node pre = first;
		while(cursor.next != null){
			pre = cursor;
			cursor = cursor.next;
		}
		pre.next = null;
	}
	public void deleteWithIndex(int k) {
		int count = 0 ;
		Node cur = first;
		Node pre = first;
		while (count != k) {
			++count;
		}
	}
	public static void main(String[] args) {
//		Node linkedList = new Node();
		
	}
//	public boolean find(LinkedList list, String k) {
//		
//	}
}
