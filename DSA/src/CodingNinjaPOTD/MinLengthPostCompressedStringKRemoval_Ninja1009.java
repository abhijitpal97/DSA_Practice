package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

public class MinLengthPostCompressedStringKRemoval_Ninja1009 {

	public static void main(String[] args)
	{
		int res = minLengthOfCompressedString("goofood", 1);
		System.out.println(res);;
	}

	public static int minLengthOfCompressedString(String str, int k)  {
		Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		str = encodeString(str , pq );
		while(pq.peek()>k) pq.poll();
		if(pq.peek() == k) return str.length()-pq.peek();
		else
		{
			int curr = 0;
			while(pq.peek()<=k)
			{
				curr += pq.peek();
				k -= pq.poll();

				if(pq.peek() == k) return str.length() - curr - pq.peek();
			}

			return str.length()-curr;
		}
	}

	static String encodeString(String str , Queue<Integer> pq)
	{
		StringBuilder sb = new StringBuilder();
		int n = str.length();
		for(int i=0;i<n;i++)
		{
			int count = 1;
			while(i+1 < n && str.charAt(i)==str.charAt(i+1))
			{
				i++;
				count++;
			}
			if(count>1) 
			{
				sb.append(str.charAt(i)).append(count);
				pq.offer(count+1);
			}
			else 
			{
				sb.append(str.charAt(i));
				pq.offer(1);
			}
		}

		return sb.toString();
	}
}