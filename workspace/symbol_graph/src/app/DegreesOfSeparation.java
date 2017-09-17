package app;
import std.stdio;
import template.*;

public class DegreesOfSeparation {
	public static void main(String[] args) {
		SymbolGraph sg = new SymbolGraph(args[0], args[1]);
		Graph G = sg.G();
		
		String source = args[2];
		if(!sg.contains(source)) {
			stdio.println(source + "not is database.");
			return;
		}
		int s = sg.index(source);
		BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);
		
		String sink = "";
		while(!sink.equals("exit")) {
			sink = stdio.readString();
			
			if(sg.contains(sink)) {
				int t = sg.index(sink);
				if(bfs.hasPathTo(t)) {
					for(int v : bfs.pathTo(t)) {
						stdio.println("    " + sg.name(v));
					}
				} else stdio.println("Not connected");
			} else stdio.println("Not in database");
			
		}
	}
}
