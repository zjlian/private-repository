package classDemo;

import mylib.StdDraw;
import mylib.StdRandom;
import mylib.stdio;

/*
 * 一个可视化的 累计器（Accumulator）类;
 * 依赖StdDraw类库
 * 
 * API与Accumulator相同
 * 		VisualAccumulator(int trials, double max)			  创建一个累加器
 * 
 * */
public class VisualAccumulator {
	private int N;
	private double total;
	
	public VisualAccumulator(int trials, double max) {
		N = 0;
		total = 0.0;
		StdDraw.setXscale(0, trials);
		StdDraw.setYscale(0, max);
		StdDraw.setPenRadius(.003);
	}
	
	public void addDataVal(double val) {
		++N;
		total += val;
		StdDraw.setPenColor(StdDraw.DARK_GRAY);
		StdDraw.point(N, val);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.point(N, total/N);
	}
	public double mean() {
		return (total / N); }
	public String toString() {
		return ("Mean (" + N + " values): " + String.format("%7.5f", mean())); }
	/*--=============================--*/
	public static void main(String[] ages) {
		int T = stdio.readInt();
		VisualAccumulator temp = new VisualAccumulator(T, 1.0);
		
		for(int t = 0; t < T; t++)
			temp.addDataVal(StdRandom.uniform());
		stdio.println(temp);
	}
}





