package com.example.microsoftpractice;

// https://leetcode.com/problems/remove-k-digits/description/

public class RemoveKDigits {
	static long min = Long.MAX_VALUE;

	public static void main(String[] args)
	{
		String str = removeKdigits("1432219", 3);
		System.out.println(str);
	}

	public static String removeKdigits(String num, int k) {
		while(num.length()>1 && num.startsWith("0")) num=num.substring(1);
		if(num.length()<=k) return "0";
		if(k == 0) return num.length()>0?num:"0";
		int i=0;
		while(i<num.length()-1 && num.charAt(i)-'0' <= num.charAt(i+1)-'0') i++;

		return removeKdigits(num.substring(0,i)+num.substring(i+1), k-1);
	}
	
	// Recursion 
	int smallest = Integer.MAX_VALUE;
    public String removeKdigitsRec(String num, int k) {
        smallest = Integer.MAX_VALUE;
        if(num.length() == k) return "0";
        helper(num , "" , k);
        return String.valueOf(smallest);
    }

    void helper(String str , String ref , int k)
    {
        if(k==0)
        {
            smallest = Math.min(smallest , Integer.valueOf(ref+str));
            return;
        }
        if(str.length() == 0) return;
        
        helper(str.substring(1) , ref+str.charAt(0) , k);
        helper(str.substring(1), ref , k-1);
    }
}