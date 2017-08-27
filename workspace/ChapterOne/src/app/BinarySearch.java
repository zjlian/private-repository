package app;

import stdio.stdio;

public class BinarySearch {
	public static int rank(int key, int[] a) {
		int lo = 0, 
			hi = a.length - 1;
		while(lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if(key < a[mid]) hi = mid - 1;
			else if(key > a[mid]) lo = mid + 1;
			else  return mid;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = {1,1,2,3,5,8,13,21,34,55,89,144};
		stdio.println(BinarySearch.rank(21, arr));

	}

}
