package LeetCodePOTD;

import java.util.*;

class MeetingRoomTuple
{
	int end;
	int room;

	MeetingRoomTuple(int end , int room)
	{
		this.end = end;
		this.room = room;
	}
}

public class MeetingRoom3_1802 {
	public static void main(String[] args)
	{
		int res = mostBooked(4, new int[][]{{18,19},{3,12},{17,19},{2,13},{7,10}});
		System.out.println(res);
	}
	public static int mostBooked(int n, int[][] meetings) {
		int m = meetings.length;
		if(m<=n) return 0;

		Arrays.sort(meetings , (a,b) -> a[0]-b[0]);
		Queue<MeetingRoomTuple> pq = new PriorityQueue<>((a,b) -> a.end-b.end);
		int[] meetCount = new int[n];
		int currRoom = 0;

		for(int i = 0; i<m ; i++)
		{
			int[] meet = meetings[i];
			int start = meet[0];
			int end = meet[1];
			if(pq.isEmpty())
			{
				pq.offer(new MeetingRoomTuple(end , currRoom));
				meetCount[currRoom]++;
				currRoom++;
			}
			else
			{
				MeetingRoomTuple last = pq.peek();
				if(start>last.end)
				{
					pq.poll();
					pq.offer(new MeetingRoomTuple(end , last.room));
					meetCount[last.room]++;
				}
				else
				{
					if(currRoom==n)
					{
						int duration = end-start;
						pq.poll();
						pq.offer(new MeetingRoomTuple(last.end+duration , last.room));
						meetCount[last.room]++;
					}

					else
					{
						pq.offer(new MeetingRoomTuple(end , currRoom));
						meetCount[currRoom]++;
						currRoom++;
					}
				}
			}
		}

		int max = 0;
		int room = 0;
		for(int i=0;i<n;i++)
		{
			if(meetCount[i]>max)
			{
				room = i;
				max = meetCount[i];
			}
		}

		return room;
	}

	// Smallest First Solution
	public int mostBookedSmallestFirst(int n, int[][] meetings) {
		int[] count = new int[n];
		Arrays.sort(meetings, (a,b)->a[0]-b[0]);
		PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]>(){
			public int compare(long[] a, long[] b){
				if (a[0] == b[0]){
					return (int)(a[1]-b[1]);
				} else {
					return (int)(a[0]-b[0]);
				}
			}
		});
		for (int i=0; i<n; i++) {
			pq.add(new long[]{0, i});
		}
		for (int[] meeting : meetings) {
			while (pq.peek()[0] < meeting[0]) {
				pq.add(new long[]{meeting[0], pq.poll()[1]});
			}
			long[] cur = pq.poll();
			long end = cur[0]+(meeting[1]-meeting[0]);
			count[(int)cur[1]]++;
			pq.add(new long[]{end, cur[1]});
		}
		int max = 0, res = 0;
		for (int i=0; i<n; i++){
			if (count[i] > max){
				max = count[i];
				res = i;
			}
		}
		return res;
	}

}