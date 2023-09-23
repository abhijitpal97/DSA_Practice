package com.example.amazonpractice;

import java.util.*;
//https://leetcode.com/discuss/interview-question/690707/Amazon-or-Phone-Interview-or-Group-Product-Id-pairs-into-Categories

public class GroupProductsUsingIds
{
	public static void main(String[] args)
	{
		List<List<Integer>> result = groupProducts(new int[][] {{1,2}, {2,5}, {3,4}, {4,6}, {6,8}, {5,7}, {5,2}});
		System.out.println(result);
	}
	public static List<List<Integer>> groupProducts(int[][] products)
	{
		int items = getProducts(products);
		int[] parent = new int[items+1];
		for(int i=0; i<=items ; i++) parent[i]=i;
		for(int[] prod : products)
		{
			int f = prod[0];
			int s = prod[1];
			union(f,s,parent);
		}

		Map<Integer,List<Integer>> map = new HashMap<>();
		for(int i=1;i<parent.length;i++)
		{
			if(map.containsKey(parent[i])) map.get(parent[i]).add(i);
			else
			{
				map.put(parent[i] , new ArrayList<>(Arrays.asList(i)));

			}
		}

		List<List<Integer>> result = new ArrayList<>();

		for(Map.Entry<Integer,List<Integer>> m1 : map.entrySet())
		{
			result.add(m1.getValue());
		}

		return result;
	}

	public static void union(int a , int b , int[] parent)
	{
		int x = find(a,parent);
		int y = find(b,parent);

		if(x==y) return;
		else parent[y]=x;
	}

	public static int find(int a , int[] parent)
	{
		if(a==parent[a]) return a;
		return find(parent[a] , parent);
	}

	public static int getProducts(int[][] items)
	{
		Set<Integer> set = new HashSet<>();
		for(int[] i : items)
		{
			set.add(i[0]);
			set.add(i[1]);
		}

		return set.size();
	}
}