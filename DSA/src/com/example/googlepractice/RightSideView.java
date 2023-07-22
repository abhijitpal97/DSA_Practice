package com.example.googlepractice;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty())
        {
            int size = queue.size();
            boolean flag = false;
            for(int i=0;i<size;i++)
            {
                TreeNode node = queue.poll();
                if(!flag)
                {
                    result.add(node.val);
                    flag = true;
                }
                if(node.right != null)
                {
                    queue.offer(node.right);
                } 
                if(node.left != null) 
                {
                    queue.offer(node.left);
                }
            }
        }

        return result;
    
    }
}