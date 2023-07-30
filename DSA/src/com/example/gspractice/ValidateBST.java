package com.example.gspractice;

import com.example.datastructure.skeleton.TreeNode;

public class ValidateBST {
	TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;

        return helper(root , Integer.MIN_VALUE , Integer.MAX_VALUE);
    }

    boolean helper(TreeNode root , int minValue , int maxValue)
    {
        if(root == null) return true;
        if(root.val<=minValue || root.val>=maxValue) return false;

        return helper(root.left , minValue , root.val) && helper(root.right , root.val , maxValue);
    }
    
    /// Iterative approach
    
    public boolean isValidBSTIterative(TreeNode root) {
        if(root == null) return true;

        boolean left = isValidBST(root.left);
        if(prev != null && prev.val>=root.val) return false;
        else prev = root;
        boolean right = isValidBST(root.right);

        return left && right;
    }
}