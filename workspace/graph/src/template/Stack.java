package template;
import java.util.Iterator;

import std.stdio;

public class Stack<T> implements Iterable<T>{
	private final int DEFAUTO_MAXSIZE = 2;
	private T[] data;
	private int top;
	
	public Stack() {
		data = (T[]) new Object[DEFAUTO_MAXSIZE];
		top = -1;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	public void push(T item){
		if(length() == data.length)
			data = resize();
		
		top++;
		//data[top] = (T) new Object();
		data[top] = item;
	}
	public T pop() {
		if(this.isEmpty()) {
			throw new IndexOutOfBoundsException("栈已空");
		}
		T tmp = data[top];
		top--;
		return tmp;
	}
	public T peek() {
		if(this.isEmpty()) {
			throw new IndexOutOfBoundsException("栈已空");
		}
		return data[top];
	}
	public int length() {
		return top + 1;
	}
	
	public Iterator<T> iterator() {
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<T> {
		private int i = top;
		public boolean hasNext() { return i > -1; }
		public T next() { return data[i--]; }
		public void remove() {}
	}
	
	private T[] resize() {
		T[] newData = (T[]) new Object[data.length * 2];
		for(int i = 0; i < data.length; i++) {
			newData[i] = data[i];
		}
		return newData;
	}
	public static void main(String[] args) {
		Stack<String> s = new Stack<String>();
		//String str = stdio.readString();
		//stdio.println(str.charAt(2));
		s.push("1");
		s.push("2");
		s.push("3");
		s.push("4");
		s.push("5");
		
		for(String p : s) {
			stdio.println(p);
		}
	}

}
