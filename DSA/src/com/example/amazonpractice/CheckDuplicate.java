package com.example.amazonpractice;
import java.util.* ;
import java.io.*; 

public class CheckDuplicate {
    public static boolean checkDuplicate(int[] arr, int n, int k) {
        // Write your code here.
        List<Integer> list = new ArrayList<>();
        int counter = k+1;
        int i = 0;
        while(i<n)
        {
            if(counter == 0) 
            {
                list.remove(list.size()-1);
                counter += 1;
            }
            if(list.contains(arr[i])) return true;
            list.add(0 , arr[i]);
            i++;
            counter--;
        }

        return false;
        
    }
}