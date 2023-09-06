package com.example.amazonpractice;

import com.example.datastructure.skeleton.TreeNode;

public class LeafValueEqualsPath {
	static String str="";
	public static boolean doesReqdPathExist(TreeNode root) {
		// Write your code here.
		if(root == null) return true;
		if(isLeaf(root)) return true;
		str="";
		leafFormation(root);
		return rootToLeafPath(root , "");
	}

	static boolean rootToLeafPath(TreeNode root , String curr)
	{
		if(root == null) return false;

		if(isLeaf(root))
		{
			curr += String.valueOf(root.val);
			if(str.equals(curr)) return true;
			//System.out.println(str + " ---> "+curr);
			return false;
		}

		boolean l = rootToLeafPath(root.left , curr+String.valueOf(root.val));
		boolean r = rootToLeafPath(root.right , curr+String.valueOf(root.val));

		return l || r;
	}

	static void leafFormation(TreeNode root)
	{
		if(root == null) return;
		if(isLeaf(root))
		{
			str += String.valueOf(root.val);
			return;
		}

		leafFormation(root.left);
		leafFormation(root.right);
	}

	static boolean isLeaf(TreeNode root)
	{
		if(root.left == null && root.right == null) return true;
		return false;
	}
}