package LeetCodePOTD;

public class KthGrammer_2510 {
	public static void main(String[] args)
	{
		int res = kthGrammar(2, 1);
		System.out.println(res);
	}

	// Time Complexity - O(2^n)
	public static int kthGrammar(int n, int k) {
		String res = "0";
		while(n>1)
		{
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<res.length();i++)
			{
				char ch = res.charAt(i);
				if(ch == '0') sb.append("01");
				if(ch == '1') sb.append("10");
			}
			res = sb.toString();
			n--;
		}
		return res.charAt(k-1) - '0';
	}

	// Time Complexity - O(n)

	public int kthGrammarOptimized(int n, int k) {


		boolean flag = true;
		n = (int)Math.pow(2,n);

		while(n != 1)
		{
			n /= 2;
			if(k>n)
			{
				k -= n;
				flag = !flag;
			}
		}

		return flag?0:1;

	}
}