package com.example.microsoftpractice;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

class VerticalPair
{
    TreeNode node;
    int level;

    VerticalPair(TreeNode node , int level)
    {
        this.node=node;
        this.level=level;
    }
}

public class VerticalTraversalofBinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer,List<Integer>> map = new TreeMap<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<VerticalPair> queue = new LinkedList<>();
        queue.offer(new VerticalPair(root , 0));
        map.put(0 , new ArrayList<>(Arrays.asList(root.val)));

        while(! queue.isEmpty())
        {
            VerticalPair p1 = queue.poll();
            TreeNode curr = p1.node;
            int index = p1.level;

            if(curr.left != null)
            {
                queue.offer(new VerticalPair(curr.left , index-1));
                if(map.containsKey(index-1)) map.get(index-1).add(curr.left.val);
                else map.put(index-1 , new ArrayList<>(Arrays.asList(curr.left.val)));
            }

            if(curr.right != null)
            {
                queue.offer(new VerticalPair(curr.right , index+1));
                if(map.containsKey(index+1)) map.get(index+1).add(curr.right.val);
                else map.put(index+1 , new ArrayList<>(Arrays.asList(curr.right.val)));
            }
        }

        for(Map.Entry<Integer,List<Integer>> m1 : map.entrySet()) 
        {
            result.add(m1.getValue());
        }

        return result;
    }
}