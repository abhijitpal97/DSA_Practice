package com.example.microsoftpractice;

import java.util.*;

class WordPair
{
    String word;
    int occur;

    WordPair(String word,int occur)
    {
        this.word=word;
        this.occur=occur;
    }
}



public class TopKFrequentWord {
    public List<String> topKFrequent(String[] words, int k) {

        Map<String,Integer> map = new HashMap<>();
        for(String str : words) map.put(str , map.getOrDefault(str , 0)+1);

        Queue<WordPair> pq = new PriorityQueue<>((a , b) -> 
        {
            if(a.occur != b.occur) return b.occur - a.occur;
            return a.word.compareTo(b.word);
        });
        
        for(Map.Entry<String, Integer> m1 : map.entrySet())
        {
            pq.offer(new WordPair(m1.getKey() , m1.getValue()));
        }

        List<String> list = new ArrayList<>();

        if(k>pq.size()) return list;

        while(k>0)
        {
            list.add(pq.poll().word);
            k--;
        }

       // Collections.sort(list);
        return list;
    }
}