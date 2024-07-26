/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

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