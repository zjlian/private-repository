package list;

public class LinkedMap<Key extends Comparable<Key>, Value> {
	private class Node{
		Key key;
		Value val;
		Node next;
		
		
		Node(Key k, Value v, Node n) {
			key = k; val = v; next = n;
		}
	}
	public Node first;
	public int theSize;
	
	public LinkedMap() { }
	
	public void put(Key k, Value v) {
		if(get(k) == null) {
			first = new Node(k, v, first);
			++theSize;
		}
		else {
			Node tmp = first;
			while(tmp != null) {
				if(tmp.key.compareTo(k) == 0){
					tmp.val = v;
				}
				tmp = tmp.next;
			}
		}
	}
	public Value get(Key k) {
		Node tmp = first;
		while(tmp != null) {
			if(tmp.key.compareTo(k) == 0) return tmp.val;
			tmp = tmp.next;
		}
		return null;
	}

	public static void main(String[] args) { 
		LinkedMap<String,Integer> test = new LinkedMap<String, Integer>();
		test.put("1", 1);
		test.put("2", 2);
		test.put("3", 3);
		test.put("4", 4);
		test.put("5", 5);
		test.put("1", 11);
		System.out.println(test.get("1"));
		System.out.println();
	}
}
