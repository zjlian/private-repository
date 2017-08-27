package heap;

import stdio.stdio;

public class HeapOnList<T extends Comparable<T>> {
	private T[] data;
	private int N = 0;
	
	private boolean less(int i, int j) {
		return data[i].compareTo(data[j]) < 0;
	}
	private void swap(int i, int j) {
		T tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}
	public HeapOnList(int maxN) {
		maxN = maxN <= 3 ? 3 : maxN;
		data  = (T[])new Comparable[maxN + 1];
	}
	public boolean isEmpty() {
		return N == 0;
	}
	public void adapt() {
		if(N < (data.length / 4 * 3)) return;
		
		T[] tmp = (T[])new Comparable[data.length * 2];
		for(int i = 0; i <= N; i++)
			tmp[i] = data[i];
		
		data = tmp;
	}
	
	private void swim(int k) {
		while(k > 1 && less(k/2, k)) {
			swap(k/2, k);
			k = k/2;
		}
	}
	private void sink(int k) {
		while(k*2 <= N) {
			int j = k * 2;
			if(j < N && less(j, j+1)) j++;
			if(!less(k, j)) break;
			swap(k, j);
			k = j;
		}
	}
	public void push(T e) {
		data[++N] = e;
		adapt();
		swim(N);
	}
	public T pop() {
		T tmp = data[1];
		swap(1, N--);
		data[N+1] = null;
		sink(1);
		
		return tmp;
	}
	public int length() {
		return N;
	}
	
	public static void main(String[] args) {
		HeapOnList<String> pq = new HeapOnList<String>(10);
		pq.push("F");
		pq.push("A");
		pq.push("N");
		pq.push("E");
		pq.push("D");
		pq.push("L");
		pq.push("J");
		pq.push("M");
		pq.push("H");
		pq.push("I");
		pq.push("G");
		pq.push("K");
		pq.push("B");
		pq.push("C");
		int len = pq.length();
		for(int i = 1; i <= len; i++) {
			stdio.print(pq.pop());
		}
		
	}
	
}
