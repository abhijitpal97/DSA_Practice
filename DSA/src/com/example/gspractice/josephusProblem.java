package com.example.gspractice;

// https://practice.geeksforgeeks.org/problems/josephus-problem/1

public class josephusProblem {
	public int findTheWinner(int n, int k) {
		if(n==1) return n;
		return (findTheWinner(n-1,k)+k-1)%n+1;
	}
}