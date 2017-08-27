package queue;

public class MaxQueue<T extends Comparable<T>>{
	private T[] data;
	private int count;
	private int maxSize;
	
	/*辅助方法*/
	private boolean less(int v, int w) {
		return data[v].compareTo(data[w]) < 0;
	}
	private void swap(int v, int w) {
		T tmp = data[v];
		data[v] = data[w];
		data[w] = tmp;
	}
	
	/*优先队列基本方法*/
	public MaxQueue(int MAXSIZE) {
		data =  (T[])new Comparable[MAXSIZE + 1];
		count = 0;
		maxSize = MAXSIZE;
	}
	public MaxQueue() {
		this(11);
	}
	public MaxQueue(T[] a) {
		this(a.length + 1);
		int len = a.length;
		insert(a[0]);
		while(len --> 1) { //233
			insert(a[len]);
		}
	}
	
	public void insert(T v) {
		data[++count] = v;
		swim(count);
	}
	public T max() {
		return data[1];
	}
	public T delMax() {
		T max = data[1];
		
		swap(1,count--);
		data[count + 1] = null;
		sink(1);
		
		return max;
	}
	public boolean isEmpty() {
		return count == 0;
	}
	public int size() {
		return count;
	}
	
	/*辅助方法，二叉堆*/
	private void swim(int k) {  //上浮
		while(k > 1 && less(k/2, k)) {
			swap(k/2, k);
			k = k / 2;
		}
	}
	private void sink(int k) { //下沉
		while(k*2 <= count) {
			int p = k * 2;
			if(p < count && less(p, p+1))  p++;
			if(!less(k, p))  break;
			swap(k,p);
			k = p;
		}
	}

	public static void main(String[] args) {
		Integer[] arr = {2,6,8,4,3,4,5,2,10,6,0};
		MaxQueue<Integer> que = new MaxQueue<Integer>(arr);
		
		for(int len = que.size(), i = 0; len > 0; len--) {
			arr[i] = que.delMax();
			System.out.printf("%d ", arr[i]);
		}
		
	}

}
