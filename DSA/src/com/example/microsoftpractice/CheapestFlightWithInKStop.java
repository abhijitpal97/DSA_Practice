package com.example.microsoftpractice;

import java.util.*;

public class CheapestFlightWithInKStop {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<FlightPair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] flight : flights) adj.get(flight[0]).add(new FlightPair(flight[1] , flight[2]));

        Queue<FlightTuple> queue = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist , Integer.MAX_VALUE);
        queue.offer(new FlightTuple(src , 0 , 0));
        dist[src] = 0;

        while(! queue.isEmpty())
        {
            FlightTuple tp = queue.poll();
            int tsrc = tp.src;
            int wt = tp.wt;
            int stop = tp.stop;
            //System.out.println("Src Wt - "+dist[tsrc]+" - "+wt+" - "+stop+" - "+tsrc);
            if(stop > k) continue;
            for(FlightPair p1 : adj.get(tsrc))
            {
                int currS = p1.src;
                int currW = p1.wt;

                if(wt+currW < dist[currS] && k>=stop)
                {
                    dist[currS] = wt+currW;
                    queue.offer(new FlightTuple(currS , dist[currS] , stop+1));
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE?-1:dist[dst];
    }
}

class FlightPair
{
    int src;
    int wt;

    FlightPair(int src , int wt)
    {
        this.src=src;
        this.wt=wt;
    }
}

class FlightTuple
{
    int src;
    int wt;
    int stop;

    FlightTuple(int src , int wt , int stop)
    {
        this.src=src;
        this.wt=wt;
        this.stop=stop;
    }
}