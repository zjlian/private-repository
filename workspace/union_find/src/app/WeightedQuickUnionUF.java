package app;
import stdio.stdio;
import tool.Stopwatch;
public class WeightedQuickUnionUF extends UF{
	private int[] size;
	public WeightedQuickUnionUF(int N) {
		super(N);
		size = new int[N];
		for(int i = 0; i < N; i++)
			size[i] = 1;
	}
	@Override
	public void union(int p, int q) {
		int pr = find(p);
		int qr = find(q);
		if(pr == qr) return;
		if(size[pr] < size[qr]) {
			id[pr] = qr;
			size[qr] += size[pr];
		} else {
			id[qr] = pr;
			size[pr] += size[qr];
		}
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
		WeightedQuickUnionUF uf = new WeightedQuickUnionUF(n);
		while(!stdio.isEmpty()) {
			int p = stdio.readInt();
			int q = stdio.readInt();
			if(uf.connected(p, q)) continue;
			uf.union(p, q);
			stdio.println("链接了 " + p + " " + q);
		}
		long enjoy = shit.eatShit();
		stdio.println("共有 " + uf.count() + " 个分量");
		stdio.println("\n--====================================--\n Process exited after " + enjoy + " millis");


	}

	

}
