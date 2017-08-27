package app;
import linkedSeries.LinkedStack;
import stdio.stdio;

public class BracketCompletion {

	public static void main(String[] args) {
		LinkedStack<String> str = new LinkedStack<String>();
		LinkedStack<String> ops = new LinkedStack<String>();
		
		stdio.print("> ");
		String tmp = stdio.readLine();
		//String result = "";
		
		String[] s = tmp.split("\\s+");
		for(int i = 0; i < s.length; i++) {
			String c = s[i];
			if(c.equals("+")) 	   ops.push(c);
			else if(c.equals("-")) ops.push(c);
			else if(c.equals("*")) ops.push(c);
			else if(c.equals("/")) ops.push(c);
			else if(c.equals(")")) {
				String v = str.pop();
				str.push("( " + str.pop() + " " + ops.pop() + " " + v + " )");
			} else {
				str.push(c);
			}
		}
		stdio.println(str.peek());
	}

}
