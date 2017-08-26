package tools;
import tools.StdDraw;
import template.RedBlackTree;

public class DispalyRBT {
	private DispalyRBT() { }
	static {
		init();
	}
	
	static int CanvasSizeX = 200;
	static int CanvasSizeY = 200;
	private static void init() {
		StdDraw.setCanvasSize(CanvasSizeX, CanvasSizeY);
		StdDraw.setXscale(0, CanvasSizeX);
		StdDraw.setYscale(0, CanvasSizeY);
	}
	
	public static void display(RedBlackTree<String> tree) {
		
	}
	
	
}
