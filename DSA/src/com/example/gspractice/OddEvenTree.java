package com.example.gspractice;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

public class OddEvenTree {
	
	public static void main(String[] args)
	{
		TreeNode t1 = new TreeNode(5);
		t1.left = new TreeNode(9);
		t1.right = new TreeNode(1);
		t1.left.left = new TreeNode(3);
		t1.left.right = new TreeNode(5);
		t1.right.left = new TreeNode(7);
		
		
		TreeNode t2 = new TreeNode(5);
		t2.left = new TreeNode(4);
		t2.right = new TreeNode(2);
		t2.left.left = new TreeNode(3);
		t2.left.right = new TreeNode(3);
		t2.right.left = new TreeNode(7);
		
		TreeNode t3 = new TreeNode(1);
		t3.left = new TreeNode(10);
		t3.right = new TreeNode(4);
		t3.left.left = new TreeNode(3);
		t3.right.left = new TreeNode(7);
		t3.right.right = new TreeNode(9);
		t3.left.left.left = new TreeNode(12);
		t3.left.left.right = new TreeNode(8);
		t3.right.left.left = new TreeNode(6);
		t3.right.right.right = new TreeNode(2);
		
		boolean res = isEvenOddTree(t3);
		System.out.println(res);
	}
	
	
    public static boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isOdd = true;
        while(! queue.isEmpty())
        {
            int size = queue.size();
            int prev = Integer.MAX_VALUE;
            if(isOdd) prev = Integer.MIN_VALUE;
            for(int i = 0;i<size;i++)
            {
                TreeNode curr = queue.poll();
                if(isOdd)
                {
                    if(curr.val%2==0 || prev>=curr.val) return false;
                    if(curr.left != null) queue.offer(curr.left);
                    if(curr.right != null) queue.offer(curr.right);
                    prev = curr.val;
                }
                else
                {
                    if(curr.val%2==1 || prev<=curr.val) return false;
                    if(curr.left != null) queue.offer(curr.left);
                    if(curr.right != null) queue.offer(curr.right);
                    prev = curr.val;
                }
            }
             isOdd = !isOdd;
        }

        return true;
    }

}