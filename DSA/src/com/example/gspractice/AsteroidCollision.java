package com.example.gspractice;

import java.util.Stack;

// https://leetcode.com/problems/asteroid-collision/description/
// leetCode75

public class AsteroidCollision {
	public int[] asteroidCollision(int[] asteroids) {
		int n = asteroids.length;
		Stack<Integer> stack = new Stack<>();

		for(int i=0;i<n;i++)
		{
			while(! stack.isEmpty() &&
					asteroids[i]<0 && stack.peek()>0)
			{
				int diff = asteroids[i]+stack.peek();

				if(diff<0) stack.pop();
				if(diff>0) asteroids[i] = 0;
				if(diff == 0)
				{
					asteroids[i] = 0;
					stack.pop();
				}
			}

			if(asteroids[i] != 0) stack.push(asteroids[i]);
		}

		int[] ans= new int[stack.size()];
		int i=ans.length-1;
		while(!stack.isEmpty()){
			ans[i]=stack.pop();
			i--;
		}
		return ans;
	}
}