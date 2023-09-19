package com.example.gspractice;
public class MagicPotion
{
	public static void main(String[] args)
	{
		String str = getString("ABABCABABCE");
		System.out.println(str);
		str = getString("AAABCABABCE");
		System.out.println(str);
		str = getString("AAAAAA");
		System.out.println(str);
		str = getString("ABABCDEF");
		System.out.println(str);
		str = getString("ABCDE");
		System.out.println(str);
		str = getString("ABCABCXYZABCD");
		System.out.println(str);
	}

	static String getString(String str)
	{
		StringBuilder sb = new StringBuilder();

		while(str.length()>0)
		{
			int len = str.length();
			if(len%2 == 1)
			{
				sb.insert(0,str.charAt(len-1));
				str = str.substring(0 , len-1);
			}
			else
			{
				int mid = len/2;
				String s1 = str.substring(0 ,mid);
				String s2 = str.substring(mid , len);
				if(s1.equals(s2))
				{
					sb.insert(0,'*');
					str = str.substring(0 , mid);
				}
				else
				{
					sb.insert(0 , s2);
					str = str.substring(0 , mid);
				}
			}
		}

		return sb.toString();
	}
}
