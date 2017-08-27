package app;
import ST.BinarySearchST;

import stdio.stdio;
import tool.Stopwatch;

public class FrequencyCounter {
	
	private FrequencyCounter() {}
	
	public static void main(String[] args) {
		Stopwatch shit = new Stopwatch();
		int distinct = 0, words = 0;
		int minlen = Integer.parseInt(args[0]);
		BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>(100000);
		
		while(!stdio.isEmpty()) {
			
			String key = stdio.readString();
			
			if(key.length() < minlen) continue;
			words++;
			
			if(st.contains(key)) {
				st.put(key, st.get(key) + 1);
			} else {
				st.put(key, 1);
				distinct++;
			}
		}
		
		String max = "";
		st.put(max, 0);
		for(String word : st.keys()) {
			if(st.get(word) > st.get(max))
				max = word;
		}
		double enjoy = shit.elapsedTime();
		stdio.println(max + " " + st.get(max));
		stdio.println("不重复个数 " + distinct);
		stdio.println("单词总数 " + words);
		stdio.println("\n--====================================--\n Process exited after " + enjoy / 1000 + " s");
	}
}
