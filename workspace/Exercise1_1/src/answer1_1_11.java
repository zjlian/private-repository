import mylib.StdOut;

public class answer1_1_11 {
	public static void main(String[] ages) {
		boolean[][] boolList = new boolean[10][10];
		
		for(int i = 0; i < boolList.length; i++) {
			StdOut.print("  " + i);
			boolList[i][i] = true;
		}
		StdOut.print('\n');
		
		for(int i = 0; i < boolList.length; i++) {
			StdOut.print(i);
			for(int j = 0; j < boolList[i].length; j++) {
				char flag = (boolList[i][j] == true) ? '*' : ' ';
				StdOut.printf(" %c ",flag);
			}
			StdOut.print('\n');
		}
		
	}
}
