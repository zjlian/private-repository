package app;

import stdio.stdio;

public abstract class UF {
	protected int count;
	protected int[] id;
	
	public UF(int N) {
		id = new int[N];
		count = N;
		for(int i = 0; i < N; i++) {
			id[i] = i;
		}
	}

	public abstract void union(int p, int q);
	public abstract int find(int p);
	
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	public int count() { return count; }
	public String toString() {
		String s = "";
		for(int i = 0; i < id.length; i++)
			s += id[i] + " ";
		
		stdio.println(s);
		return s;
	}
	
}
