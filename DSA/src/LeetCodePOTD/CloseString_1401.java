package LeetCodePOTD;

// https://leetcode.com/problems/determine-if-two-strings-are-close/
// leetCode75

public class CloseString_1401 {
	public boolean closeStrings(String word1, String word2) {
		int[] arr1 = new int[26];
		int[] arr2 = new int[26];

		for(char ch : word1.toCharArray()) arr1[ch - 'a']++;
		for(char ch : word2.toCharArray()) arr2[ch - 'a']++;

		for(int i=0;i<26;i++)
		{
			if((arr1[i] == 0 && arr2[i] != 0) || (arr1[i] != 0 && arr2[i] == 0)) return false;
			int x = arr1[i];
			int y = arr2[i];

			for(int j =i+1 ; j<26 ; j++)
			{
				if(arr1[j] == y)
				{
					arr1[i] = y;
					arr1[j] = x;
					break;
				}
			}
		}

		for(int i=0 ; i<26; i++)
		{
			if(arr1[i] != arr2[i]) return false;
		}

		return true;
	}
}