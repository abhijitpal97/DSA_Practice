package StriverSheet175AndLoveBabbar450;
import java.util.* ;

// https://www.codingninjas.com/studio/problems/merge-intervals_699917

import java.util.List;
import java.util.ArrayList;

class IntervalClass{
	int start;
	int finish;

	public IntervalClass(int start, int finish) {
		this.start = start;
		this.finish = finish;
	}
	public int getStart() {
		return start;
	}
	public int getFinish() {
		return finish;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public void setFinish(int finish) {
		this.finish = finish;
	}
	@Override
	public String toString() {
		return "Interval [start=" + start + ", finish=" + finish + "]";
	}

}

public class MergeIntervals {

	public static void main(String[] args)
	{
		List<IntervalClass> res =  mergeIntervals(new IntervalClass[]
				{new IntervalClass(1, 4),
						new IntervalClass(3, 5),new IntervalClass(6, 8),
						new IntervalClass(8, 9),
						new IntervalClass(10, 12)});
		System.out.println(res);
	}

	public static List<IntervalClass> mergeIntervals(IntervalClass[] intervals) {
		// write your code here.
		Arrays.sort(intervals , (a,b) -> a.start-b.start);
		List<IntervalClass> result = new ArrayList<>();
		int n = intervals.length;
		List<IntervalClass> temp = new ArrayList<>();

		for(int i=0;i<n;i++)
		{
			IntervalClass curr = intervals[i];

			if(temp.isEmpty())
			{
				result.add(curr);
				temp.add(curr);
			}
			else
			{
				IntervalClass currT = temp.get(0);
				if(curr.start<=currT.finish)
				{
					temp.remove(0);
					result.remove(result.size()-1);
					int st = Math.min(currT.start , curr.start);
					int en = Math.max(currT.finish , curr.finish);
					temp.add(new IntervalClass(st,en));
					result.add(new IntervalClass(st,en));
				}
				else
				{
					temp.remove(0);
					result.add(curr);
					temp.add(curr);
				}
			}
		}

		return result;

	}
}
