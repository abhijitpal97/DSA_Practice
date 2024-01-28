package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/goodness-of-a-string_1266049

public class GoodNessOfString_Moderate2801 {
	public static void main(String[] args)
	{
		int res = goodnessOfString("[10,20,30,40]");
		System.out.println(res);
	}
	public static int goodnessOfString(String s) {
		// Write your code here.
		int sum = 0;
		int depth = 0;

		for(int i=0;i<s.length() ; i++)
		{
			char ch = s.charAt(i);
			if(ch == '[') depth++;
			if(ch == ']') depth--;

			int num = 0;
			while(
					s.charAt(i) != '[' && 
					s.charAt(i) != ']' && 
					s.charAt(i) != ','
					)
			{
				ch = s.charAt(i);
				int curr = ch - '0';
				num = num*10 + curr;
				if(s.charAt(i+1) == '[' || 
						s.charAt(i+1) == ']' || 
						s.charAt(i+1) == ',') break;

				i++;
			}

			sum += num*depth;

		}

		return sum;
	}
}