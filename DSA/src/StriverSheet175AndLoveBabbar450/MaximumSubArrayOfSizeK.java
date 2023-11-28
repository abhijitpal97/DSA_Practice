package StriverSheet175AndLoveBabbar450;
import java.util.* ;
import java.io.*; 
// https://www.codingninjas.com/studio/problems/maximum-of-all-subarrays-of-size-k_1170789

public class MaximumSubArrayOfSizeK 
{

    public static ArrayList<Integer> maxOfSubarray(ArrayList<Integer> nums, int n, int k) 
	{
        // Write your code here. 
        ArrayList<Integer> list = new ArrayList<>();

        int start = 0;
        int end = start+k-1;

        while(end<n)
        {
            int max = Integer.MIN_VALUE;
            for(int i=start;i<=end;i++)
            {
                max = Math.max(max , nums.get(i));
            }
            start++;
            end++;
            list.add(max);
        }

        return list;
    }

}