
import java.util.*;
public class Remove_k_digits
{
  public static String reverse (String name)
  {
	if (name.length () < 1)
	  {
		return name;
	  }
	return reverse (name.substring (1)) + name.charAt (0);
  }

  public static String removeKdigits (String s, int k)
  {
	Stack < Character > stack = new Stack <> ();
	for (int i = 0; i < s.length (); i++)
	  {
		char ch = s.charAt (i);

		//Comparing the current character with top of stack 
		while (!stack.isEmpty () && k > 0 && ch < stack.peek ())
		  {
			stack.pop ();
			k--;
		  }
		stack.push (ch);
	  }



	StringBuilder st = new StringBuilder ();
	//Converting string from stack to strig builder
	while (!stack.isEmpty ())
	  {
		if (k > 0)
		  {
			stack.pop ();
			k--;
		  }
		else
		  {
			st.insert (0, stack.pop ());
		  }

	  }
	// Dealing with leading '0' case 
	while (st.length () > 0 && st.charAt (0) == '0')
	  {
		st.deleteCharAt (0);
	  }

	if (st.length () == 0)
	  {
		return "0";
	  }
	return st.toString ();
  }
  public static void main (String[]args)
  {
	System.out.println ("Hello World");
	String rev = "Hello World";
	String num = "1432219";
	int k = 3;
	System.out.println (removeKdigits (num, 3));
//      System.out.println(reverse(rev));
  }
}
