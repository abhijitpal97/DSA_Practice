package com.example.uncategorized;

import java.util.*;

public class FourSum {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int n = arr.length;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i = 0; i<n-3;i++)
        {
            for(int j = i+1 ; j<n-2;j++)
            {
                
            int low = j+1;
            int high = n-1;
            int tar = k - arr[i] - arr[j];
            
            while(low<high)
            {
                if(arr[low] + arr[high] == tar)
                {
                    result.add(new ArrayList<>(Arrays.asList(arr[i],arr[j],arr[low],arr[high])));
                    while(low+1<n && arr[(low+1)]==arr[low])low++; 
                    while(high-1>low && arr[(high-1)]==arr[high])high--; 
                    low++;
                    high--;
                }
                else if(arr[low] + arr[high] > tar) high --;
                else low++;
            }
            while((j+1)<n && arr[(j+1)]==arr[j])j++; 
        
            }
            while((i+1)<n && arr[(i+1)]==arr[i])i++;
           
        }
        return result;
    }
    
    
}