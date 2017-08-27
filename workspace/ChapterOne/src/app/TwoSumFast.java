package app;

import java.util.Arrays;

import stdio.In;
import stdio.stdio;

public class TwoSumFast {
	public static int count(int[] a) {
		Arrays.sort(a);
		int len = a.length;
		int cut = 0;
		for(int i = 0; i < len; i++) {
			if(BinarySearch.rank(-a[i], a) > i)
				cut++;
		}
		return cut;
	}

	public static void main(String[] args) {
		int[] a = args[0]
		stdio.println(TwoSumFast.count(a));
	}

}
