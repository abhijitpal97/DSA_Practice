package CodingNinjaPOTD;
import java.util.*;

public class LongestRepeatingSubstringWithKFlip_Moderate1709 {
	public static int longestRepeatingSubstring(String str, int k) {
		// Write your code here.
		Map<Character , Integer> map = new HashMap<>();
		int left = 0;
		int n = str.length();
		int maxWindow = 0;
		int maxRepeat = 0;

		for(int i = 0 ; i<n ; i++)
		{
			char ch = str.charAt(i);

			map.put(ch , map.getOrDefault(ch , 0)+1);

			maxRepeat = Math.max(maxRepeat , map.get(ch));

			if(i-left+1-maxRepeat > k)
			{
				char remove = str.charAt(left);
				map.put(remove , map.get(remove)-1);
				left++;
			}

			maxWindow = Math.max(maxWindow , i-left+1);
		}

		return maxWindow;
	}
}
