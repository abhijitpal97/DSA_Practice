package com.example.googlepractice;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

public class UniqueBinarySearhTree {
    
	public List<TreeNode> generateTrees(int n) {
        return generate(1 , n);
        
    }

    List<TreeNode> generate(int start , int end)
    {
        List<TreeNode> list = new ArrayList<>();

        if(start>end)
        {
            list.add(null);
            return list;
        }

        for(int i=start;i<=end;i++)
        {
            List<TreeNode> left = generate(start,i-1);
            List<TreeNode> right = generate(i+1 , end);

            for(TreeNode l : left)
            {
                for(TreeNode r : right)
                {
                    TreeNode tree = new TreeNode(i);
                    tree.left = l;
                    tree.right = r;

                    list.add(tree);
                }
            }
            
        }

        return list;
    }
}