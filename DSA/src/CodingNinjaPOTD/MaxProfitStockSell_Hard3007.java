package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

public class MaxProfitStockSell_Hard3007 {
	public static void main(String[] args)
	{
		int res = maxProfit(new ArrayList<>(Arrays.asList(1,7,20,23,21,11,3,15 )), 8);
		System.out.println(res);
	}
	public static int maxProfit(ArrayList<Integer> prices, int n) {
		// Write your code here.
		Queue<Integer> pq = new PriorityQueue<>((a , b) -> b-a);

		int price = prices.get(0);
		int profit = 0 ;
		for(int i =1;i<n;i++)
		{
			int curr = prices.get(i);
			if(price>=curr) 
			{
				price = curr;
				if(profit != 0)  pq.offer(profit);
				profit = 0;
			}
			else
			{
				profit += curr - price;
				price = curr;
			}
		}
		if(profit != 0)  pq.offer(profit);
		int maxProfit = 0;
		int counter = 2;
		while(!pq.isEmpty() && counter>0)
		{
			maxProfit += pq.poll();
			counter--;
		}

		return maxProfit;
	}
}