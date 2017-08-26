package app;
import linkedSeries.LinkedStack;
import stdio.stdio;

public class InfixToPostfix {
	private String[] s;
	private LinkedStack<String> str;
	private LinkedStack<String> ops;
	
	public InfixToPostfix(String S) {
		s = S.split("\\s+");
		str = new LinkedStack<String>();
		ops = new LinkedStack<String>();
	}

	public String getResult() {

		for(int i = 0; i < s.length; i++) {
			String c = s[i];
			if(c.equals("("));
			else if(c.equals("+")) ops.push(c);
			else if(c.equals("-")) ops.push(c);
			else if(c.equals("*")) ops.push(c);
			else if(c.equals("/")) ops.push(c);
			else if(c.equals(")")) {
				String v = str.pop();
				str.push(str.pop() + " " + v + " " + ops.pop());
			} else {
				str.push(c);
			}
		}
		return str.peek();
	}

	public static void main(String[] args) {
		InfixToPostfix ITP = new InfixToPostfix("( ( 2 + 20 ) * 60 )");
		stdio.print("> ");
		String tmp = stdio.readLine();
		
		stdio.println(ITP.getResult());

	}

}
