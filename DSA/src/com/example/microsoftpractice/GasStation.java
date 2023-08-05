package com.example.microsoftpractice;

import java.util.*;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        List<Integer> startIndex = new ArrayList<>();
        int n = gas.length;
        if(n==1)
	    {
	        if(gas[0]>=cost[0]) return 0;
	        else return -1;
	    }
        for(int i=0;i<n;i++)
        {
            if(gas[i]>cost[i]) startIndex.add(i);
        }
        if(startIndex.isEmpty()) return -1;

        for(int index : startIndex)
        {
            int startP = index;
            int nextP = startP+1==n?0:startP+1;
            int availablePetrol = gas[startP]-cost[startP];

            while(availablePetrol>=0 && nextP != startP)
            {
                availablePetrol += gas[nextP]-cost[nextP];
                nextP = nextP+1==n?0:nextP+1;
            }
            if(availablePetrol>=0 && nextP == startP) return startP;
        }
        return -1;
    }
}
