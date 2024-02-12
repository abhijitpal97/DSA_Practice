package com.example.oracle;

import java.util.*;

// https://leetcode.com/problems/reorganize-string/
// Google

class ReOrganizePair implements Comparable<ReOrganizePair>
{
    char ch;
    int count;

    ReOrganizePair(char ch , int count)
    {
        this.ch=ch;
        this.count=count;
    }

    public int compareTo(ReOrganizePair that)
    {
        if(this.count == that.count) return this.ch-that.ch;
        return that.count-this.count;
    }
}

public class ReOrganizeString {
    public String reorganizeString(String s) {
        Queue<ReOrganizePair> pq = new PriorityQueue<>();
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()) map.put(ch , map.getOrDefault(ch , 0)+1);
        for(Map.Entry<Character,Integer> m1 : map.entrySet())
        {
            pq.offer(new ReOrganizePair(m1.getKey() , m1.getValue()));
        }
        StringBuilder sb = new StringBuilder();
        while(! pq.isEmpty())
        {
            ReOrganizePair p1 = pq.poll();
            if(! pq.isEmpty())
            {
                ReOrganizePair p2 = pq.poll();
                sb.append(p1.ch).append(p2.ch);
                if(p2.count-1 >=1) pq.offer(new ReOrganizePair(p2.ch , p2.count-1));
                if(p1.count-1 >=1) pq.offer(new ReOrganizePair(p1.ch , p1.count-1));
            }
            else
            {
                sb.append(p1.ch);
                if(p1.count-1 >=1) return "";
            }
        }
        return sb.toString();

    }
}