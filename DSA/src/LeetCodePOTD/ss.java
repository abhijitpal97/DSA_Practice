package LeetCodePOTD;

import java.util.Arrays;

class MaxEventsAttented_1507 {
	int maxCost = Integer.MIN_VALUE;
	int dp[][];
	
	// Solved in Recursive Approach
	public int maxValueRecursive(int[][] events, int k) {
		maxCost = Integer.MIN_VALUE;
		Arrays.sort(events , (a,b) -> a[0] - b[0]);
		function(events , k , 0 , 0 ,  new int[]{-1,-1,-1} , 0 , events.length);

		return maxCost;
	}

	void function(int[][] events , int k , int curr , int index , int[] prev , int cost , int n)
	{
		if(curr <= k)
		{
			maxCost = Math.max(maxCost , cost);            
		}
		if(curr == k) return;

		if(index>=n) return;

		if(events[index][0]>prev[1]) function(events , k , curr+1 , index+1 , events[index] , cost+events[index][2] , n);
		function(events,k,curr,index+1,prev,cost , n);
	}
	
	//Convert it to a Memoraization
	public int maxValueMemoraization(int[][] events, int k) {
        Integer[][] dp = new Integer[events.length][k+1];
        Arrays.sort(events , (a,b) -> a[0] - b[0]);
        return function(events , k , 0 ,  new int[]{-1,-1,-1} , events.length , dp);
    }

    int function(int[][] events , int k , int index , int[] prev , int n , Integer[][] dp)
    {
        if(k<=0) return 0;
        if(index>=n) return 0;

        int notPick =  function(events,k,index+1,prev , n, dp);
        int pick = 0;
        if(events[index][0]>prev[1]) {
           pick =  events[index][2]+ function(events , k-1 , index+1 , events[index] , n, dp);
        }

        return dp[index][k] = Math.max(pick , notPick);
       
    }
    
    // TimeComplextyImprovement
    int help(int s[],int e[],int v[],int k,int prevEnd,int curr){
        if(k<=0)
            return 0;
        if(curr>=s.length)
            return 0;
        
        if(prevEnd<s[curr]){
            
            if(dp[curr][k]!=-1)
            return dp[curr][k];
            
            return dp[curr][k]=Math.max(v[curr]+help(s,e,v,k-1,e[curr],curr+1),help(s,e,v,k,prevEnd,curr+1));
        }
        
        else //if(prevEnd>=s[curr])
        {
            return help(s,e,v,k,prevEnd,curr+1);
        }
    }
    public int maxValue(int[][] events, int k) {
        int n=events.length;
        dp=new int[n][k+1];
        
        for(int i[]:dp)
            Arrays.fill(i,-1);
        
        Arrays.sort(events,(a,b)->a[0]-b[0]);
        int s[]=new int[n];
        int e[]=new int[n];
        int v[]=new int[n];
        
      
        for(int i=0;i<n;i++){
            s[i]=events[i][0];
        }
        for(int i=0;i<n;i++){
            e[i]=events[i][1];
        }
        for(int i=0;i<n;i++){
            v[i]=events[i][2];
        }
        
        return help(s,e,v,k,-1,0);
        
    }
}

