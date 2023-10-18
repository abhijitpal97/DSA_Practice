package LeetCodePOTD;

import java.util.*;

// https://leetcode.com/problems/validate-binary-tree-nodes

public class ValidateBinaryTree_1710 {
	public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
		boolean[] childCount = new boolean[n];
		for(int child : leftChild)
		{
			if(child != -1) childCount[child] = true;
		}

		for(int child : rightChild)
		{
			if(child != -1)
			{
				if(childCount[child]) return false;
				childCount[child] = true;
			}
		}

		int root = -1;
		for(int i=0;i<n;i++)
		{
			if(! childCount[i])
			{
				if(root == -1) root = i;
				else return false;
			}
		}

		if(root == -1) return false;

		return isValidTree(root , n , leftChild , rightChild);
	}


	public boolean isValidTree(int root , int n, int[] leftChild, int[] rightChild) {
		boolean[] isVisited = new boolean[n];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(root);
		isVisited[root] = true;

		while(! queue.isEmpty())
		{
			int i = queue.poll();

			int lC = leftChild[i];
			int rC = rightChild[i];

			if(lC != -1 && isVisited[lC]) return false;
			if(lC != -1 && !isVisited[lC]) 
			{
				queue.offer(lC);
				isVisited[lC] = true;
			}

			if(rC != -1 && isVisited[rC]) return false;
			if(rC != -1 && !isVisited[rC])
			{
				queue.offer(rC);
				isVisited[rC] = true;
			}


		}
		for(int i=0;i<n;i++)
		{
			if(isVisited[i] == false) return false;
		}

		return true;
	}
}