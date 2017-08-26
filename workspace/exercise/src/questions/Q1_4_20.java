package questions;

import stdio.stdio;

public class Q1_4_20 {
	public static int find(int[] a, int key, int f, int l) {
		int mid;
		while(f <= l) {
			mid = f + (l - f) /2;		
			if(a[mid] > key) l = mid - 1;
			else if(a[mid] < key) f = mid + 1;
			else return mid;
		}
		return -1;
	}
	public static int unfind(int[] a, int key, int f, int l) {
		int mid;
		while(f <= l) {
			mid = f + (l - f) /2;
			if(a[mid] < key) l = mid - 1;
			else if(a[mid] > key) f = mid + 1;
			else return mid;
		}
		return -1;
	}
	public static int twoTypesFind(int[] a, int key) {
		int f = 0, l = a.length - 1;
		int mid = f + (l - f) /2;
		int pos = 0;
		
		if(a[mid] == key) return mid;
		pos = find(a, key, f, mid - 1);
		if(pos == -1) {
			pos = unfind(a, key, mid + 1, l);
		}
		if(pos >= 0) return pos;
		return -1;
	}
	public static void main(String[] args) {
		int[] test = {1, 3, 5, 7, 9, 11, 13, 15, 14, 12, 10, 8, 6, 4, 2, 0};
		stdio.println(twoTypesFind(test, 0));

	}

}
