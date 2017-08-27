package app;
import stdio.stdio;

public class Shell {
	private final static int[] hh = {1, 4, 13, 40, 121, 364, 1093, 3280, 9841};
	private static boolean less(Comparable v, Comparable w) {    //判断参数v 是否比参数w小
		return v.compareTo(w) < 0;   //v > w 时compareTo方法返回 +1 ,则less方法返回false
	}
	private static void swap(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	private static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	public static void show(Comparable[] a) {
		for(int i = 0; i < a.length; i++) 
			stdio.print(" " + a[i]);
		stdio.println();
	}
	public static void show(int[] a) {
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
		int h  = 1;
		while(h < len/3)
			h = h * 3 + 1;
		while(h >= 1) {
			for(int i = h; i < len; i++) {
				for(int j = i; j >= h && less(a[j], a[j-h]); j -= h) 
					swap(a, j, j-h);
			}
			h = h/3;
		}
	}
	
	public static void sort(int[] a) {
		int len = a.length;
		int d = hh.length - 1;
		while(d >= 0) {
			int h = hh[d];
			for(int i = h; i < len; i++) {
				for(int j = i; j >= h && a[j] < a[j-h]; j -= h)
					swap(a, j, j-h);
			}
			d--;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,5,2,6,3,4,9,8,7};
		show(arr);
		Shell.sort(arr);
	    show(arr);
	} 

}
