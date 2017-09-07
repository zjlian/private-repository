package template;

import std.In;
import std.stdio;
import template.ST;
import template.Graph;

public class SymbolGraph {
	private ST<String, Integer> st;		//符号名 -> 索引
	private String[] keys;				//索引 -> 符号名
	private Graph G;
	
	public SymbolGraph(String stream, String sp) {
		st = new ST<String, Integer>();
		In in = new In(stream);
		while(in.hasNextLine()) {
			String[] a = in.readLine().split(sp);
			//给字符串关联索引 
			for(int i = 0; i < a.length; i++) {
				if(!st.contains(a[i])) {
					st.put(a[i], st.size());
				}
			}
		}
		//创建一个用于反向查找的索引对字符串数组
		keys = new String[st.size()];
		for(Pair<String, Integer> p : st) {
			keys[p.second] = p.first;
		}
		
		//构造图
		G = new Graph(st.size());
		in = new In(stream);
		while(in.hasNextLine()) {
			String[] a = in.readLine().split(sp);
			int v = st.get(a[0]);
			for(int i = 1; i < a.length; i++) {
				G.addEdge(v, st.get(a[i]));
			}
		}
	}
	
	public boolean contains(String s) 
	{ return st.contains(s); }
	public int index(String s) 
	{return st.get(s);}
	public String name(int v) 
	{ return keys[v]; }
	public Graph G() 
	{ return G; }
	
	public static void main(String[] args) {
		String filename = args[0];
		String delim = args[1];
		SymbolGraph sg = new SymbolGraph(filename, delim);
		Graph G = sg.G();
	}
}
