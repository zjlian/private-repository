package tree;

import stdio.stdio;

public class BSTree<T extends Comparable<T>> {
	private class Node {
		T data;
		Node left, right;
		int theSize, theHeight;
		
		Node(T d, Node lt, Node rt, int s, int h) {
			data = d; left = lt; right = rt; theSize = s; theHeight = h;
		}
		Node(T d, Node lt, Node rt) {
			this(d, lt, rt, 1, 0);
		}
		Node(T d) {
			this(d, null, null, 1, 0);
		}
	}
	
	private Node root;
	private Node tempNode;
	
	//--------------------------------
	public int size() {
		return size(root);
	}
	public T get(T data) {
		return get(data, root).data;
	}
	public void insert(T data) {
		root = insert(data, root);
	}
	public T select(int k) {
		return select(k, root).data;
	}
	
	//--------------------------------
	private int max(int l, int r) {
		return l > r ? l : r;
	}
	private int size(Node t) {
		return t == null ? 0 : t.theSize;
	}
	private int height(Node t) {
		return t == null ? -1: t.theHeight;
	}
	
	private Node get(T data, Node t) {
		if(tempNode.data.compareTo(data) == 0) return tempNode;
		Node x = t;
		while(x != null) {
			int cmp = data.compareTo(x.data);
			if(cmp == 0) {
				tempNode = x;
				return x;
			}
			else if(cmp < 0) x = x.left;
			else if(cmp > 0) x = x.right;
		}
		return null;
	}
	private Node max(Node t) {
		while(t.right != null)
			t = t.right;
		return t;
	}
	private Node min(Node t) {
		while(t.left != null)
			t = t.left;
		return t;
	}
	private Node insert(T data, Node t) {
		if(t == null)  return new Node(data);
		
		int cmp = data.compareTo(t.data);
		if(cmp < 0)
			t.left = insert(data, t.left);
		else if(cmp > 0)
			t.right = insert(data, t.right);
		else ;
		
		t.theSize = 1 + size(t.left) + size(t.right);
		return t;
	}
	private Node delete(T data, Node t) {
		if(t == null) return null;
		int cmp = data.compareTo(t.data);
		if(cmp < 0) 
			t.left = delete(data, t.left);
		else if(cmp > 0)
			t.right = delete(data, t.right);
		else if(t.left != null && t.right != null) {
			t.data = min(t.right).data;
			t.right = delete(t.data, t.right);
		} else 
			t = t.left != null ? t.left : t.right;
		
		t.theSize = 1 + size(t.left) + size(t.right);
		return t;
	}
	private Node select(int k, Node t) {
		if(t == null || k > t.theSize)
			return null;
		
		while(true) {
			int s = size(t.left);
			if(s > k) t = t.left;
			else if(s < k) {
				t = t.right;
				k = k - s - 1;
			}
			else return t;
		}
	}
	public static void main(String[] args) {
		BSTree<Integer> t = new BSTree<Integer>();
		t.insert(0);
		t.insert(10);
		t.insert(-10);
		t.insert(-5);
		t.insert(-15);
		t.insert(5);
		t.insert(15);
		stdio.print(t.select(0));
	}
}
