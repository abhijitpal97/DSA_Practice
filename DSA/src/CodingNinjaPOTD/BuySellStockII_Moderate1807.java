package CodingNinjaPOTD;

public class BuySellStockII_Moderate1807 {
    public static long getMaximumProfit (int n, long[] values) {
        // Your code goes here.
        if(n<=1) return 0;
        long profit = 0;
        long price = values[0];

        for(int i =1;i<n;i++)
        {
            if(values[i]>price)
            {
                profit += values[i] - price;
                price = values[i];
            }
            else price = values[i];
        }

        return profit;
    }
}
