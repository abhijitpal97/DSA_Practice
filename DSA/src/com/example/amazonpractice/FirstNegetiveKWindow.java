package com.example.amazonpractice;

public class FirstNegetiveKWindow {
	public static int[] firstNegative(int[] arr, int n, int k) {
        // Write your code here.
		int[] result = new int[n-k+1];
        int start = 0;
        int end = start+k;
        int index=0;
        while(end<=n)
        {
            int firstneg=0;
            for(int i=start; i<end;i++)
            {
                if(arr[i]<0)
                {
                    firstneg = arr[i];
                    break;
                }
            }
            result[index] = firstneg;
            start++;
            end++;
            index++;
            
        }
        
        return result;
	}
}