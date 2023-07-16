package CodingNinjaPOTD;
import java.util.*;

public class FindGoodNumber_Moderate1507 {
	public static boolean isGoodNumber(int n) {
		// Write your code here.
		Set<Integer> set = new HashSet<>();
		set.add(n);
		while(n != 1)
		{
			n = generateSquare(n);
			if(!set.add(n)) return false;			
		}
		return true;
	}

	static int generateSquare(int nums)
	{
		String curr = String.valueOf(nums);
		int res = 0;
		char[] chs = curr.toCharArray();
		for(char ch : chs)
		{
			int temp = Character.getNumericValue(ch);
			//System.out.println(temp);
			res += temp*temp;
		}
		return res;
	}
}