package tree;
import mapNode.Pair;
import tool.Stopwatch;
import java.util.Scanner;
import java.util.Stack;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;


public class RedBlackTree<T extends Comparable<T>> {
	private Node root;
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private class Node {
		T data;
		Node left, right;
		int theSize;
		boolean color;
		
		Node(T d, int n, boolean c) {
			data = d;
			theSize = n;
			color = c;
		}
	}
	
	public void insert(T d) {
		root = insert(root, d);
		root.color = BLACK;
	}
	
	public Collection<T> preorder() {
		return preorder(root);
	}
	public Collection<T> inorder() {
		return inorder(root);
	}
	/*--==========================================--*/
	public Collection<T> _preorder() {
		Queue<T> retVal = new LinkedList<T>();
		_preorder(root, retVal);
		return retVal;
	}
	private void _preorder(Node t, Queue<T> tmp) {
		if(t == null) return;
		tmp.add(t.data);
		_preorder(t.left, tmp);
		_preorder(t.right, tmp);
	}
	public Collection<T> _inorder() {
		Queue<T> retVal = new LinkedList<T>();
		_inorder(root, retVal);
		return retVal;
	}
	private void _inorder(Node t, Queue<T> tmp) {
		if(t == null) return;
		_preorder(t.left, tmp);
		tmp.add(t.data);
		_preorder(t.right, tmp);
	}
	/*--=======================================--*/
	private int size(Node t) {
		return (t == null) ? 0 : t.theSize;
	}
	
	private boolean isRed(Node x) {
		if(x == null) return false;
		return x.color == RED;
	}
	private void flipColors(Node x) {
		x.color = RED;
		x.left.color = BLACK;
		x.right.color = BLACK;
	}
	private Node rotateLeft(Node p) {
		return rotateWithRightChild(p);
	}
	private Node rotateRight(Node p) {
		return rotateWithLeftChild(p);
	}
	private Node rotateWithLeftChild(Node p) {
		Node c = p.left;
		p.left = c.right;
		c.right = p;
		
		c.color = p.color;
		p.color = RED;
		c.theSize = p.theSize;
		p.theSize = size(p.left) + size(p.right) + 1; 
		
		return c;
	}
	private Node rotateWithRightChild(Node p) {
		Node c = p.right;
		p.right = c.left;
		c.left = p;
		
		c.color = p.color;
		p.color = RED;
		c.theSize = p.theSize;
		p.theSize = size(p.left) + size(p.right) + 1;
		
		return c;
	}
	
	private Node insert(Node t, T val) {
		if(t == null)
			return new Node(val, 1, RED);
		int cmp = val.compareTo(t.data);
		if(cmp < 0)
			t.left = insert(t.left, val);
		else if(cmp > 0)
			t.right = insert(t.right, val);
		else t.data = val;
		
		//当3-节点偏向右侧时(即右子节点为红色)，调用左旋转
		if(isRed(t.right) && !isRed(t.left)) 
			t = rotateLeft(t);
		//当出现4-节点时(即连续两个左子节点为红色)，调用右选转
		if(isRed(t.left) && isRed(t.left.left)) 
			t = rotateRight(t);
		//当4-节点已被平衡，将其分解成3个2-节点
		if(isRed(t.left) && isRed(t.right)) 
			flipColors(t);
		
		t.theSize = 1 + size(t.left) + size(t.right);
		return t;
	}
	
	//返回一个先序遍历的队列
	private Collection<T> preorder(Node t) {  
		if(t == null) return null;
		Queue<T> retVal = new LinkedList<T>();
		Stack<Node> tmp = new Stack<Node>();
		
		visitAlongLeft(t, retVal, tmp);
		
		while(!tmp.isEmpty())
			visitAlongLeft(tmp.pop(), retVal, tmp);			
		
		return retVal;
	}
	//先序遍历的辅助函数
	//用于中序序列按获得子树值中的一个节点并将他的右子节点压入栈中，然后进入左子树，继续此操作，直到遇到空树
	private void visitAlongLeft(Node t, Queue<T> con, Stack<Node> tmp) { 
		while(t != null) {
			tmp.push(t.right);
			con.add(t.data);
			t = t.left;
		}
		//return tmp;
	}
	//返回一个中序遍历的队列
	private Collection<T> inorder(Node t) {  
		if(t == null) return null;
		Queue<T> retVal = new LinkedList<T>();
		Stack<Node> tmp = new Stack<Node>();
		
		while(true) {
			alongLeftGain(t, tmp);
			if(tmp.isEmpty()) break;
			t = tmp.pop();
			retVal.add(t.data);
			t = t.right;
		}
		return retVal;
	}
	//中序遍历的辅助函数
	//将子树的最左侧节自顶向下点压入栈中
	private void alongLeftGain(Node t, Stack<Node> tmp) {
		while(t != null) {
			tmp.push(t);
			t = t.left;
		}
	}
	
	
	public static void main(String[] args) {
		RedBlackTree<Pair<String, Integer>> mymap;
		mymap = new RedBlackTree<Pair<String, Integer>>();
		
		String val;
		Scanner read = new Scanner(System.in);
		while(true) {
			val = read.next();
			if(val.equals("exit")) break;
			
			mymap.insert(new Pair<String, Integer>(val,1));
		}
		read.close();
		
		Stopwatch time = new Stopwatch();
		Collection<Pair<String, Integer>> printVals = mymap.inorder();
		long s = time.eatShit();
		
		System.out.println("遍历树用了 " + s + " 毫秒");
		
		/*
		for(Pair<String, Integer> x : printVals) {
			System.out.print(x.first + " ");
		}*/
	}

}
