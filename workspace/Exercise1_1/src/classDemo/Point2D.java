package classDemo;

import mylib.StdDraw;
import mylib.StdRandom;
import mylib.stdio;

public class Point2D {
	private Point[] list;
	//private int Xscale;
	//private int Yscale;
	private int scale;
	private int length;
	
	public Point2D(int N) {
		scale = 100;
		//Xscale = Yscale = scale;
		list = new Point[N];
		
		for(int i = 0; i < list.length; i++) {
			list[i] = new Point();
			list[i].setX(StdRandom.uniform(scale));
			list[i].setY(StdRandom.uniform(scale));
		}
		this.length = N;
	}
	
	public Point getPoint(int key) {
		return list[key];
	}
	public double getInch() {
		return Math.sqrt(scale*scale+scale*scale);
	}
	
	public static void main(String[] ages) {
		int N = stdio.readInt();
		
		StdDraw.setXscale(-1, 100);
		StdDraw.setYscale(-1, 100);
		StdDraw.setPenRadius(.008);
		
		Point2D list = new Point2D(N);
		double minDistance = list.getInch(); //获取点所在的正方形的斜边长 
		for(int i = 0; i < list.length; i++) {
			for(int p = i + 1; p < list.length; p++){
				Point a = list.getPoint(i);
				Point b = list.getPoint(p);
				double distance = a.distanceTo(b);
				minDistance = (distance < minDistance) ? distance : minDistance;
			}
		}
		for(int i = 0; i < list.length; i++) {
			StdDraw.setPenColor(StdDraw.DARK_GRAY);
			StdDraw.point(list.getPoint(i).getX(), list.getPoint(i).getY());
		}
		
		stdio.printf("%.5f",minDistance);
	}
	
}
