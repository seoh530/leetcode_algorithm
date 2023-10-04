package algorithm;

import java.util.Scanner;

public class FindtheDifference {

	public static void main(String[]args) {
		Scanner sc  = new Scanner(System.in);
		
		String s = sc.nextLine();
		String t = sc.nextLine();
		
		System.out.println("The result is: "+findTheDifference(s,t));
	}

	public static char findTheDifference(String s, String t) {
		//using XOR
		char result = 0;
		for(int i = 0; i<s.length(); i++) {
			result ^= s.charAt(i);
		}
		for(int i = 0; i<t.length(); i++) {
			result ^= t.charAt(i);
		}
		return result;
	}
	/*
	 * public char findTheDifference(String s, String t) {
        char result = 0; 
        for (char c : s.toCharArray()) {
            result ^= c; 
        }
        for (char c : t.toCharArray()) {
            result ^= c; 
        }
        
        return result;
    }
	 */
}

