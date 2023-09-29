package com.example.amazonpractice;

// https://leetcode.com/problems/robot-bounded-in-circle/description/

public class RobotBounded {
	public boolean isRobotBounded(String instructions) {
		int dirX = 0;
		int dirY = 0;
		char d = 'u';

		for(char ch : instructions.toCharArray())
		{
			if(ch=='G')
			{
				if(d=='u') dirY++;
				else if(d=='d') dirY--;
				else if(d=='l') dirX--;
				else dirX++; 
			}

			else if(ch =='L')
			{
				if(d=='u') d='l';
				else if(d=='d') d='r';
				else if(d=='l') d='d';
				else d='u'; 
			}

			else if(ch =='R')
			{
				if(d=='u') d='r';
				else if(d=='d') d='l';
				else if(d=='l') d='u';
				else d='d'; 
			}

		}
		return (dirX==0 && dirY==0) || d!='u';
	}
}