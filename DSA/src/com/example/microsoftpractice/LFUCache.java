package com.example.microsoftpractice;

import java.util.*;

class LFUNode {
    int val;

    LFUNode(int val)
    {
        this.val = val;
    }
    LFUNode(){}
}



public class LFUCache {
    int capacity;
    Map<Integer,LFUNode> map;
    Map<Integer,Integer> freq;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        freq = new LinkedHashMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key))
        {
            LFUNode curr = map.get(key);
            int newFreq = freq.get(key)+1;
            freq.remove(key);
            freq.put(key , newFreq);
            return curr.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            LFUNode curr = map.get(key);
            curr.val = value;
            map.put(key,curr);
            int newFreq = freq.get(key)+1;
            freq.remove(key);
            freq.put(key , newFreq);
        }
        else
        {
            if(capacity == map.size())
            {
                int keyToRemove = getMinFreq();
                LFUNode curr = map.get(keyToRemove);
                map.remove(keyToRemove);
                freq.remove(keyToRemove);
            }

            LFUNode LFUNode = new LFUNode(value);
            map.put(key , LFUNode);
            freq.put(key , 1);            
        }
        
    }

    int  getMinFreq()
    {
        System.out.println(freq);
        int key = Integer.MAX_VALUE;
        int ret = -1;
        for(Map.Entry<Integer,Integer> m1 : freq.entrySet())
        {
            if(m1.getValue()<key)
            {
                key = m1.getValue();
                ret = m1.getKey();
            }        
        }
         System.out.println("Remove - "+ret );
        return ret;
    }
}