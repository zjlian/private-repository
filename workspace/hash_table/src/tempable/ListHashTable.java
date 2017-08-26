package tempable;
import tool.RandomString;
import list.LinkedMap;

public class ListHashTable<Key extends Comparable<Key>, Value> {
	public static RandomString rs;
	private int theSize;
	private int M;
	private LinkedMap<Key, Value>[] data;
	
	public ListHashTable(int M) {
		this.M = M;
		data = (LinkedMap<Key, Value>[])new LinkedMap[M];
		
		for(int i = 0; i < M; i++) 
			data[i] = new LinkedMap<Key, Value>();
	}
	public ListHashTable() {
		this(997);
	}
	
	public void put(Key k, Value v) {
		data[hash(k)].put(k, v);
	}
	public Value get(Key k) {
		return data[hash(k)].get(k);
	}
	public int size() {
		int retVal = 0;
		for(int i = 0; i < data.length; i++)
			retVal += data[i].theSize;
		return retVal;
	}
	
	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	public static void main(String[] args) {
		final int strlen = 4;
		int count = 0;
		ListHashTable<String, Integer> tt = new ListHashTable<String, Integer>(49993);
		int i = 40000;
		while(i-- > 0) {
			String tmpStr = RandomString.getRandomString(strlen);
			tt.put(tmpStr, tmpStr.hashCode());
		}
		String tmp = RandomString.getRandomString(strlen);
		
		for(i = 0; i < 40000; i++, tmp = RandomString.getRandomString(strlen))
			if(tt.get(tmp) != null) ++count;
				
		System.out.printf("%.2f%c 随机中已有值\n", ((double)count / tt.size()) * 100, '%');
	}
}
