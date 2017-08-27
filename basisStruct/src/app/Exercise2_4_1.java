package app;
import queue.MaxQueue;
import stdio.stdio;

public class Exercise2_4_1 {
	
	public static String[] getSequence() {
		String tmp = stdio.readLine();
		String[] seq = tmp.split("\\s+");
		return seq;
	}
	/*
	 *  用序列 P R I O * R * * I * T * Y * * * Q U E * * * U * E (字母表示插入元素，*号表示删除最大元素)
	 *  给出每次删除元素的值
	 **/
	public static void main(String[] args) {
		MaxQueue<String> shit = new MaxQueue<String>();
		String[] seq = getSequence();
		
		for(int i = 0; i < seq.length; i++) {
			if(!seq[i].equals("*"))  shit.insert(seq[i]);
			else  stdio.printf("%s", shit.delMax());
		}
	}

}
