package app;

import stdio.stdio;

public class Merge {
	protected static Comparable[] aux;
	public static void merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo , j = mid + 1;
		for(int k = lo; k <= hi; k++)
			aux[k] = a[k];
		
		for(int k = lo; k <= hi; k++) {
			if(i > mid)        a[k] = aux[j++];
			else if(j > hi)    a[k] = aux[i++];
			else if(less(aux[i], aux[j])) 
				a[k] = aux[i++];
			else                           
				a[k] = aux[j++];	
		}
	}
	protected static boolean less(Comparable v, Comparable w) {    //判断参数v 是否比参数w小
		return v.compareTo(w) < 0;   //v > w 时compareTo方法返回 +1 ,则less方法返回false
	}
	protected static void swap(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	public static void show(Comparable[] a) {
		for(int i = 0; i < a.length; i++) 
			stdio.print(" " + a[i]);
		stdio.println();
	}
	protected static boolean isSorted(Comparable[] a) {
		for(int i = 1; i < a.length; i++) 
			if(less(a[i], a[i-1])) return false;
		return true;
	}
	
	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length];
		sort(a, 0, a.length-1);
	}
	public static void sort(Comparable[] a, int lo, int hi) {
		if(lo >= hi) return;
		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid);
		sort(a, mid + 1, hi);
		merge(a, lo, mid, hi);
	}
	
	public static void main(String[] args) {
		show(args);
		Merge.sort(args);
		show(args);
	}

}
