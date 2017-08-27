package app;
import stdio.*;

public class Insertion {
	private static boolean less(Comparable v, Comparable w) {    //判断参数v 是否比参数w小
		return v.compareTo(w) < 0;   //v > w 时compareTo方法返回 +1 ,则less方法返回false
	}
	private static void swap(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	public static void show(Comparable[] a) {
		for(int i = 0; i < a.length; i++) 
			stdio.print(" " + a[i]);
		stdio.println();
	}
	private static boolean isSorted(Comparable[] a) {
		for(int i = 1; i < a.length; i++) 
			if(less(a[i], a[i-1])) return false;
		return true;
	}

	public static void sort(Comparable[] a) {
		int len = a.length;
		for(int i = 0; i < len; i++) {
			//show(a);
			for(int j = i; j > 0 && less(a[j],a[j-1]); j--){
				swap(a, j, j-1);
			}
		}
	}
	public static void main(String[] args) {
		show(args);
		sort(args);
	    show(args);
	} 
}
