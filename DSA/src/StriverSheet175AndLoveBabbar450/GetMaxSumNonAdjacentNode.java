package StriverSheet175AndLoveBabbar450;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

// https://www.geeksforgeeks.org/problems/maximum-sum-of-non-adjacent-nodes/1

public class GetMaxSumNonAdjacentNode
{
	//Function to return the maximum sum of non-adjacent nodes.
	static int getMaxSum(TreeNode root)
	{
		// add your code here
		Map<TreeNode,Integer> map = new HashMap<>();
		return helper(root , map);
	}

	static int helper(TreeNode node , Map<TreeNode,Integer> map)
	{
		if(node == null) return 0;
		if(map.containsKey(node)) return map.get(node);

		int inc = node.val;
		if(node.left != null)
		{
			inc += helper(node.left.left  , map);
			inc += helper(node.left.right  , map);
		}
		if(node.right != null)
		{
			inc += helper(node.right.left  , map);
			inc += helper(node.right.right  , map);
		}

		int exc = helper(node.left  , map) + helper(node.right , map);

		map.put(node , Math.max(inc , exc));

		return map.get(node);
	}
}
