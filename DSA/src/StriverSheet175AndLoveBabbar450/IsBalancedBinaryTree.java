package StriverSheet175AndLoveBabbar450;

import com.example.datastructure.skeleton.TreeNode;

// https://leetcode.com/problems/balanced-binary-tree/description/

public class IsBalancedBinaryTree {
	public static boolean isBalancedBT(TreeNode root) {
		// Write your code here.
		if(root == null) return true;
		if(root.left == null && root.right == null) return true;
		if(Math.abs(height(root.left) - height(root.right))>1) return false;

		return isBalancedBT(root.left) && isBalancedBT(root.right);
	}

	static int height(TreeNode node)
	{
		if(node==null) return 0;
		int left = height(node.left);
		int right = height(node.right);

		return 1+ Math.max(left , right);
	}
}