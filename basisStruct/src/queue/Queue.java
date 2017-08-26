package queue;

import stdio.stdio;

public class Queue<T> {
	private T[] data;
	private int front; //记录队头
	private int rear;  //记录队尾
	
	public Queue(int SIZEMAX) {
		data = (T[]) new Object[SIZEMAX];
		front = 0;
		rear = 0;
	}
	
	public int length() {
		return (rear - front + data.length) % data.length;
	}
	public boolean enqueue(T item) {
		if((rear + 1) % data.length == front) 
			return false;
		
		data[rear] = (T) new Object();
		data[rear] = item;
		rear = (rear + 1) % data.length;
		
		return true;
	}
	public T dequeue() {
		if(front == rear)
			throw new IndexOutOfBoundsException("队列是空的");  
		
		T tmp = data[front];
		front = (front + 1) % data.length; 
		return tmp;
	}
	
	public boolean isEmpty() {
		return front == rear;
	}
	
	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>(20);
		for(int f = 0, g = 1, i = 0; i < 20; i++) {
			q.enqueue(f);
			f = f + g;  // 1 1 2 3 5
			g = f - g;  // 0 1 1 2 5
		}
		stdio.println(q.dequeue());
		stdio.println(q.dequeue());
		stdio.println(q.dequeue());
		q.enqueue(-1);
		q.enqueue(-1);
		q.enqueue(-1);
		q.enqueue(-1);
		
		int[] a = stdio.readInts();
		stdio.println(a);
	}

}
