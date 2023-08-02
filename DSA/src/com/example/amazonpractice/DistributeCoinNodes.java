package com.example.amazonpractice;

public class DistributeCoinNodes {
    int ans = 0;
    public int distributeCoins(TreeNode root) {
        ans = 0;
        helper(root);
        return ans;
    }

    int helper(TreeNode root)
    {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val -1 ;

        int l = helper(root.left);
        int r = helper(root.right);

        ans += Math.abs(l) + Math.abs(r);

        root.val += l+r;

        return root.val-1;
    }
}