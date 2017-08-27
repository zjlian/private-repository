package app;
import stdio.stdio;
import tool.Stopwatch;

public class PathCompressionWQU{
	private int count;
	private int[] size;
	private int[] id;
	
	public PathCompressionWQU(int N) {
		id = new int[N];
		size = new int[N];
		for(int i = 0; i < N; i++) {
			id[i] = i;
			size[i] = 1;
		}
		count = N;
	}
	public void union(int p, int q) {
		int i = find(p), 
			j = find(q);
		if(i == j) return ;
		if(size[i] < size[j]) {
			id[i] = j;
			size[j] += size[i];
		} else {
			id[j] = i;
			size[i] += size[j];
		}
		count--;
	}
	
	public int find(int p) {
		validate(p);
		int root = p;
		while(id[root] != root)
			root = id[root];
		while(root != id[p]) {
			int curp = p;
			p = id[p];
			id[curp] = root;
		}
		return root;
	}
	
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	public int count() { return count; }
	
	private void validate(int p) {
        int n = id.length;
        if (p < 0 || p >= n) {
            throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + (n-1));  
        }
    }

	public static void main(String[] args) {
		int n = stdio.readInt();
		Stopwatch shit = new Stopwatch();
		PathCompressionWQU uf = new PathCompressionWQU(n);
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
