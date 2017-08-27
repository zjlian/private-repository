package ST;
import java.util.LinkedList;
import java.util.Queue;

import stdio.stdio;
/*基于无序链表的符号表*/
public class SequentialSearchST<Key, Value> {
	//内置节点类
	private class Node {
		Key key;
		Value val;
		Node next;
		
		public Node(Key key, Value val, Node next) {
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}
	
	private Node first; //链表的头节点
	private int count;
	
	public SequentialSearchST() {
		count = 0;
	}
	
	public Value get(Key key) {
		for(Node x = first; x != null; x = x.next) {
			if(key.equals(x.key)) 
				return x.val;
		}
		return null;
	}
	public void put(Key key, Value val) {
		for(Node x = first; x != null; x = x.next) {
			if(key.equals(x.key)) {
				x.val = val;
				count++;
				return ;
			}
		}
		first = new Node(key, val, first);
		count++;
	}
	public boolean contains(Key key) {
		return get(key) != null;
	}
	public int size() {
		return count;
	}
	
	public Iterable<Key> keys() {
		Queue<Key> queue = new LinkedList<Key>();
		for(Node x = first; x != null; x = x.next) {
			queue.add(x.key);
		}
		return queue;
	}
	
	public static void main(String[] args) {
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
		st.put("一", 1);
		st.put("二", 2);
		st.put("三", 3);
		st.put("四", 4);
		st.put("五", 5);
		stdio.println(st.get("二"));
	}

}
