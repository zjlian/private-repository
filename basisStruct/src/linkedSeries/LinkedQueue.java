package linkedSeries;

public class LinkedQueue<T> {
	private class Node {
		T data;
		Node next;
	}
	private Node front, end;
	private int len;
	
	public LinkedQueue() {
		front = end = new Node();
		front.next = null;
		len = 0;
	}
	
	public boolean isEmply() {
		return len == 0;
	}
	
	public void enqueue(T item) {
		Node tmpNode = new Node();
		tmpNode.data = item;
		
		end.next = tmpNode;
		end = tmpNode;
		
		len++;
	}
	public T dequeue() {
		T Elem = front.next.data;
		front.next = front.next.next;
		
		return Elem;
	}
	
	public static void main(String[] args) {
		LinkedQueue<String> s = new LinkedQueue<String>();
		
		s.enqueue("test");
		s.enqueue("teet");
		s.enqueue("tsst");
		s.enqueue("tttt");
		s.dequeue();
		

	}

}
