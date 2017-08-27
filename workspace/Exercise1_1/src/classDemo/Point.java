package classDemo;

import mylib.stdio;

public class Point {
	private int X, Y;
	
	public void setX(int x) {
		X = x;
	}
	public void setY(int y) {
		Y = y;
	}
	public int getX() {
		return X;
	}
	public int getY() {
		return Y;
	}
	
	public double distanceTo(Point topic) {
		//double distance = 0.0;
		int a = Math.abs(this.getX() - topic.getX());
		int b = Math.abs(this.getY() - topic.getY());
		//distance = Math.sqrt(a*a + b*b);
		return Math.sqrt(a*a + b*b);
	}
	
	public static void main(String[] ages) {
		Point a = new Point(); 
		Point b = new Point(); 
		a.setX(2);
		a.setY(1);
		b.setX(5);
		b.setY(5);
		stdio.println(a.distanceTo(b));
	}
}
