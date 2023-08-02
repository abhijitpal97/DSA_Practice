package CodingNinjaPOTD;
import java.util.ArrayList;
import java.util.Arrays;

public class RussianDollEnvelops_Hard0208 {
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args)
	
	{
		int res = findMaxEnvelopes(new ArrayList<>(Arrays.asList(10,2,7,3,3,5,6,4)), 
				new ArrayList<>(Arrays.asList(2,1,1,8,3,8,10,2)), 8);
		System.out.println(res);
	}

	public static int findMaxEnvelopes(ArrayList<Integer> height, 
			ArrayList<Integer> width, int n) {
		// Write your code here.
		max = Integer.MIN_VALUE;
		int[][] envelopes = new int[n][2];
		for(int i=0;i<n;i++)
		{
			envelopes[i][0] = height.get(i);
			envelopes[i][1] = width.get(i);
		}

		Arrays.sort(envelopes , (a,b) ->
		{
			if(b[0] == a[0]) return b[1]-a[1];
			return b[0]-a[0];
		});

		helper(envelopes , 0 , 0 , n ,  new int[]{Integer.MAX_VALUE , Integer.MAX_VALUE});
		return max;
	}

	static void helper(int[][] envelopes , int index , int count , int n , int[] prev)
	{
		if(index == n)
		{
			max = Math.max(max , count);
			return;
		}
		//pick
		if(prev[0] == Integer.MAX_VALUE || 
				((envelopes[index][0] < prev[0]) && (envelopes[index][1] < prev[1]))) 
		{
			helper(envelopes , index+1 , count+1 , n , envelopes[index]);
		}
		helper(envelopes , index+1 , count , n , prev);
	}
	
	// Binary Search
    public int maxEnvelopes(int[][] envelopes) {
        
    Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
    int ans = 0;
    int[] dp = new int[envelopes.length];
    for (int[] e : envelopes) {
      int i = Arrays.binarySearch(dp, 0, ans, e[1]);
      if (i < 0)
        i = -(i + 1);
      dp[i] = e[1];
      if (i == ans)
        ++ans;
    }
    return ans;

    }

}