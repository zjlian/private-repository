package tool;

import tempable.ArrayHashTable;

public class DisplayHashTable {
	public static int[] getXY(int num) {
		int x = 8, y  = 5;
		while(x * y < num) {
			x *= 2;
			y *= 2;
		}
		while(x * y > num) {
			x -= 8;
			y -= 5;
		}
		x += 8;
		y += 5;
		return new int[]{x, y};
	}
	public static void display(ArrayHashTable table) {
		int[] XY = getXY(table.capacity()*10);
		int X = XY[0], 
			Y = XY[1];
		int len = table.capacity();
		
		StdDraw.setCanvasSize(X, Y);
		StdDraw.setXscale(0, X);
		StdDraw.setYscale(0, Y);
		
		StdDraw.setPenRadius(0.005);
		
		double px = 2, py = 2;
		int pointCount = 0;
		for(int i = 0; i < len; i++) {
			if(px > X) {
				px = 2;
				py += 3.2;
			}
			if(table.hasKey(i)) {
				StdDraw.setPenColor(StdDraw.BOOK_RED);
				StdDraw.point(px, Y - py);
				++pointCount;
			}
			px += 3;
		}
		System.out.println("display方法 总共绘制了 " + pointCount + " 个点");
	}
}
