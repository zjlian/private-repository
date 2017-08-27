package template;
import stdio.stdio;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
	private Key[] keys;
	private Value[] vals;
	private int N;
	
	public BinarySearchST(int capacity) {
		keys = (Key[]) new Comparable[capacity];
		vals = (Value[]) new Object[capacity];
	}
	
	public int size() {
		return N;
	}
	public boolean empty() {
		return N == 0;
	}
	
	private int rank(Key key) {
		int lo = 0, hi = N - 1;
		while(lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(keys[mid]);
			
			if     (cmp > 0) lo = mid + 1;
			else if(cmp < 0) hi = mid - 1;
			else return mid;
		}
		return lo;
	}
	private void expansion() {
		if(!(N > keys.length/2)) return;
		
		Key[] keysTmp = (Key[]) new Comparable[keys.length*2];
		Value[] valsTmp = (Value[]) new Object[keys.length*2];
		
		for(int i = 0; i < N; ++i) {
			keysTmp[i] = keys[i];
			valsTmp[i] = vals[i];
		}
		keys = keysTmp;
		vals = valsTmp;
	}
	
	public Value get(Key key) {
		if(empty()) return null;
		int i = rank(key);
		if(i < N && keys[i].compareTo(key) == 0)
			return vals[i];
		else return null;
	}
	public void put(Key key, Value val) {
		if(N > keys.length/2) expansion();
		
		int i = rank(key);
		if(i < N && keys[i].compareTo(key) == 0) {
			vals[i] = val;  return;
		}
		for(int j = N; j > i; j--) {
			vals[j] = vals[j-1];
			keys[j] = keys[j-1];
		}
		keys[i] = key;
		vals[i] = val;
		N++;
	}
	
	public static void main(String[] args) {
		BinarySearchST<String, Double> st = new BinarySearchST<String, Double>(10);
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
		
		String rank;
		//double gpa = 0;
		Double sum = 0.0;
		int count = 0;
		while(!stdio.isEmpty()) {
			rank = stdio.readString();
			
			if(rank.equals("next")) {
				stdio.print("\n-----------------------------------\n");
				stdio.println("GPA is " + sum / count);
				sum = 0.0; count = 0;
				continue;
			}
			
			sum += st.get(rank);
			++count;
		}
	}
}
