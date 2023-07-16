package com.example.amazonpractice;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

public class EvenValuedGrandChildrenSum {
    
	public int sumEvenGrandparent(TreeNode root) {
        Map<TreeNode,TreeNode> map = new HashMap<>();
        List<TreeNode> list = new ArrayList<>();
        markParent(root , map , list);

        int sum = 0;
        for(Map.Entry<TreeNode,TreeNode> m1 : map.entrySet())
        {
            if(map.containsKey(m1.getValue()) && list.contains(map.get(m1.getValue()))) sum+= m1.getKey().val;
        }

        return sum;
    }

    void markParent(TreeNode root , Map<TreeNode, TreeNode> map , List<TreeNode> list)
    {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(! queue.isEmpty())
        {
            TreeNode node = queue.poll();
            if(node.val %2 == 0 ) list.add(node);

            if(node.left != null)
            {
                map.put(node.left , node);
                queue.offer(node.left);
            }
            if(node.right != null) 
            {
                queue.offer(node.right);
                map.put(node.right , node);
            }
        }
    }
}