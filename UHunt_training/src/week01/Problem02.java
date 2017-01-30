package week01;

import java.util.Arrays;

/*
 * Problem 12545
 * Bits Equalizer
 * Status: Accepted
 * Kan forbedres. String i stedet for arrays. Skru ned for gennemløbninger...
 */
import java.util.Scanner;
public class Problem02 {
	public static void main(String[] args) {
		Problem02 main = new Problem02();
		main.begin();
	}

	public void begin() {
		Scanner in = new Scanner(System.in);
		int cases = Integer.parseInt(in.nextLine().trim());
		int caseNr = 0;
		String ss, ts;

		while (caseNr < cases) {
			caseNr++;
			ss = in.nextLine().trim();
			ts = in.nextLine().trim();
			System.out.print("Case " + caseNr + ": ");
			getResult(ss, ts);
		}

		in.close();
	}

	public void getResult(String ss, String ts) {
		char[] s = ss.toCharArray();
		char[] t = ts.toCharArray();
		int s0 = 0, s1 = 0, sQ = 0;
		int t0 = 0, t1 = 0;
		for (int i = 0; i < ts.length(); i++) {
			if (t[i] == '0') {
				t0++;
			} else {
				t1++;
			}
			if (s[i] == '0') {
				s0++;
			} else if (s[i] == '1') {
				s1++;
			} else {
				sQ++;
			}
		}

		int moves = 0;
		// hvis flere 1'ere i s end t => moves = -1
		if (s1 > t1) {
			moves = -1;
		} else {
			if (s0 >= t0) { // Flipper alle ?'ere til 1'ere
				for (int j = 0; j < s.length; j++) {
					if (s[j] == '?') {
						s[j] = '1';
						sQ--;
						s1++;
						moves++;
					}
				}
			} else {
				// Bliver ved til ikke flere ?'ere
				int i0 = 0, i1 = 0, k = 0;
				//Flipper ?=>0
				while (sQ > 0 && t0 > s0 && i0 < s.length) {
					if (s[i0] == '?') {
						if (t[i0] == '0') {
							s[i0] = '0';
							moves++;
							sQ--;
							s0++;
						}
					}
					i0++;
				}
				//Flipper ?=>1
				while (sQ > 0 && t1 > s1 && i1 < s.length) {
					if (s[i1] == '?') {
						if (t[i1] == '1') {
							s[i1] = '1';
							moves++;
							sQ--;
							s1++;
						}
					}
					i1++;
				}
				//Flipper resterende ?'ere
				while (sQ > 0 && k < s.length) {
					if (s[k] == '?') {
						if (s0 < t0) {
							s[k] = '0';
							s0++;
							moves++;
						} else {
							s[k] = '1';
							s1++;
							moves++;
						}
						sQ--;
					}
					k++;
				}
			}
			// Flipper 0=>1. Samtidig med swap?
			int l = 0;
			while (s0 > t0 && l < s.length) {
				if (s[l] == '0' && t[l] == '1') {
					s[l] = '1';
					s0--;
					s1++;
					moves++;
				}
				l++;
			}
			moves += sort(s, t);
		}		
		System.out.println(moves);
	}

	private void swap(char[] s, int i, int j) {
		char temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}

	private int sort(char[] s, char[] t) {
		int i = 0, j = 1, moves = 0;
		while (i < s.length-1) {
			if (s[i] != t[i]) {
				j = i + 1;
				boolean found = false;
				while (!found) {
					if (s[i] != s[j] && s[j] != t[j]) {
						swap(s, i, j);
						moves++;
						found = true;
					}else{
						j++;						
					}
				}
			}
			i++;
		}
		return moves;
	}
}