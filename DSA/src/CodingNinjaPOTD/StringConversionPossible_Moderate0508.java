package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

public class StringConversionPossible_Moderate0508 
{
	public static void main(String[] args)
	{
		String res = isPossible("abc", "abc", 3 , 3);
		System.out.println(res);
	}
    public static String isPossible(String a, String b, int n, int k) 
    {
        // Write your code here
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        for(char ch : a.toCharArray()) map1[ch-'a']++;
        for(char ch : b.toCharArray()) map2[ch-'a']++;
        
        for(int i=0;i<26;i++)
        {
            if(i != 0)
            {
            	map1[i] = map1[i]+map1[i-1];
            }
            if(map1[i] < map2[i]) return "No";

            map1[i] =  map1[i]- map2[i];

            if(map1[i]%k != 0) return "No";
        }

        return "Yes";
    }
}