package app;
import stdio.stdio;
import linkedSeries.LinkedStack;
public class BracketsMatch {
	/*用栈实现括号匹配*/
	public static boolean bracketsMatch(String s) {
		LinkedStack<Character> fuck = new LinkedStack<Character>();
		char[] tmp = s.toCharArray();
		
		for(int i = 0; i < tmp.length; i++) {
			if(tmp[i] == '(') fuck.push(tmp[i]);
			else if(tmp[i] == '[') fuck.push(tmp[i]);
			else if(tmp[i] == '{') fuck.push(tmp[i]);
			else if(tmp[i] == ')' || tmp[i] == ']'  || tmp[i] == '}' ){
				if(tmp[i] == ')') return fuck.pop() == '(';
				else if(tmp[i] == ']') return fuck.pop() == '[';
				else if(tmp[i] == '}') return fuck.pop() == '{';
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String tmpS = stdio.readString();
		stdio.println(bracketsMatch(tmpS));
	}

}
