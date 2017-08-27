public class Exam1_2_2 {

	public static void main(String[] args) {
		byte a = 127;
		short b = 32767;
		int c = 2147483647;
		long d = 2147483647; /*??范围和int一样？？*/
		
		float f;
		double lf = 123456789.123456789;
		
		b = a;
		c = (int)d;
		f = (float)lf;
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		System.out.println("d = " + d);
		System.out.println("l = " + f);
		System.out.println("lf = " + lf);
	}
}
