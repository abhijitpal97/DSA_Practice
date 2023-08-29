package LeetCodePOTD;

public class ClosingTime_2908 {
    public int bestClosingTime(String customers) {
        int n1 = 0;
        int min = 0;
        int closing = -1;
        
        for(int i = 0 ; i<customers.length() ; i++)
        {
            char ch = customers.charAt(i);
            if(ch == 'Y')
            {
                n1++;
            }
            else
            {
                n1--;
            }
            
            if(n1>min)
            {
                min = n1;
                closing = i;
            }

        }
        

        return closing+1;
    }
}