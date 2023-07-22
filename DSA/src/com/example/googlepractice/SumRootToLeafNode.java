package com.example.googlepractice;

import com.example.datastructure.skeleton.TreeNode;

public class SumRootToLeafNode {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        sum =0;
        if(root == null) return 0;
        if(isLeaf(root)) return root.val;
        collectSum(root , 0);
        return sum;
    }

    void collectSum(TreeNode node , int curr)
    {
        if(node == null) return;
        if(isLeaf(node))
        {
            sum += (curr*10)+node.val;
            return;
        }

        collectSum(node.left , (curr*10)+node.val);
        collectSum(node.right , (curr*10)+node.val);
    }



    boolean isLeaf(TreeNode node)
    {
        if(node.left == null && node.right == null) return true;
        return false;

    }
}