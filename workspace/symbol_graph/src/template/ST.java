package template;
import java.util.Iterator;

import std.stdio;
import template.Pair;
import template.RedBlackTree;

public class ST<Key extends Comparable<Key>, Value> implements Iterable<Pair<Key, Value>> {
	private RedBlackTree<Pair<Key, Value>> map;
	
	public ST() {
		map = new RedBlackTree<Pair<Key, Value>>();
	}
	public void put(Key key, Value val) {
		put(new Pair<Key, Value>(key, val));
	}
	public void put(Pair<Key, Value> data) {
		map.insert(data);
	}
	public Value get(Key key) {
		Pair<Key, Value> p = map.get(new Pair<Key, Value>(key, null));
		return p.second;
	}
	public boolean contains(Key key) {
		return map.contains(new Pair<Key, Value>(key, null));
	}
	public int size() {
		return map.size();
	}
	public Iterator<Pair<Key, Value>> iterator() {
		return map.iterator();
	}
	
	public static void main(String[] args) {
		ST<String, String> st = new ST<String, String>();
		st.put("aaa", "slave");
		st.put("aab", "get your");
		st.put("abb", "ass");
		st.put("abc", "back");
		st.put("bbb", "here");
		for(Pair<String, String> p : st) {
			stdio.print(p.second + " ");
		}
	}
}
