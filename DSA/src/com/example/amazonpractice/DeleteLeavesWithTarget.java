package com.example.amazonpractice;

import com.example.datastructure.skeleton.TreeNode;

public class DeleteLeavesWithTarget {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null) return null;
        if(root.left == null && root.right==null && root.val == target) return null;
        root.left = removeLeafNodes(root.left , target);
        root.right = removeLeafNodes(root.right , target);

         if (root.left == null && root.right == null && root.val == target)
            root = null;
        
        return root;
    }
}