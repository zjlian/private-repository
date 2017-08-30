package app;

import template.Graph;

public class CC {
	private boolean[] marked;
	private int[] id;
	private int count;
	
	public CC(Graph G) {
		marked = new boolean[G.V()];
		id = new int[G.V()];
		for(int s = 0; s < G.V(); s++) {
			if(!marked[s]) {
				dfs(G, s);
				++count;
			}
		}
	}
	
	private void dfs(Graph G, int v) {
		marked[v] = true;
		id[v] = count;
		for(int w : G.adj(v)) {
			if(!marked[w]) {
				dfs(G, w);
			}
		}
	}
	//两个顶点是否连通
	public boolean connected(int v, int w) 
	{ return id[v] == id[w]; }
	//返回该顶点所在的连通分量编号
	public int id(int v) 
	{ return id[v]; }
	//返回连通分量的数量
	public int count()
	{ return count; }
}
