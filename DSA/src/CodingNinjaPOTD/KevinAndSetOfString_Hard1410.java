package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

// https://www.codingninjas.com/studio/problems/kevin-and-set-of-strings_1170535

public class KevinAndSetOfString_Hard1410 
{
	public static void main(String[] args)
	{
		int res = distinctStrings(new ArrayList<>(Arrays.asList("xbya","xyab",
				"axby","xayb")), 4);
		System.out.println(res);
	}
	public static int distinctStrings(ArrayList<String> arr, int n)
	{
		//    Write your code here.
		boolean[] isProcessed = new boolean[n];
		int count = 0;
		for(int i=0;i<n;i++)
		{
			if(isProcessed[i] == true) continue;
			String str = arr.get(i);
			int[] odd = new int[26];
			int[] even = new int[26];

			for(int j=0;j<str.length();j++)
			{
				char ch = str.charAt(j);
				if(j%2 == 0) even[ch - 'a']++;
				else odd[ch - 'a']++;
			}

			for(int k = i+1;k<n;k++)
			{
				String str1 = arr.get(k);
				int[] odd1 = new int[26];
				int[] even1 = new int[26];

				for(int l=0;l<str1.length();l++)
				{
					char ch = str1.charAt(l);
					if(l%2 == 0) even1[ch - 'a']++;
					else odd1[ch - 'a']++;
				}

				boolean flag = false;
				for(int m=0;m<26;m++)
				{
					if(odd[m] !=odd1[m])
					{
						flag = true;
						break;
					}
					if(even[m] !=even1[m])
					{
						flag = true;
						break;
					}
				}
				if(! flag) isProcessed[k] = true;
			}
		}

		for(int i = 0;i<n;i++)
		{
			if(isProcessed[i] == false) count++;
		}

		return count;
	}
}