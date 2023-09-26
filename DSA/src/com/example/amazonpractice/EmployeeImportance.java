package com.example.amazonpractice;

import java.util.*;

// https://leetcode.com/problems/employee-importance/

class EmployeeImp {
	public int id;
	public int importance;
	public List<Integer> subordinates;
};

public class EmployeeImportance {
	int total = 0;
	public int getImportance(List<EmployeeImp> employees, int id) {
		total = 0;
		int n = employees.size();
		int maxId = 1;
		for(int i = 0; i<n ; i++) maxId = Math.max(maxId , employees.get(i).id);

		boolean[] isVisited = new boolean[maxId+1];

		for(int i=0;i<n;i++)
		{
			EmployeeImp e = employees.get(i);
			if(e.id == id)
			{
				total += e.importance;

				dfs(e.id , e.subordinates , employees , isVisited);
			}
		}

		return total;
	}

	void dfs(int id , List<Integer> list , List<EmployeeImp> employees , boolean[] isVisited)
	{
		if(isVisited[id]) return;
		isVisited[id] = true;

		for(int i=0;i<list.size();i++)
		{
			int x = list.get(i);
			for(int j = 0 ; j<employees.size() ; j++)
			{
				EmployeeImp e = employees.get(j);
				if(e.id == x && !isVisited[e.id])
				{
					total += e.importance;
					dfs(e.id , e.subordinates , employees , isVisited);
				}
			}
		}

		return;
	}
}