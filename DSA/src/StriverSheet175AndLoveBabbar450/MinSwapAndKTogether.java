package StriverSheet175AndLoveBabbar450;

// https://www.geeksforgeeks.org/problems/minimum-swaps-required-to-bring-all-elements-less-than-or-equal-to-k-together4847/1
 public class MinSwapAndKTogether{
    
   
    // Function for finding maximum and value pair
    public static int minSwap (int arr[], int n, int k) {
        //Complete the function
        int good = 0;
        int bad =0;
        int ans =Integer.MAX_VALUE;
        
        for(int i=0 ; i<n;i++)
        {
            if(arr[i]<=k) good++;
        }
        
        for(int i=0 ; i<n-good+1;i++)
        {
            for(int j = i ; j<i+good;j++)
            {
                if(arr[j]>k) bad++;
            }
            ans = Math.min(ans,bad);
            bad=0;
        }
        
        return ans;
    }
    
    
}
