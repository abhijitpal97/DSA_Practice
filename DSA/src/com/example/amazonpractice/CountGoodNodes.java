package com.example.amazonpractice;

import com.example.datastructure.skeleton.TreeNode;

public class CountGoodNodes {
    int count = 0;
    public int goodNodes(TreeNode root) {
        count = 0;
        if(root == null) return 0;
        
        if(root.left != null) calculate(root.left ,  root.val);
        if(root.right != null) calculate(root.right , root.val);

        return 1+count;
    }

    void calculate(TreeNode node , int max)
    {
        if(node == null) return;
        if(node.val>=max)
        {
            max = Math.max(node.val , max);
            count++;
        }

        if(node.left != null) calculate(node.left ,  max);
        if(node.right != null) calculate(node.right , max);

    }

}