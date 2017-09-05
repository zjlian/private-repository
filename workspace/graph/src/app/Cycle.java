package app;

import template.Graph;

/*
 * 检查图是否为无环图(无视平行边和自环)
 * */
public class Cycle {
	private boolean[] marked;
	private boolean hasCycle;
	public Cycle(Graph G) {
		marked = new boolean[G.V()];

	}
	private void dfs(Graph G, int v, int u) {
		marked[v] = true;
		for(int w : G.adj(v)) {
			if(!marked[w]) {
				dfs(G, w, v);
			} else if(w != u) {
				hasCycle = true;
			}
		}
	}
	public boolean hasCycle() {
		return hasCycle;
	}
}
