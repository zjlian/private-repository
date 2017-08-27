package template;

import java.util.Iterator;

import std.stdio;

public class Bag<T> implements Iterable<T> {
	private class Node {
		Node(T d, Node n) {
			data = d;
			next = n;
		}
		T data;
		Node next;
	}
	Node head;
	
	public void add(T d) {
		Node oldHead = head;
		head = new Node(d, oldHead);
	}
	
	public Iterator<T> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<T> {
		private Node current = head;

		public boolean hasNext() {
			return current != null;
		}
		public T next() {
			T data = current.data;
			current = current.next;
			return data;
		}
	}
	
	public static void main(String[] args) {
		Bag<String> bag = new Bag<String>();
		
		bag.add("A");
		bag.add("B");
		bag.add("C");
		bag.add("D");
		bag.add("E");
		bag.add("F");
		bag.add("G");
		
		for(String s : bag) {
			stdio.println(s);
		}
	}
	
}
