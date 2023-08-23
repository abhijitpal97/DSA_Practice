package LeetCodePOTD;

import java.util.*;

public class ReOrganizeString_2308 {
	public String reorganizeString(String s) {
		Map<Character,Integer> map = new HashMap<>();
		for(char ch : s.toCharArray()) map.put(ch , map.getOrDefault(ch , 0)+1);
		Queue<ReorganizePair> pq = new PriorityQueue<>((a,b) -> b.count-a.count);
		for(Map.Entry<Character,Integer> m1 : map.entrySet()) pq.offer(new ReorganizePair(m1.getKey() , m1.getValue()));
		StringBuilder sb = new StringBuilder();

		while(! pq.isEmpty())
		{
			if(pq.size()==1 && pq.peek().count>1) return "";
			if(pq.size()==1 && pq.peek().count == 1)
			{
				sb.append(pq.poll().ch);
				return sb.toString();
			}
			ReorganizePair p1 = pq.poll();
			ReorganizePair p2 = pq.poll();
			sb.append(p1.ch).append(p2.ch);
			if(p1.count>1) pq.offer(new ReorganizePair(p1.ch , p1.count-1));
			if(p2.count>1) pq.offer(new ReorganizePair(p2.ch , p2.count-1));
		}

		return sb.toString();
	}
}

class ReorganizePair
{
	Character ch;
	int count;

	ReorganizePair(Character ch , int count)
	{
		this.ch=ch;
		this.count=count;
	}
}