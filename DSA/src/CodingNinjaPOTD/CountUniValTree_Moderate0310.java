package CodingNinjaPOTD;

import com.example.datastructure.skeleton.TreeNode;

// https://www.codingninjas.com/studio/problems/unival-trees_697311

public class CountUniValTree_Moderate0310 {
	static int count = 0;

	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);
		root.right = new TreeNode(1);
		int res = countUnivalTrees(root);
		System.out.println(res);
	}
	public static int countUnivalTrees(TreeNode root) {
		// Write your code here.
		count = 0;
		countHelper(root);

		return count;
	}

	static void countHelper(TreeNode root)
	{
		if(root == null) return;
		if(isUniVal(root , root.val)) count++;

		countHelper(root.left);
		countHelper(root.right);
	}

	static boolean isUniVal(TreeNode root , int val)
	{
		if(root == null) return true;
		if(root.val != val) return false;

		return isUniVal(root.left , val) && isUniVal(root.right,val);
	}

	// O(N)

	public static int countUnivalTreesOptimized(TreeNode root) {
		// Write your code here.
		return helper(root).count;
	}

	static UniPair helper(TreeNode root)
	{
		if(root == null) return new UniPair(0,true);

		UniPair left = helper(root.left);
		UniPair right = helper(root.right);

		int total = left.count+right.count;
		boolean isUni = false;
		UniPair ans = new UniPair(total , isUni);

		if(left.isUniVal && right.isUniVal)
		{
			if(root.left != null && root.val != root.left.val) return ans;
			if(root.right != null && root.val != root.right.val) return ans;

			ans.count++;
			ans.isUniVal = true;
			return ans;
		}

		return ans;
	}
}

class UniPair
{
	int count;
	boolean isUniVal;

	UniPair(int count , boolean isUniVal)
	{
		this.count=count;
		this.isUniVal=isUniVal;
	}
}
