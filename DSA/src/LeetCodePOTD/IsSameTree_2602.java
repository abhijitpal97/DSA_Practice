package LeetCodePOTD;

import com.example.datastructure.skeleton.TreeNode;

// https://leetcode.com/problems/same-tree/

public class IsSameTree_2602 {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p==null && q==null) return true;
		if(p == null || q == null) return false;
		if(p.val != q.val) return false;

		return ((p.val==q.val) && isSameTree(p.left , q.left) && isSameTree(p.right , q.right));
	}
}