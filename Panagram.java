/******************************************************************************
Problem statement: Given a string str and an integer k, return true if the string can be changed into a pangram after at most k operations, else return false.
A single operation consists of swapping an existing alphabetic character with any other lowercase alphabetic character.
Note - A pangram is a sentence containing every letter in the english alphabet.
*******************************************************************************/
import java.util.*;
public class Panagram
{
	public static boolean isPangram(String str, int k) {
		// code here
		str = str.toLowerCase();
		str = str.replace(" ","");
		int n = str.length();
		if(n<26) {
			return false;
		}

		HashSet<Character> alphabet = new HashSet<>();

		for(int i=0; i<n; i++) {
			char ch = str.charAt(i);

			if(ch == ' ') {
				continue;
			}

			if(ch>='a' && ch<='z') {
				alphabet.add(ch);
			}
		}
        System.out.println("HashSet: "+alphabet);
		int missed_characters = 26-alphabet.size();

		return missed_characters<=k;

	}
}
