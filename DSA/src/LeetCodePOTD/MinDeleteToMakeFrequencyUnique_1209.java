package LeetCodePOTD;

import java.util.*;

public class MinDeleteToMakeFrequencyUnique_1209 {
    public int minDeletions(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()) map.put(ch , map.getOrDefault(ch , 0)+1);

        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i : map.values()) queue.offer(i);

        int result = 0;
        while(! queue.isEmpty())
        {
            int curr = queue.poll();
            if(queue.isEmpty()) return result;

            if(curr == queue.peek())
            {
                if(curr>1) queue.offer(curr-1);
                result++;
            }
        }

        return result;
        
    }
}