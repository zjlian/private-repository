package template;

public class Pair<Key extends Comparable<Key>, Value> implements Comparable<Pair<Key,Value>> {
	public Key first;
	public Value second;
	
	public Pair(Key key, Value val) {
		first = key; second = val;
	}
	
	public int compareTo(Pair<Key, Value> o) {
		return first.compareTo(o.first);
	}
	public int compareTo(Key o) {
		return first.compareTo(o);
	}

}
