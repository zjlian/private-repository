package template;
import std.In;
import std.stdio;
import template.Bag;

public class Graph {
	private final int V;	//顶点数目
	private int E;			//边的数目
	private Bag<Integer>[] adj;	//邻接表
	
	public Graph(int V) {
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for(int i = 0; i < V; i++) {
			adj[i] = new Bag<Integer>();
		}
	}
	public Graph(In in) {
		this(in.readInt());
		int E = in.readInt();
		for(int i = 0; i < E; i++) {
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v, w);
		}
	}
	public Graph(Graph g) {
		Graph copy = g.clone();
		this.V = copy.V;
		this.E = copy.E;
		this.adj = copy.adj;
	}
	public int V() { return V; }
	public int E() { return E; }

	public void addEdge(int v, int w) {
		if(v == w) return;
		for(int t : adj(v)) {
			if(t == w) {
				return;
			}
		}
		adj[v].add(w);
		adj[w].add(v);
		++E;
	}
	public boolean hasEdge(int v, int w) {
		for(int t : adj(v)) {
			if(t == w) {
				return true;
			}
		}
		return false;
	}
	public Iterable<Integer> adj(int v) 
	{ return adj[v]; }
	
	public Graph clone() {
		Graph copy = new Graph(this.V);
		copy.E = this.E;
		for(int v = 0; v < this.V; v++) {
			for(int w : this.adj(v)) {
				copy.adj[v].add(w);
			}
		}
		return copy;
	}
	
	public String toString() {
		String s = V + " vertices, " + E + " edges\n";
		for(int v = 0; v < V; v++) {
			s += v + ": ";
			for(int w : this.adj(v)) {
				s += w + " ";
			}
			s += "\n";
		}
		return s; 
	}
	public static void main(String[] args) {
		Graph G = new Graph(new In(args[0]));
		Graph CG = new Graph(G);
		CG.toString();
	}
}	
