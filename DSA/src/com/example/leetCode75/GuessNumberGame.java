package com.example.leetCode75;
/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */
// https://leetcode.com/problems/guess-number-higher-or-lower/

class GuessGame
{}

public class GuessNumberGame extends GuessGame {
	public int guessNumber(int n) {
		int start = 1;
		int end = n;

		while(start<=end)
		{
			int mid = start+(end-start)/2;
			int guess = guess(mid);

			if(guess == 0) return mid;
			if(guess == 1) start = mid+1;
			if(guess == -1) end = mid-1;
		}
		return -1;
	}

	private int guess(int mid) {
		// TODO Auto-generated method stub
		// External API Logic will be here - Dummy Implementation
		return 0;
	}
}