package stack;
import java.util.Iterator;

import stdio.stdio;

public class Stack<T> {
	private T data[];
	private int top;
	
	public Stack(int MAXSIZE) {
		data = (T[]) new Object[MAXSIZE];
		top = -1;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	public void push(T item){
		if(top == data.length)
			throw new IndexOutOfBoundsException("栈已满");
		
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
		public boolean hasNext() { return i > 0; }
		public T next() { return data[--i]; }
		public void remove() {}
	}
	
	public static void main(String[] args) {
		Stack<String> s = new Stack<String>(50);
		String str = stdio.readString();
		stdio.println(str.charAt(2));
	}

}
