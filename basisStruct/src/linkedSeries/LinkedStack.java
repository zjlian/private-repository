package linkedSeries;


import stdio.stdio;

public class LinkedStack<T> {
	private class Node {
		T data;
		Node next;
	}
	private Node top; 
	private int len; 

	public LinkedStack() {
		top = new Node();
		top.next = null;
		len = 0;
	}
	
	public boolean isEmpty() {
		return len == 0;
	}
	public void push(T item) {
		Node tmpNode = new Node();
		
		tmpNode.data = item;
		tmpNode.next = top;
		top = tmpNode;
		
		len++;
	}
	public T pop() {
		if(len == 0) 
			throw new IndexOutOfBoundsException("栈已空");
		
		T Elem = top.data;
		top = top.next;
		len--;
		return Elem;
	}
	public T peek() {
		if(len == 0) 
			throw new IndexOutOfBoundsException("栈已空");
		
		return top.data;
	}
	public static void main(String[] args) {
		LinkedStack<String> ops = new LinkedStack<String>();
		LinkedStack<Double> vals = new LinkedStack<Double>();
		
		String str = stdio.readLine();
		
		String[] tmp = str.split("\\s+");
		
		for(int i = 0; i < tmp.length; i++) {
			String s = tmp[i];
			if(s.equals("("));
			else if(s.equals("+")) ops.push(s);
			else if(s.equals("-")) ops.push(s);
			else if(s.equals("*")) ops.push(s);
			else if(s.equals("/")) ops.push(s);
			else if(s.equals("sqrt")) ops.push(s);
			else if(s.equals(")")) {
				String op = ops.pop();
				double v = vals.pop();
				if(op.equals("+")) v = vals.pop() + v;
				else if(op.equals("-")) v = vals.pop() - v;
				else if(op.equals("*")) v = vals.pop() * v;
				else if(op.equals("/")) v = vals.pop() / v;
				else if(op.equals("sqrt")) v = Math.sqrt(v);
				vals.push(v);
			}
			else
				vals.push(Double.parseDouble(s));
		}
		
		stdio.println(vals.pop());

	}

}
