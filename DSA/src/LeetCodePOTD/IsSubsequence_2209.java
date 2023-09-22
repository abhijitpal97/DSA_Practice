package LeetCodePOTD;

public class IsSubsequence_2209 {
	public boolean isSubsequence(String s, String t) {
		return function(s,t,0,0);
	}

	boolean function(String s , String t , int n , int m)
	{
		if(n == s.length()) return true;
		if(m == t.length()) return false;

		boolean e=false;
		boolean l=false;
		if(s.charAt(n) == t.charAt(m)) e = function(s , t , n+1 , m+1);
		else
		{
			l = function(s,t,n,m+1);
		}

		return e||l;
	}
}