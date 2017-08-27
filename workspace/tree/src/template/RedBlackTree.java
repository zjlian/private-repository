package template;

import tools.stdio;

public class RedBlackTree<T extends Comparable<T>> {
	//用布尔值来标记节点的红黑色
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	//红黑树的节点构造
	private class Node{
		T data;
		boolean color;
		Node left;
		Node right;
		int theSize;
		int height;
		
		public Node(T d, int n, boolean c) {
			data = d;
			theSize = n;
			color = c;
			height = 1;
		}
	}
	//树的根节点
	private Node root;
	
	//api实现
	public void insert(T d) {
		root = insert(d,root);
		root.color = BLACK;
	}
	public int size() {
		return size(root);
	}
	public int height() {
		return height(root);
	}
	
	//判断节点颜色
	private boolean isRed(Node x) {
		if(x == null) return false;
		return x.color == RED;
	}
	
	//分解4-节点时，节点颜色转换的辅助函数
	private void flipColors(Node x) {
		x.color = !x.color;
		x.left.color = !x.left.color;
		x.right.color = !x.right.color;
	}
	/*旋转操作*/
	private Node rotateLeft(Node t) {
		return rotateWithRightChild(t);
	}
	private Node rotateRight(Node t) {
		return rotateWithLeftChild(t);
	}
	//与左子树进行旋转
	private Node rotateWithLeftChild(Node t) {
		if(t == null) return null;
		//取得要旋转的树的左子树节点
		Node c = t.left;
		//将左子树的右节点给到树t的左节点
		t.left = c.right;
		//再将右子树的右节点赋值成树t
		c.right = t;
		//节点颜色也要交换,要保证进行旋转的树的节点颜色不变,再将旋转后的子树节点设为红色
		c.color = t.color;
		t.color = RED;
		//把储存的节点数量信息也更新一下
		c.theSize = t.theSize;
		c.height = t.height;
		t.theSize = size(t.left) + size(t.right) + 1;
		t.height = Math.max(height(t.left), height(t.right)) + 1;
		
		return c;
	}
	//与右子树进行旋转
	private Node rotateWithRightChild(Node t) {
			if(t == null) return null;
			Node c = t.right;
			t.right = c.left;
			c.left = t;
			c.color = t.color;
			t.color = RED;
			c.theSize = t.theSize;
			c.height = t.height;
			t.theSize = size(t.left) + size(t.right) + 1;
			t.height = Math.max(height(t.left), height(t.right)) + 1;
			return c;
	}
	
	//返回节点存的size信息
	private int size(Node t) {
		if(t == null) return 0;
		return t.theSize;
	}
	private int height(Node t) {
		if(t == null) return 0;
		return t.height;
	}
	//递归插入函数
	private Node insert(T d, Node t) {
		//当需要插入的子树是null时，创建一个新节点，并返回，给到上一个栈的函数赋值完成插入
		if(t == null)
			return new Node(d, 1, RED);
		//获取将插入的键与当前树节点的大小关系
		int cmp = d.compareTo(t.data);
		
		//若小于就递归调用insert函数，往左子树继续插入元素d，大于就往右子树插,都不是就更新值
		if(cmp < 0)
			t.left = insert(d, t.left);
		else if(cmp > 0)
			t.right = insert(d, t.right);
		else
			t.data = d;
		
		//**在插入完后，后续代码属于回归部分，对树进行自低向上的操作**//
		//由于红黑树树模拟2-3-4树的，按特性，不允许右子节点树红节点，若出现，调用左旋转修正
		if(isRed(t.right) && !isRed(t.left))
			t = rotateLeft(t);
		//继续检查，上一步修正后，是否有出现连续连个左子节点构成的4-节点，若出现，调用右旋转进行分解修正
		if(isRed(t.left) && isRed(t.left.left))
			t = rotateRight(t);
		//最后，完成4-节点分解的最后一步，调用filpColors函数，对节点颜色进行修改
		if(isRed(t.left) && isRed(t.right))
			flipColors(t);
		
		//逐层向上，重新计算节点储存的theSize值
		t.theSize = size(t.right) + size(t.left) + 1;
		t.height = Math.max(height(t.left), height(t.right)) + 1;
		
		return t;
	}
	
	
	//删除操作
	public void deleteMin() {
		if(!isRed(root.left) && !isRed(root.right)) {
			root.color = RED;
		}
		root = deleteMin(root);
		if(root.theSize != 0) {
			root.color = BLACK;
		}
	}
	private Node deleteMin(Node t) {
		if(t.left == null) {
			return null;
		}
		if(!isRed(t.left) && !isRed(t.left.left)) {
			t = moveRedLeft(t);
		}
		t.left = deleteMin(t.left);
		return balance(t);
		
	}
	public void deleteMax() {
		if(!isRed(root.left) && !isRed(root.right)) {
			root.color = RED;
		}
		root = deleteMax(root);
		if(root.theSize != 0) {
			root.color = BLACK;
		}
	}
	private Node deleteMax(Node t) {
		if(isRed(t.left)) {
			t = rotateRight(t);
		}
		if(t.right == null) {
			return null;
		}
		if(!isRed(t.right) && !isRed(t.right.left)) {
			t = moveRedRight(t);
		}
		t.right = deleteMax(t.right);
		return balance(t);
	}
	//delete helper function
	private Node moveRedLeft(Node t) {
		//前提节点t是红色，t.left和t.right均为黑色
		//该函数会将t.left或t.left的子节点之一变红
		
		flipColors(t);
		if(isRed(t.right.left)) {
			t.right = rotateRight(t.right);
			t = rotateLeft(t);
			//flipColors(t);
		}
		return t;
	}
	private Node moveRedRight(Node t) {
		flipColors(t);
		if(isRed(t.left.left)) {
			t = rotateRight(t);
		}
		return t;
	}
	private Node balance(Node t) {
		if(isRed(t.right)) 
			t = rotateLeft(t);
		if(isRed(t.left) && isRed(t.left.left))
			t = rotateRight(t);
		if(isRed(t.left) && isRed(t.right))
			flipColors(t);
		
		t.theSize = size(t.right) + size(t.left) + 1;
		t.height = Math.max(height(t.left), height(t.right)) + 1;
		
		return t;
	}
	
	public static void main(String[] args) {
		RedBlackTree<String> set = new RedBlackTree<String>();
		String str;
		String order;
		
		while(true) {
			order = stdio.readString();
			if(order.equals("min")) {
				set.deleteMin();
			} else if(order.equals("max")) {
				set.deleteMax();
			} else if(order.equals("insert")) {
				str = stdio.readString();
				set.insert(str);
			}
			stdio.println("tree size:" + set.size() + " height:" + set.height());
		}
	}
}

