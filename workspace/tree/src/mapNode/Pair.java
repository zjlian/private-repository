package mapNode;

public class Pair<Key extends Comparable<Key>, Value> implements Comparable<Pair<Key, Value>>{
	public Key first;
	public Value second;
	
	public Pair(Key key, Value val) {
		first = key; second = val;
	}
	@Override
	public int compareTo(Pair<Key, Value> o) {
		return this.first.compareTo(o.first);
	}
	
	public static void main(String[] args) {
		Pair<String, Integer> test = new Pair<String, Integer>("test", 0xFF);
		System.out.println(test + " " + test.first + " " + test.second);
		
		Pair<String, Integer> tt = new Pair<String, Integer>("aaaa", 0x00);
		System.out.println(tt.compareTo(test));
		
	}
}

