package LeetCodePOTD;

// https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string

public class MinOperation_2412 {
	public int minOperations(String s) {
		int x = startWithZero(s);
		int y = startWithOne(s);

		return Math.min(x,y);
	}

	int startWithZero(String str)
	{
		char prev = '0';
		int count = str.charAt(0)=='0'?0:1;
		for(int i = 1;i<str.length();i++)
		{
			char ch = str.charAt(i);
			if(prev=='0')
			{
				if(ch == '1')
				{
					prev = ch;
					continue;
				}
				else
				{
					prev = '1';
					count++;
				}

			}
			else if(prev == '1')
			{
				if(ch == '0')
				{
					prev = ch;
					continue;
				}
				else
				{
					prev = '0';
					count++;
				}
			}
		}
		return count;
	}

	int startWithOne(String str)
	{
		char prev = '1';
		int count = str.charAt(0)=='1'?0:1;
		for(int i = 1;i<str.length();i++)
		{
			char ch = str.charAt(i);
			if(prev=='0')
			{
				if(ch == '1')
				{
					prev = ch;
					continue;
				}
				else
				{
					prev = '1';
					count++;
				}

			}
			else if(prev == '1')
			{
				if(ch == '0')
				{
					prev = ch;
					continue;
				}
				else
				{
					prev = '0';
					count++;
				}
			}
		}
		return count;
	}
}