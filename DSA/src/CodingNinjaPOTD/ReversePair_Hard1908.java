package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class ReversePair_Hard1908 
{
    public static int reversePairs(ArrayList<Integer> arr) 
    {
        // Write your code here.
        int count =0;
        int n = arr.size();
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(arr.get(i)>arr.get(j)*2) count++;
            }
        }

        return count;
    }
}