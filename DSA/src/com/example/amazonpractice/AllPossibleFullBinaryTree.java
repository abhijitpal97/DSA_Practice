package com.example.amazonpractice;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

public class AllPossibleFullBinaryTree {
    static Map<Integer, List<TreeNode>> map = new HashMap<>();
    
    public static void main(String[] args)
    {
    	List<TreeNode> res = allPossibleFBT(2);
    	System.out.println(res.size());
    }
    
    public static List<TreeNode> allPossibleFBT(int n) {
        if(! map.containsKey(n))
        {
            List<TreeNode> nodes = new ArrayList<>();
            
            if(n == 1) nodes.add(new TreeNode(0 , null , null));
            else
            {
                for(int i = 1 ; i<=n-2 ; i++)
                {
                    List<TreeNode> leftNodes = allPossibleFBT(i);
                    List<TreeNode> rightNodes = allPossibleFBT(n-i-1);

                    for(TreeNode left : leftNodes)
                    {
                        for(TreeNode right : rightNodes)
                        {
                            nodes.add(new TreeNode(0 , left , right));
                        }
                    }
                }
            }

            map.put(n , nodes);
        }

        return map.get(n);
    }
}