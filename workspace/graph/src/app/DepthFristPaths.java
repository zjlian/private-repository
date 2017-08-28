package app;

import template.Graph;
import template.Stack;

//import java.util.Stack;  弱智Stack，迭代器是数组的迭代器


public class DepthFristPaths {
	private boolean[] marked;
	private int[] edgeTo;
	private final int s;
	
	public DepthFristPaths(Graph G, int s) {
		this.s = s;
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		dfs(G, s);
	}
	
	private void dfs(Graph G, int v) {
		marked[v] = true;
		for(int w : G.adj(v)) {
			if(!marked[w]) {
				edgeTo[w] = v;
				dfs(G, w);
			}
		}
	}
	
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	public Iterable<Integer> pathTo(int v) {
		if(!hasPathTo(v)) return null;
		Stack<Integer> tmpPath = new Stack<Integer>();
		//Queue<Integer> path = new LinkedList<Integer>();
		
		for(int x = v; x != s; x = edgeTo[x]) {
			tmpPath.push(x);
		}
		tmpPath.push(s);
		
		return tmpPath;
	}
}
