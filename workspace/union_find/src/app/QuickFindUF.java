package app;
import tool.Stopwatch;
import stdio.stdio;

public class QuickFindUF extends UF {

	public QuickFindUF(int N) {
		super(N);
	}
	@Override
	public int find(int p) {
		return id[p];
	}
	@Override
	public void union(int p, int q) {
		int pID = find(p);
		int qID = find(q);
		if(qID == pID) return;
		for(int i = 0; i < id.length; i++) {
			if(id[i] == pID)
				id[i] = qID;
		}
		count--;
	}
	
	public static void main(String[] args) {
		int n = stdio.readInt();
		Stopwatch shit = new Stopwatch();
		QuickFindUF uf = new QuickFindUF(n);
		while(!stdio.isEmpty()) {
			int p = stdio.readInt();
			int q = stdio.readInt();
			if(uf.connected(p, q)) continue;
			uf.union(p, q);
			stdio.println("链接了 " + p + " " + q);
		}
		long enjoy = shit.eatShit();
		stdio.println("共有 " + uf.count() + " 个分量\n");
		uf.toString();
		stdio.println("\n--====================================--\n Process exited after " + enjoy + " millis");
	}
}
