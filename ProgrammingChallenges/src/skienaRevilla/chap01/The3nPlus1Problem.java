package skienaRevilla.chap01;

import java.util.Scanner;

public class The3nPlus1Problem {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		while(in.hasNextLine()){
			line = in.nextLine();
		}
		in.close();
	}
}
