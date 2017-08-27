package app;
import stdio.stdio;
import tool.Stopwatch;

public class QuickUnionUF extends UF {
	
	public QuickUnionUF(int N) {
		super(N);
	}
	@Override
	public void union(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		
		if(pRoot == qRoot) return;
		
		id[pRoot] = qRoot;
		count--;
	}
	@Override
	public int find(int p) {
		while(id[p] != p)
			p = id[p];
		return p;
	}

	public static void main(String[] args) {
		int n = stdio.readInt();
		Stopwatch shit = new Stopwatch();
		QuickUnionUF uf = new QuickUnionUF(n);
		while(!stdio.isEmpty()) {
			int p = stdio.readInt();
			int q = stdio.readInt();
			if(uf.connected(p, q)) continue;
			uf.union(p, q);
			stdio.println("链接了 " + p + " " + q);
			uf.toString();
		}
		long enjoy = shit.eatShit();
		stdio.println("共有 " + uf.count() + " 个分量");
		
		stdio.println("\n--====================================--\n Process exited after " + enjoy + " millis");
	}
}
