package template;


public class BSTree<T extends Comparable<T>> {
	
	protected class Node {
		public T data;
		public int theSize;
		public Node left, right;
		
		public Node(T d, int n) {
			data = d;
			theSize = n;
		}
		public Node(T d) {
			this(d, 1);
		}
	}
	
	protected Node root;
	
	/*--==========================--*/
	
	public int size() {
		return size(root);
	}
	public T get(T val) {
		//使用类似Pair的映射结构自行继承覆盖实现该功能
		return get(val, root).data;
	}
	public void insert(T val) {
		root = insert(val, root);
	}
	public T max() {
		return max(root).data;
	}
	public T min() {
		return min(root).data;
	}
	public T select(int rank) {
		return select(rank, root).data;
	}
	public void deleteMin() {
		deleteMin(root);
	}
	public void deleteMax() {
		deleteMax(root);
	}
	/*--==========================--*/
	private int size(Node t) {
		return t == null ? 0 : t.theSize;
	}
	private Node get(T val, Node t) {
		while(t != null) {
			int cmp = val.compareTo(t.data);
			if(cmp < 0) t = t.left;
			else if(cmp > 0) t = t.right;
			else return t;
		}
		return null;
	}
	private Node insert(T val, Node t){
		if(t == null)
			return new Node(val);
		int cmp = val.compareTo(t.data);
		if(cmp < 0)
			t.left = insert(val, t.left);
		else if(cmp > 0)
			t.right  = insert(val, t.right);
		else
			t.data = val;
		
		t.theSize = 1 + size(t.left) + size(t.right);
		return t;
	}
	private Node max(Node t) {
		while(t != null) 
			t = t.right;
		return t;
	}
	private Node min(Node t) {
		while(t != null)
			t = t.left;
		return t;
	}
	private Node select(int rank, Node t) {
		while(t != null) {
			int k = size(t.left);
			if(rank < k) t = t.left;
			else if(rank > k) {
				rank = rank - k - 1;
				t = t.right;
			}
			else return t;
		}
		return null;
	}
	private Node deleteMin(Node t) {
		if(t.left == null) 
			return t.right;
		t.left = deleteMin(t.left);
		t.theSize = size(t.right) + size(t.left) + 1; 
		return t;
	}
	private Node deleteMax(Node t) {
		if(t.right == null)
			return t.left;
		t.right = deleteMin(t.right);
		t.theSize = size(t.right) + size(t.left) + 1; 
		return t;
	}
	private void _deleteMin_(Node t) {
		while(t.left.left != null)
			t = t.left;
		t.left = t.left.right;
	}
	
	/*public void test() {
		tester(root);
	}
	private void tester(Node t) {
		//t = t.left;
		//t.right = new Node(null);
		second_tester(t.left);
		//t = null;
		//t.left = new Node(null);
		//t.right = new Node(null);
	}
	private void second_tester(Node t) {
		t = new Node(null);
		//t.left = new Node(null);
		//t.right = new Node(null);
	}*/
	
	public static void main(String[] args) {
		BSTree<String> st = new BSTree<String>();
		st.insert("D");
		st.insert("C");
		st.insert("B");
		st.insert("A");
		st.insert("G");
		st.deleteMin();
		st.deleteMax();
		System.out.println();
	}
}
