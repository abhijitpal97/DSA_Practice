package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

public class RoundsRequiredToMakeNOne {

    public static int rounds(int a,int b) {
        //Write your code here
        int ans = 0;

        for(int i=b+1;i<=a;i++)
        {
            int x = i;
            int count = 0;

            for(int j = 2; j*j<=x;j++)
            {
                while(x%j == 0)
                {
                    x = x/j;
                    count++;
                }
            }

            if(x>1) count++;
            ans += count;
        }

        return ans;
    }
}