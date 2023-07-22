package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

public class DigitProductEqualToNumber_Moderate2207 {

	public static int digitProduct(int n) {
		// Write your code here.
		int temp = n;

		for(int i=2;i<9;i++)
		{
			while(temp%i == 0)
			{
				temp = temp/i;
			}
		}

		if(temp >9) return -1;
		
		int ans = 1;
		
		while(true)
		{
			int mul = helper(ans);
			
			if(mul == n) return ans;
			
			ans++;
		}
	}

	static int helper(int nums)
	{
		int res = 1;
		while(nums >0)
		{
			int rem = nums%10;
			nums = nums/10;
			res = res*rem;
		}

		return res;
	}

}
