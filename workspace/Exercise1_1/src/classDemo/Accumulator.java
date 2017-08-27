package classDemo;
import mylib.StdRandom;
import mylib.stdio;

/*  累加器数据类型模板
 *   API:
 * 		   Accumulator()			  创建一个累加器
 *   void  addDataVal(double val)	  添加一个新的数值
 * double  mean()					  返回所有数值的平均值
 * String  toString() 				  对象的字符串表示
 * */
public class Accumulator {
	private int N;
	private double total;
	
	public Accumulator() {
		N = 0;
		total = 0.0;
	}
	public void addDataVal(double val) {
		++N;
		total += val; 
	}
	public double mean() {
		return (total / N); }
	public String toString() {
		return ("Mean (" + N + " values): " + String.format("%7.5f", mean())); }
/*--===========================================--*/
	public static void main(String[] ages) {
		int T = stdio.readInt();
		Accumulator temp = new Accumulator();
		
		for(int t = 0; t < T; t++)
			temp.addDataVal(StdRandom.uniform());
		stdio.println(temp);
	}
}
