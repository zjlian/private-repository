package app;

import std.In;
import std.stdio;
import template.Bag;
import template.Graph;

public class ConnectedComponentTest {
	public static void main(String[] args) {
		Graph G = new Graph(new In(args[0]));
		CC cc = new CC(G);
		
		int M = cc.count();
		stdio.println(M + " components");
		
		Bag<Integer>[] components;
		components = (Bag<Integer>[]) new Bag[M];
		for(int i = 0; i < M; i++) {
			components[i] = new Bag<Integer>();
		}
		
		for(int v = 0; v < G.V(); v++) {
			components[cc.id(v)].add(v);
		}
		for(int i = 0; i < M; i++) {
			for(int v : components[i]) {
				stdio.print(v + " ");
			}
			stdio.println();
		}
	}
}
