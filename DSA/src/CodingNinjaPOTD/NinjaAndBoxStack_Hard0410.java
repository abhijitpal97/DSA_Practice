package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/ninja-and-stack-of-StackPairBoxes_1199337?leftPanelTab=0
//https://leetcode.com/problems/maximum-height-by-stacking-cuboids/description/


class StackPairBox implements Comparable<StackPairBox>
{
	int l;
	int b;
	int h;
	int area;

	StackPairBox(int l , int b , int h)
	{
		this.l=l;
		this.b=b;
		this.h=h;
		this.area = l*b;
	}

	public int compareTo(StackPairBox that)
	{
		return this.area - that.area;
	}

}

public class NinjaAndBoxStack_Hard0410 
{
	public static int ninjaAndStackPairBoxStack(int length[], int breadth[], int height[], int n) 
	{
		// Write your code here.
		List<StackPairBox> StackPairBoxes = new ArrayList<>();
		for(int i = 0;i<n;i++)
		{
			StackPairBoxes.add(new StackPairBox(Math.max(length[i], breadth[i]), Math.min(length[i], breadth[i]), height[i]));
			StackPairBoxes.add(new StackPairBox(Math.max(height[i], breadth[i]), Math.min(height[i], breadth[i]), length[i]));
			StackPairBoxes.add(new StackPairBox(Math.max(length[i], height[i]), Math.min(length[i], height[i]), breadth[i]));
		}

		Collections.sort(StackPairBoxes);
		Integer[] dp = new Integer[StackPairBoxes.size()];
		int max = 0;

		for(int i = 0;i<StackPairBoxes.size();i++)
		{
			max = Math.max(max , helper(StackPairBoxes , i , dp));
		}
		return max;
	}

	static int helper(List<StackPairBox> StackPairBoxes , int curr , Integer[] dp)
	{
		if(dp[curr] != null) return dp[curr];

		int max = 0;
		for(int i = curr+1;i<StackPairBoxes.size();i++)
		{
			if(StackPairBoxes.get(curr).l<StackPairBoxes.get(i).l && StackPairBoxes.get(curr).b<StackPairBoxes.get(i).b)
			{
				max = Math.max(max , helper(StackPairBoxes , i,dp));
			}

		}
		max +=StackPairBoxes.get(curr).h;
		dp[curr] = max;
		return max;
	}
}
