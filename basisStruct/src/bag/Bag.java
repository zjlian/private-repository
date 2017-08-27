package bag;

import stdio.stdio;

public class Bag<T> {
	private T[] data;
	private int n;
	
	/*
	private Node<T> first;
	private int n;
	private static class Node<T> {
		private T data;
		private Node<T> next;
	}*/
	
	public Bag(int SIZEMAX) {
		data = (T[]) new Object[SIZEMAX];
		n = 0;
	}
	
	public int size() {
		return this.n;
	}
	
	public void add(T item) {
		data[n++] =  (T) new Object();
	}
	
	public boolean isEmpty() {
		return n == 0;
	}
	
	public static void main(String[] ages) {
		Bag<Integer> b = new Bag<Integer>(20);
		b.add(2);
		stdio.println(b.size());
	}
	
}









