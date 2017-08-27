package ST;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
	private Key[] keys;
	private Value[] vals;
	private int N;
	
	public BinarySearchST(int capacity) {
		keys = (Key[]) new Comparable[capacity];
		vals = (Value[]) new Object[capacity];
	}
	
	private boolean isEmpty() {
		return N == 0;
	}
	private Key keyMax() {
		if(N == 0) return null;
		return keys[N-1];
	}
	
	private void expansion() {
		if(N > keys.length / 2){  //扩容
			Key[] tmpKeys = (Key[]) new Comparable[keys.length*2];
			Value[] tmpVals = (Value[]) new Object[keys.length*2];
			
			for(int i = 0; i < keys.length; i++) {
				tmpKeys[i] = keys[i];
				tmpVals[i] = vals[i];
			}
			keys = tmpKeys;
			vals = tmpVals;
		}
	}
	
	private int rank(Key key) {
		int lo = 0, hi = N - 1;
		while(lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo( keys[mid] );
			if(cmp < 0) hi = mid - 1;
			else if(cmp > 0) lo = mid + 1;
			else return mid;
		}
		return lo;
	}
	
	public Value get(Key key) {
		if(isEmpty()) return null;
		int i = rank(key);
		if(i < N && keys[i].compareTo(key) == 0)
			return vals[i];
		else
			return null;
	}
	public void put(Key key, Value val) {
		expansion();
		/*if(N > 0 && key.compareTo(keyMax()) > 0) {  //如果要插入的key大于当前集中最大的key时，直接插在数组末尾
			keys[N] = key;
			vals[N++] = val;
			return;
		};*/
		int i = rank(key);
		if(i < N && keys[i].compareTo(key) == 0) {  //当找到
			vals[i] = val;
			return;
		}
		for(int j = N; j > i; j--) {
			keys[j] = keys[j-1];
			vals[j] = vals[j-1];
		}
		keys[i] = key;
		vals[i] = val;
		N++;
	}
	
	public boolean contains(Key key) {
		return get(key) != null;
		
	}
	
	public void delete(Key key) {
		if(!contains(key)) return;  //表中不存在key，退出
		int i = rank(key);
		if(i < N && keys[i].compareTo(key) == 0) {
			for(int j = i; i < N; i++) {
				keys[j] = keys[j+1];
				vals[j] = vals[j+1];
			}
			N--;
		}
	}
	
	
	public Iterable<Key> keys(Key lo, Key hi) { //获取可迭代循环的元素队列
		Queue<Key> queue = new LinkedList<Key>();
		int high = rank(hi);
		for(int i = rank(lo); i < high; i++)
			queue.add(keys[i]);
		if(contains(hi))
			queue.add(keys[high]);
		return queue;
	}
	public Iterable<Key> keys() {
		return keys(keys[0], keys[N-1]);
	}
	
	public static void main(String[] args) {
		BinarySearchST<String, Double> st = new BinarySearchST<String, Double>(23);
		st.put("A+", 4.33);
		st.put("A", 4.00);
		st.put("A-", 3.67);
		st.put("B+", 3.33);
		st.put("B", 3.00);
		st.put("B-", 2.67);
		st.put("C+", 2.33);
		st.put("C", 2.00);
		st.put("C-", 1.67);
		st.put("D", 1.00);
		st.put("F", 0.00);
		
		Iterable<String> que = st.keys();
		st.delete("F");
		
	}
}
