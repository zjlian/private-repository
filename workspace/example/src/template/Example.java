package template;

import stdio.stdio;

public abstract class Example {

	protected static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
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
	
	
	public static void main(String[] args) {
		

	}

}
