package template;

import std.In;
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
		in = new In(stream);
	}
	
	public static void main(String[] args) {
		String filename = args[0];
		String delim = args[1];
		SymbolGraph sg = new SymbolGraph(filename, delim);
		
	}
}
