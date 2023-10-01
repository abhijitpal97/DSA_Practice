package LeetCodePOTD;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

// https://leetcode.com/problems/all-possible-full-binary-trees/

public class AllPossibleFBT_2307 {
	Map<Integer, List<TreeNode>> map = new HashMap<>();
	public List<TreeNode> allPossibleFBT(int n) {
		if(! map.containsKey(n))
		{
			List<TreeNode> nodes = new ArrayList<>();

			if(n == 1) nodes.add(new TreeNode(0 , null , null));
			else
			{
				for(int i = 1 ; i<=n-2 ; i++)
				{
					List<TreeNode> leftNodes = allPossibleFBT(i);
					List<TreeNode> rightNodes = allPossibleFBT(n-i-1);

					for(TreeNode left : leftNodes)
					{
						for(TreeNode right : rightNodes)
						{
							nodes.add(new TreeNode(0 , left , right));
						}
					}
				}
			}

			map.put(n , nodes);
		}

		return map.get(n);
	}
}