import mylib.StdOut;

public class answer1_1_16 {
	public static int flag = 0;
	public static double binomial(int n,int k,double p) {
		flag++;
		if(n == 0 && k == 0) return 1.0;
		if(n < 0 || k < 0) return 0.0;
		return (1.0 - p) * binomial(n-1, k, p) + p * binomial(n-1, k-1, p);
	}
	
	public static void main(String[] args) {
		binomial(100, 50, 0.25);
		StdOut.println(flag);
	}
}
