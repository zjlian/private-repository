import mylib.StdRandom;
import mylib.StdIn;
import mylib.StdOut;
import classDemo.Counter;

public class app {
	
	public static void main(String[] ages) {
		int T = StdIn.readInt();
		
		Counter heads = new Counter("heads");
		Counter tails = new Counter("tails");
		
		for(int t = 0; t < T; t++)
			if(StdRandom.bernoulli(0.5))
				heads.increment();
			else tails.increment();
		
		StdOut.println(heads);
		StdOut.println(tails);
	}
}











