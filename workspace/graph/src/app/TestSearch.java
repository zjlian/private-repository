package app;
import std.In;
import std.stdio;
import template.Graph;

public class TestSearch {
	public static void main(String[] args) {
		Graph G = new Graph(new In(args[0]));
		stdio.print("图创建完成; ");
		int s =  Integer.parseInt(args[1]);
		stdio.println("与起点 " + s + " 连通的节点有: ");
		DepthFirstSearch search = new DepthFirstSearch(G, s);
		
		for(int v = 0; v < G.V(); v++) {
			if(search.marked(v)) {
				stdio.print(v + " ");
			}
		}
		stdio.println();
		
		if(search.count() != G.V()) {
			stdio.print("不");
		}
		stdio.println("是连通图");
		
		//stdio.println("图创建完成");
		stdio.println(G.toString());
	}
}
