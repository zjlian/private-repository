package app;
import stack.Stack;
import stdio.*;

public class Evaluate {

	public static void main(String[] args) {
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		
		String str = stdio.readLine();
		
		String[] tmp = str.split("\\s+");
		
		for(int i = 0; i < tmp.length; i++) {
			String s = tmp[i];
			if(s.equals("("));
			else if(s.equals("+")) ops.push(s);
			else if(s.equals("-")) ops.push(s);
			else if(s.equals("*")) ops.push(s);
			else if(s.equals("/")) ops.push(s);
			else if(s.equals("sqrt")) ops.push(s);
			else if(s.equals(")")) {
				String op = ops.pop();
				double v = vals.pop();
				if(op.equals("+")) v = vals.pop() + v;
				else if(op.equals("-")) v = vals.pop() - v;
				else if(op.equals("*")) v = vals.pop() * v;
				else if(op.equals("/")) v = vals.pop() / v;
				else if(op.equals("sqrt")) v = Math.sqrt(v);
				vals.push(v);
			}
			else
				vals.push(Double.parseDouble(s));
		}
		
		stdio.println(vals.pop());
	}
}
