package template;

public class WeightedUnionFind {
	private int count;	//记录连通分量
	private int[] id;	//以数组下标作为顶点，记录顶点的父顶点
	private int[] size; //记录顶点的子顶点数量
	
	public WeightedUnionFind(int N) {
		id = new int[N];
		size = new int[N];
		count = N;
		for(int i = 0; i < N; i++) {
			id[i] = i;
			size[i] = 1;
		}
	}
	public int find(int p) {
		while(id[p] != p) {
			p = id[p];
		}
		return p;
	}
	public void nuion(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		if(pRoot == qRoot) {
			return;
		}
		if(size[pRoot] < size[qRoot]) {
			id[pRoot] = qRoot;
			size[qRoot] += size[pRoot];
		} else {
			id[qRoot] = pRoot;
			size[pRoot] += size[qRoot];
		}
		count--;
	}
	
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	public int count() 
	{ return count; }
	public String toString() {
		String s = "";
		for(int i = 0; i < id.length; i++) {
			s += id[i] + " ";
		}
		return s;
	}
}
