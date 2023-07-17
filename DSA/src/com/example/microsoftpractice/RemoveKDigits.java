package com.example.microsoftpractice;


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
}