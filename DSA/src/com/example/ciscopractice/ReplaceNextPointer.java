package com.example.ciscopractice;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

public class ReplaceNextPointer {
    public TreeNode connect(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(! queue.isEmpty())
        {
            int size = queue.size();
            TreeNode prev = null;
        
            for(int i=0;i<size;i++)
            {
                TreeNode TreeNode = queue.poll();
                TreeNode.next = prev;
                prev = TreeNode;

                if(TreeNode.right != null) queue.offer(TreeNode.right);
                if(TreeNode.left != null) queue.offer(TreeNode.left);
            }
        }

        return root;
        
    }
}