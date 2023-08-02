package com.example.amazonpractice;

import com.example.datastructure.skeleton.TreeNode;

public class MAXDiffAnsester {
    int ans = Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        ans = Integer.MIN_VALUE;
        if(root == null) return 0;
        helper(root , Integer.MAX_VALUE , Integer.MIN_VALUE);
        return ans;
    }

    void helper(TreeNode node , int min ,int max)
    {
        if(node == null) return;

        min = Math.min(min , node.val);
        max = Math.max(max , node.val);
        ans = Math.max(ans , max-min);

        helper(node.left , min , max);
        helper(node.right , min , max);
    }
}