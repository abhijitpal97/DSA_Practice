package com.example.microsoftpractice;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

public class ZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag = true;
        queue.offer(root);
        while(! queue.isEmpty())
        {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int i=0;i<size;i++)
            {
                TreeNode curr = queue.poll();
                list.add(curr.val);
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);     
                
            }
            if(!flag) Collections.reverse(list);
            flag = !flag;
            result.add(list);
        }
        return result;
    }
}