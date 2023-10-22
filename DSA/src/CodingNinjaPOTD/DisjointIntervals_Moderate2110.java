package CodingNinjaPOTD;
import java.util.*;

// https://www.codingninjas.com/studio/problems/data-stream-as-disjoint-intervals_1382362

public class DisjointIntervals_Moderate2110 {

	public static void main(String[] args)
	{
		DisjointIntervals intervals = new DisjointIntervals();
		intervals.addInteger(5);
		intervals.addInteger(9);
		intervals.addInteger(6);
		intervals.addInteger(4);
		intervals.addInteger(7);
		System.out.println(intervals.getDisjointIntervals());
		intervals.addInteger(9);
		intervals.addInteger(5);
		System.out.println(intervals.getDisjointIntervals());
	}

	public static class DisjointIntervals {
		List<Integer> list;

		public DisjointIntervals() {
			// Intialise your data structure here.
			list = new ArrayList<>();
		}

		public void addInteger(int val) {
			// Add the integer to the stream.
			if(! list.contains(val)) list.add(val);
			Collections.sort(list);
		}

		public List<List<Integer>> getDisjointIntervals() {
			// Return the disjoint intervals.
			List<List<Integer>> res = new ArrayList<>();

			if(list.isEmpty()) return res;

			for(int i=0;i<list.size();i++)
			{
				int curr = list.get(i);
				while(i+1<list.size() && list.get(i)+1 == list.get(i+1))
				{
					i++;
				}
				res.add(new ArrayList<>(Arrays.asList(curr , list.get(i))));
			}

			return res;
		}
	}
}