package ST;

import java.util.LinkedList;
import java.util.Queue;

import stdio.stdio;
import stdio.StdRandom;

public class BST<Key extends Comparable<Key>, Value> {
	private class Node {
		Key key;
		Value val;
		
		Node left, right;
		int N;
		
		public Node(Key key, Value val, int N) {
			this.key = key; this.val = val; this.N = N;
		}
	}
	private Node root;
	
	//Constructor
	public BST() { }
	//--------------------
	public int size() {
		return size(root);
	}

	public Value get(Key key) {
		return get(root, key);
		//return null;
	}
	public void put(Key key, Value val) {
		root = put(root, key, val);
	}
	public void delete(Key key) {
		root = delete(root, key);
	}
	public boolean contains(Key key) {
		return get(key) != null;
	}
	public Key min() {
		return min(root).key;
	}
	public Key max() {
		return max(root).key;
	}
	public Key floot(Key key) {
		Node tmp = floot(root, key);
		if(tmp == null) return null;
		return tmp.key;
	}
	public Key select(int k) {
		Node tmp = select(root, k);
		if(tmp == null) return null;
		return tmp.key;
	}
	public int rank(Key key) {
		return rank(root, key);
	}
	
	//helper function
	public int size(Node t) {
		if(t == null) return 0;
		return t.N;
	}
	private Value get(Node t, Key key) {
		if(t == null) return null;
		int cmp = key.compareTo(t.key);
		if(cmp < 0)
			return get(t.left, key);
		else if(cmp > 0)
			return get(t.right, key);
		else return t.val;
	}
	private Node put(Node t, Key key, Value val) {
		if(t == null) //create a new Node ,if it's null
			return new Node(key, val, 1);
		
		int cmp = key.compareTo(t.key);
		
		if(cmp < 0)
			t.left = put(t.left, key, val);
		else if(cmp > 0)
			t.right = put(t.right, key, val);
		else
			t.val = val;
		
		t.N = size(t.left) + size(t.right) + 1;
		return t;
	}
	private Node min(Node t) {
		if(t.left == null) return t;
		return min(t.left);
	}
	private Node max(Node t) {
		return t.right == null ? t : max(t.right);
		//if(t.right == null) return t; return max(t.right);
	}
	private Node floot(Node t, Key key) {
		if(t == null) return null;
		int cmp = key.compareTo(t.key);
		if(cmp == 0) return t;
		if(cmp < 0) 
			return floot(t.left, key);
		Node tmp = floot(t.right, key);
		if(tmp != null) return tmp;
		else return t;	
	}
	private Node select(Node t, int k) {
		if(t == null) return null;
		int n = size(t.left);
		if(n > k) return select(t.left,k);
		else if(n < k) return select(t.right, k-n-1);
		else return t;
	}
	private int rank(Node t, Key key) {
		if(t == null) return 0;
		int cmp = key.compareTo(t.key);
		if(cmp < 0) return rank(t.left, key);
		else if(cmp > 0) return 1 + size(t.left) + rank(t.right, key);
		else return size(t.left);
	}
	private Node delete(Node t, Key key) {
		if(t == null) return null;
		int cmp = key.compareTo(t.key);
		if(cmp < 0)
			t.left = delete(t.left, key);
		else if(cmp > 0)
			t.right = delete(t.right, key);
		else if(t.left != null && t.right != null) {
			Node tmp = min(t.right);
			t.key = tmp.key; t.val = tmp.val;
			t.right = delete(t.right, t.key);
		} else
			t = t.left != null ? t.left : t.right;
		
		t.N = size(t.left) + size(t.right) + 1;
		return t;
	}
	//forEach方法迭代器
	public Iterable<Key> keys() {
		Queue<Key> queue = new LinkedList<Key>();
		orderTraversal(root, queue);
		return queue;
	}
	private void orderTraversal(Node t, Queue<Key> que) {
		if(t == null) return;
		orderTraversal(t.left, que);
		que.add(t.key);
		orderTraversal(t.right, que);
	}
	
	public static void main(String[] arge) {
		BST<Integer, Integer> st = new BST<Integer, Integer>();
		int len;
		
		len = stdio.readInt();
		for(int i = 0; i < len; i++) {
			int num = StdRandom.uniform(-100,100);
			if(!st.contains(num)) {
				st.put(num, 1);
			} else {
				st.put(num, st.get(num)+1);
			}
		}
		
		stdio.print("[ ");
		for(Integer i : st.keys()) {
			stdio.print(i + " ");
		}
		stdio.print(" ]");
		while(true) {
			String order = stdio.readString();
			int num = stdio.readInt();
			//String key;
			if(order.equals("select")) 
				stdio.println(num + " find up " + st.select(num));
			if(order.equals("rank"))
				stdio.println("the rank of " + num + " is " + st.rank(num));		
		}
	}
}
