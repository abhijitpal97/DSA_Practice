package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/get-palindromic_975494

public class AllPalindromicNumberTillN_Moderate2707 {
	public static int[] getPalindromes(int n) {

		// Write your code here
		List<Integer> list = new ArrayList<>();
		for(int i=1;i<=n;i++)
		{
			if(isPalindromic(i)) list.add(i);
		}


		int[] res = new int[list.size()];
		for(int i=0;i<list.size();i++)
		{
			res[i] = list.get(i);
		}
		return res;

	}

	static boolean isPalindromic(int n)
	{
		int num = n;
		int rev = 0;
		int div = 0;
		while(n != 0)
		{
			int rem = n%10;
			rev = (rev*10)+rem;
			n = n/10;
		}
		//System.out.println(num +" - "+rev+" -- "+ (num==rev));
		return num==rev;
	}
}
