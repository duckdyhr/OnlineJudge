package week01;
/*
 * Problem 1585
 * Score
 * Status: Accepted
 */

import java.util.Scanner;

public class Problem01 {
	public static void main(String[] args) {
		Problem01 main = new Problem01();
		main.begin();
	}
	
	public void begin(){
		Scanner in = new Scanner(System.in);
		int lines = Integer.parseInt(in.nextLine().trim());
		
		String result = "";
		for(int i = 0; i < lines; i++){
			result = in.nextLine().trim();
			parseResult(result);
		}
		in.close();
	}
	public void parseResult(String result){
		int sum = 0;
		int last = 0;
		for(int i = 0; i < result.length(); i++){
			char current = result.charAt(i);
			if(current == 'O'){
				last++;
				sum += last;
			}else{
				last = 0;
			}
		}
		System.out.println(sum);
	}
}