package app;
import stdio.stdio;

public class TwodList {
	private long[] data;
	private int len;
	
	public TwodList(int size) {
		data = new long[size];
		len = 0;
	}
	public void push(long item) {
		data[len++] = item;
	}
	public boolean find(long k) {
		return rank(k,data) != -1;
	}
	private int rank(long key, long[] arr) {
		int i = 0;
		for( ; i < len; i++) 
			if(arr[i] == key) 
				return i;
		return -1;
	}
	public int getLen() {
		return len;
	}
	public static void main(String[] args) {
		int m, n, a, b;
		m = stdio.readInt();
		n = stdio.readInt();
		a = stdio.readInt();
		b = stdio.readInt();
		
		TwodList list = new TwodList(m*n);
		for(int i = 0, h = b, v = a; i < m*n; i++, h++) {
			if(h == b + m) { h = b; v++; stdio.println();}
			long tmp = (long) Math.pow(v, h);
			stdio.printf("%4d ", tmp);
			if(!list.find(tmp)) {
				list.push(tmp);
				stdio.print("?");
			}
		}
		stdio.println("\n" + list.getLen());
	}

}
