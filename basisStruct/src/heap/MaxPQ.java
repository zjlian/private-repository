package heap;

public class MaxPQ<T extends Comparable<T>> {
	private T[] pq;
	private int N = 0;
	
	/*操作方法的辅助方法的辅助方法*/
	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}
	private void swap(int i, int j) {
		T tmp = pq[i];
		pq[i] = pq[j];
		pq[j] = tmp;
	}
	
	/*信息获取方法*/
	public MaxPQ(int maxN) {
		pq = (T[]) new Comparable[maxN];
	}
	public boolean isEmpty() {
		return N == 0;
	}
	public int size() {
		return N;
	}
	
	/*操作方法的辅助方法*/
	private void swim(int k) {
		while(k > 1 && less(k/2, k)) {
			swap(k/2, k);
			k = k/2;
		}
	}
	private void sink(int k) {
		while(k*2 <= N) {
			int j = k*2;
			if(j < N && less(j, j+1)) j++;
			if(!less(k, j)) break;
			swap(k, j);
			k = j;
		}
	}
	
	/*操作方法*/
	public void insert(T e) {
		pq[++N] = e;
		swim(N);
	}
	public T delMax() {
		T max = pq[N--];
		pq[N+1] = null;
		sink(1);
		return max;
	}
	
	public static void main(String[] args) {

	}

}
