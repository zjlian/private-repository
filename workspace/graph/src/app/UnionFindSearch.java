package app;

import template.Graph;
import template.WeightedUnionFind;

public class UnionFindSearch {
	private WeightedUnionFind UF;
	private final int s;
	
	public UnionFindSearch(Graph G, int s) {
		UF = new WeightedUnionFind(G.V());
		this.s = s;
		for(int v = 0; v < G.V(); v++) {
			for(int w : G.adj(v)) {
				UF.nuion(v, w);
			}
		}
	}
	public int count() {
		//TODO
		return UF.count();
	}
	public boolean marked(int v) {
		return UF.find(s) == UF.find(v);
	}
}
