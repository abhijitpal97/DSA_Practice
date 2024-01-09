package LeetCodePOTD;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

// https://leetcode.com/problems/leaf-similar-trees/

public class LeafSimilar_0901 {
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();

		getLeafs(root1 , l1);
		getLeafs(root2 , l2);

		if(l1.size() != l2.size()) return false;
		for(int i=0; i<l1.size();i++)
		{
			if(l1.get(i) != l2.get(i)) return false;
		}

		return true;
	}

	void getLeafs(TreeNode root , List<Integer> list)
	{
		if(root == null) return;
		if(isLeaf(root))
		{
			list.add(root.val);
			return;
		}

		getLeafs(root.left , list);
		getLeafs(root.right , list);
	}

	boolean isLeaf(TreeNode root)
	{
		if(root.left == null && root.right == null) return true;
		return false;
	}
}