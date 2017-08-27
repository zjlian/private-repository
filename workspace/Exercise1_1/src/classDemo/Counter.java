package classDemo;

import mylib.StdOut;

public class Counter {
	private final String name;
	private int count = -1;
	public Counter(String S) {
		name = S;
		count = 0;
	}
	public void increment() {
		count++;
	}
	public int tally() {
		return count;
	}
	public String toString() {
		//System.out.println(name + '@' + count);
		return (name + '@' + count);
	}
	
	public static void main(String[] ages) {
		Counter headr = new Counter("headr");
		headr.increment();
		StdOut.println(headr.tally());
		headr.toString();
	}
	
}