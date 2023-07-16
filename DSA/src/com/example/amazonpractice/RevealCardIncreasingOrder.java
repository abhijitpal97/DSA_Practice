package com.example.amazonpractice;

import java.util.*;

public class RevealCardIncreasingOrder {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int n = deck.length;

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<n;i++) queue.offer(i);

        int[] res = new int[n];

        for(int i:deck)
        {
            res[queue.poll()] = i;

            if(!queue.isEmpty()) queue.offer(queue.poll());
        }

        return res;
    }
}