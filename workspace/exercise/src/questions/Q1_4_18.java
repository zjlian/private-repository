package questions;

import stdio.stdio;

public class Q1_4_18 {
	public static int findPartLowestElem(int[] a, int f, int l) {
		int mid = f + (l - f) / 2;
		
		if(f >= l) return -1;
		if(a[mid] < a[mid - 1] && a[mid] < a[mid + 1]) {
			return mid;
		} 
		if(a[mid] > a[mid+1]){
			return findPartLowestElem(a, mid+1, l);
		} 
		return findPartLowestElem(a, f, mid - 1);
	}
	public static void main(String[] args) {
		int[] test = {2,5,4,8,8,9,5,7,6,8};
		stdio.println("find key is " + findPartLowestElem(test, 0, test.length-1));

	}

}
