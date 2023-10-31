package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class CountBeautifulPairs_Hard3010 {
    public static int countBeautifulPairs(ArrayList<Integer> arr, int low, int high) {
        // Write your code here.
        int count = 0;
        int n = arr.size();
        for(int i=0;i<n;i++)
        {
            for(int j =i ; j<n ; j++)
            {
                int res = arr.get(i)^arr.get(j);
                if(low<=res && res<=high) count++;
            }
        }

        return count;
    }
}