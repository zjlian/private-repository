package classDemo;
import java.util.Arrays;
import mylib.stdio;

import mylib.StdRandom;
/*
 * 具有二分查找方法的类型集合类
 * API:
 * 			  StaticSETofInts(int[] keys)      根据keys[]中的所有值创建一个集合
 * Boolean    contains(int key)      		   key是否存在于集合中
 * */
public class StaticSETofInts {
	private int[] a;
	public StaticSETofInts(int[] keys) {
		a = new int[keys.length];
		for(int i = 0; i < keys.length; i++) 
			a[i] = keys[i];
		
		Arrays.sort(a);
	}
	public boolean contains(int key) {
		return rank(key) != -1; }
	private int rank(int key) {
		int lo = 0;
		int hi = a.length - 1, i = 1;
		while(lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			stdio.printf("%2d. 查找范围 [%d,%d],中间值 a[%d] = %d\n",i++, lo, hi, mid, a[mid]);
			if(key < a[mid])
				hi = mid - 1; 
			else if(key > a[mid])
				lo = mid + 1;
			else 
				return mid;
			
		}
		return -1;
	}
	public String toString() {
		int end = 0;
		for(int i = 0; i < a.length; i++) {
			if(i % 19 == 0) {
				end = (i > a.length - 19) ? a.length - 1 : i + 18;
				stdio.print('\n');
				stdio.printf("[%3d]-[%3d] ", i, end);
			}
			stdio.printf("%4d, ", a[i]);
		}
		stdio.println();
		return "";
	}
	
	public static void main(String[] age) {
		int[] tmp = new int[101];
		for(int i = 0; i < tmp.length; i++) {
			tmp[i] = StdRandom.uniform(1001);
		}
 		StaticSETofInts list = new StaticSETofInts(tmp);
 		int topic = StdRandom.uniform(1001);
 		stdio.print("将要查找: " + topic);
 		
 		list.toString();
 		
		if(list.contains(topic))
			stdio.println("找到啦");
		else 
			stdio.println("表中不存在这个值");
		
	}
}
