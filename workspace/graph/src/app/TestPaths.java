package app;

import std.In;
import std.stdio;
import template.Graph;

public class TestPaths {
	public static void main(String[] args) {
		Graph G = new Graph(new In(args[0]));
		int s =  Integer.parseInt(args[1]);
		DepthFristPaths search = new DepthFristPaths(G, 0);
		
		for(int v = 0; v < G.V(); v++) {
			stdio.print(s + " to " + v + ": ");
			if(search.hasPathTo(v)) {
				for(int x : search.pathTo(v)) {
					if(x == s) stdio.print(x);
					else stdio.print("-" + x);
				}
			} else stdio.print("NOT");
			stdio.println();
		}
	}
}
