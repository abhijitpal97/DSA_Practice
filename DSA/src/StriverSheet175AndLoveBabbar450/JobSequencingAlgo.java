package StriverSheet175AndLoveBabbar450;

import java.util.*;

// https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1

public class JobSequencingAlgo
{
	//Function to find the maximum profit and the number of jobs done.
	int[] JobScheduling(Job arr[], int n)
	{
		// Your code here
		Arrays.sort(arr, (a , b) -> b.profit - a.profit);

		int deadline = 0;
		for(Job job : arr)
		{
			deadline = Math.max(deadline , job.deadline);
		}

		int[] schedule = new int[deadline+1];
		Arrays.fill(schedule , -1);
		int maxProfit = 0;
		int maxjobs = 0;

		for(int i=0;i<n;i++)
		{
			for(int j=arr[i].deadline; j>0;j--)
			{
				if(schedule[j] == -1)
				{
					schedule[j] = i;
					maxProfit +=arr[i].profit;
					maxjobs++;
					break;
				}
			}
		}

		int[] result = new int[]{maxjobs , maxProfit};

		return result;

	}

	// https://www.codingninjas.com/studio/problems/job-sequencing-problem_1169460

	public static int[] jobScheduling(int [][]jobs) {
		// Write your code here
		Arrays.sort(jobs , new Comparator<int[]>()
		{
			public int compare(int[] job1, int[] job2) {
				if (job1[2] == job2[2]) {
					return job2[1] - job1[1]; // Sort in non-increasing order of deadlines if profits are equal
				}
				return job2[2] - job1[2]; // Sort in non-increasing order of profit
			}
		}
				);
		int maxDeadline = 0;
		// {2,2,40},{1,2,30},{3,1,10},{4,1,10}
		for(int i=0;i<jobs.length ; i++) maxDeadline = Math.max(maxDeadline , jobs[i][1]);

		int maxprofit = 0;
		int numberOfJobs = 0;
		int[] schedule = new int[maxDeadline+1];
		// -1 1 0
		// 40+30
		// 1+1
		Arrays.fill(schedule , -1);

		for(int i=0;i<jobs.length;i++)
		{
			for(int j = jobs[i][1] ; j>0 ; j--)
			{
				if(schedule[j] == -1)
				{
					schedule[j] = i;
					maxprofit += jobs[i][2];
					numberOfJobs++;
					break;
				}
			}
		}

		return new int[]{numberOfJobs , maxprofit};



	}
}

class Job {
	int id, profit, deadline;
	Job(int x, int y, int z){
		this.id = x;
		this.deadline = y;
		this.profit = z; 
	}
}
