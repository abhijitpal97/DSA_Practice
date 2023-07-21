package CodingNinjaPOTD;
import java.util.*;

public class AggressiveCows_Moderate2107 {
    public static int aggressiveCows(int []stalls, int k) {
        //    Write your code here.
        Arrays.sort(stalls);

        int n = stalls.length;

        int low = 1;
        int high = stalls[n-1]-stalls[0];

        while(low <=high)
        {
            int mid = low + (high-low)/2;

            if(canweUse(stalls , mid , k ) == true) low = mid+1;
            else high = mid - 1;
        }

        return high;
    }

    static boolean canweUse(int[] stalls , int pos , int cows)
    {
        int count = 1;
        int last = stalls[0];

        for(int i=1; i<stalls.length ; i++)
        {
            if(stalls[i] -last >= pos)
            {
                count++;
                last = stalls[i];
            }

            if(count>=cows) return true;
        }

        return false;

    }
}