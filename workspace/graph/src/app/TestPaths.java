package app;

import std.In;
import std.stdio;
import template.Graph;
/*
 * 测试数据：
 * http://algs4.cs.princeton.edu/41graph/tinyG.txt
 * http://algs4.cs.princeton.edu/41graph/mediumG.txt
 * http://algs4.cs.princeton.edu/41graph/largeG.txt  //这个数据量太大，没法打印
 * */
public class TestPaths {
	public static void main(String[] args) {
		Graph G = new Graph(new In(args[0]));
		int s =  Integer.parseInt(args[1]);
		//DepthFristPaths | BreadthFirstPaths  //广度优先搜索牛逼!!
		BreadthFirstPaths search = new BreadthFirstPaths(G, 0);
		
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
