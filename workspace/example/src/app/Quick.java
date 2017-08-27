package app;
import template.Example;
import stdio.StdRandom;

public class Quick extends Example{
	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);
		show(a);
		sort(a, 0, a.length - 1);
	}
	public static void sort(Comparable[] a, int lo, int hi) {
		if(lo >= hi) return;
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}
	public static int partition(Comparable[] a, int lo, int hi) {
		int i = lo, j = hi + 1;
		Comparable v = a[lo];
		
		while(true) {
			
			while(less(a[++i], v))  if(i == hi) break;
			while(less(v, a[--j]))  if(j == lo) break;
			
			if(i >= j) break;
			
			swap(a, i, j);
		}
		swap(a, lo, j);
	
		return j;
	}

	public static void main(String[] args) {
		show(args);
		Quick.sort(args);
		show(args);

	}

}
