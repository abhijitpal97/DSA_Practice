package CodingNinjaPOTD;

public class LongestCommonPrefix_Moderate2808 {
	public static String longestCommonPrefix(String[] arr, int n) {
		// Write your code here
		if(arr.length == 1) return arr[0];
		String curr = arr[0];
		for(int i = 1 ; i<arr.length ; i++)
		{
			curr = longest(arr[i] , curr);
		}

		return curr;
	}

	static String longest(String str , String curr)
	{
		if(str.equals(curr)) return str;
		if(str.indexOf(curr) == 0) return curr;
		if(curr.indexOf(str) == 0) return str;

		int i = 0 ;
		int j = 0;
		int n = str.length();
		int m = curr.length();

		while(i<n && j<m)
		{
			if(str.charAt(i) == curr.charAt(j))
			{
				i++;
				j++;
			}
			else return str.substring(0 , i);
		}

		return str.substring(0 , i);
	}

}
