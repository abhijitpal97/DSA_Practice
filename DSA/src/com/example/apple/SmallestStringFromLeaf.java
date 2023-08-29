package com.example.apple;

import com.example.datastructure.skeleton.TreeNode;

public class SmallestStringFromLeaf {
	String ans = "";
	public String smallestFromLeaf(TreeNode root) {
		ans = "";
		StringBuilder sb = new StringBuilder();
		function(root , sb);
		return ans;
	}

	void function(TreeNode root , StringBuilder sb)
	{

		sb.append((char)(root.val + 'a'));

		if(root.left != null) function(root.left, sb );
		if(root.right != null) function(root.right, sb );

		if(isLeaf(root))
		{
			String str = sb.reverse().toString();
			if(ans.equals("") || str.compareTo(ans) < 0) ans = str;
			sb.reverse();
		}

		sb.setLength(sb.length() - 1);
	}

	boolean isLeaf(TreeNode node)
	{
		if(node.left == null && node.right == null) return true;
		return false;
	}
}