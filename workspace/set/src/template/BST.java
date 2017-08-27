package template;

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
	public int size(Node t) {
		if(t == null) return 0;
		return t.N;
	}
	public Value get(Key key) {
		return get(root, key);
		//return null;
	}
	public void put(Key key, Value val) {
		root = put(root, key, val);
	}
	
	//helper function
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
	
	public static void main(String[] arge) {
		BST<Integer, String> st = new BST<Integer, String>();
		st.put(1, "one");
		st.put(2, "two");
	}
}
