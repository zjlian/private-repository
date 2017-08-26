package tempable;
import tool.DisplayHashTable;
import tool.RandomString;

public class ArrayHashTable<Key, Value> {
	//记录表中对象的数量
	private int theSize;
	//表的默认总大小
	private int M;
	//将键值分成两个数组储存
	private Key[] keys;
	private Value[] vals;
	
	//构造函数
	public ArrayHashTable() {
		this(16);
	}
	public ArrayHashTable(int n) {
		keys = (Key[])new Object[n];
		vals = (Value[])new Object[n];
		M = n;
	}
	//hash函数，调用键的hash方法，并与系统最大整数按位与操作，然后返回表大小取余后的值
	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	//获取表中存的对象的数量
	public int size() {
		return theSize;
	}
	//获取表的容量
	public int capacity() {
		return M;
	}
	//重新分配表总大小
	public void resize(int n) {
		//创建一个临时的扩容后大小的散列表
		ArrayHashTable<Key, Value> temp = new ArrayHashTable<Key, Value>(n);
		//遍历当前的表，将键值插入到临时表中
		for(int i = 0; i < M; i++) {
			if(keys[i] != null)
				temp.put(keys[i], vals[i]);
		}
		//将临时表的keys与vals数组，赋值给当前表的对应值
		keys = temp.keys;
		vals = temp.vals;
		M = temp.M;
	}
	
	//添加新对象操作
	public void put(Key key, Value val) {
		if(theSize >= M/4)
			resize(2*M);
		int i;
		//获取将要插入的对象的键的hash值，并向后遍历检查该键是否以存在，
		for(i = hash(key); keys[i] != null; i = (i+1) % M) {
			if(keys[i].equals(key)) {
				vals[i] = val;
				return ;
			}
		}
		//若未在表中找到该键，直接插入在相应的hash值处
		keys[i] = key;
		vals[i] = val;
		//成功插入新对象后，使theSize值自增一位
		++theSize;
	}
	
	//获取键对应的值
	public Value get(Key key) {
		//获取传入的键的hash值，并遍历表，若找到该键，返回对应的值
		for(int i = hash(key); keys[i] != null; i = (i+1) % M) {
			if(keys[i].equals(key))
				return vals[i];
		}
		//没能找到传入的键，返回null
		return null;
	}
	
	//检查该键的对象是否存在数组中，和get方法实现一致
	public boolean contains(Key key) {
		//获取传入的键的hash值，并遍历表，若找到该键，返回true
		for(int i = hash(key); keys[i] != null; i = (i+1) % M) {
			if(keys[i].equals(key))
				return true;
		}
		//没能找到传入的键，返回false
		return false;		
	}
	
	//返回传入数组下标位置的是否有值
	public boolean hasKey(int n) {
		return keys[n] != null;
	}
	
	//删除对应键的对象
	public void delete(Key key) {
		//检查key是否存在表中，没找到就return
		if(!contains(key)) return;
		
		int i = hash(key);
		//找到key在表中的位置,从hash值i开始找，两键不相等就下一位
		while(!key.equals(keys[i]))
			i = (i + 1) % M;
		//找到后，将该位置的的键值删除，就是赋值null,
		keys[i] = null;
		vals[i] = null;
		//再让记录表对象数目的 theSize 减一个
		--theSize;
		
		//紧接着，把位置 i 向后一直到最近的一个null块，之间的所有对象删除并重新插入表中
		i = (i + 1) % M;
		while(keys[i] != null) {
			//将位置i的键值复制一份，并从数组中删除
			Key tmpKey = keys[i];
			Value tmpVal = vals[i];
			keys[i] = null;
			vals[i] = null;
			--theSize;
			//重新向表中插入这对键值
			this.put(tmpKey, tmpVal);
			//位置向后移
			i = (i + 1) % M;
		}
		//删除重插入完成后，检查表是否需要重新分配空间
		//如果表中存的对象的数量 小于等于表总大小的八分之一，则将表重新分配一半的大小
		if(theSize > 0 && theSize <= M/8)
			resize(M/2);
	}

	public static void main(String[] args) {
		ArrayHashTable<String, Integer> tt = new ArrayHashTable<String, Integer>(127);
		final int strlen = 6;
		int count = 0;
		
		int i = 50000;
		int tmpI = i;
		RandomString.setRandomTopic("qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM7894561230");
		while(i-- > 0) {
			String tmpStr = RandomString.getRandomString(strlen);
			if(!tt.contains(tmpStr))
				tt.put(tmpStr, 1);
			else
				tt.put(tmpStr, tt.get(tmpStr) + 1);
		}
		String tmp = RandomString.getRandomString(strlen);
		final int num = 1000;
		for(int j = 0; j < num; j++, tmp = RandomString.getRandomString(strlen)) {
			//System.out.println(tmp + " " + tt.get(tmp));
			if(tt.contains(tmp)) ++count;
		}
		
		System.out.println("随机生成 " + tmpI + "次长度为 " + strlen + "的字符串，插入表中");
		System.out.printf("再次随机生成 " + num + "个随机字符串， %.4f%c 命中表中已有的值\n", ((double)count / num) * 100, '%');
		System.out.println("表里有 " + tt.size() + " 对键值， 表的总容量为 " + tt.capacity());

		DisplayHashTable.display(tt);
	}

}
