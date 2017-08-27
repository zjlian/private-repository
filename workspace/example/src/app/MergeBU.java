package app;

public class MergeBU extends Merge{
	public static int min(int v, int w) {
		return v > w ? w : v;
	}
	
	public static void sort(Comparable[] a) {
		int N = a.length;
		aux = new Comparable[N];
		for(int sz = 1; sz < N; sz *= 2)
			for(int lo = 0; lo < N-sz; lo += sz*2 )
				merge(a, lo, lo+sz-1, min(lo + sz*2 - 1, N-1));
		
	}

	public static void main(String[] args) {
		show(args);
		MergeBU.sort(args);
		show(args);
	}

}
