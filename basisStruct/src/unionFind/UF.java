package unionFind;

import stdio.StdIn;
import stdio.StdOut;
import stdio.stdio;

public class UF {
	private int[] id;
	private int count;
	
	public UF(int n) {
		count = n;
		id = new int[n];
		for(int i = 0; i < n; i++)
			id[i] = i;
	}
	
	public int count() { return count; }
	
	public int find(int p) {
		while(p != id[p])
			p = id[p];
		return p;
	}
	public void union(int p, int q) {
		int pRoot = find(p),
			qRoot = find(q);
		if(pRoot == qRoot) return;
		
		id[pRoot] = qRoot;
		count--;
		
	}
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public static void main(String[] args) {
		int n = stdio.readInt();
		UF uf = new UF(n);
		while (StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
		stdio.println(uf.count + " 个分分量");

	}

}
