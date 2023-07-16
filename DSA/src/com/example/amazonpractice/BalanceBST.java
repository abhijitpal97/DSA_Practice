package com.example.amazonpractice;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

public class BalanceBST {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> li = new ArrayList<>();
        inOrderBST(root , li);

        TreeNode tree = generateBalancedTree(li , 0 , li.size()-1);

        return tree;
    }

    void inOrderBST(TreeNode root , List<Integer> li)
    {
        if(root == null) return;

        inOrderBST(root.left , li);
        li.add(root.val);
        inOrderBST(root.right , li);
    }

    TreeNode generateBalancedTree(List<Integer> list , int start , int end)
    {
        if(start>end) return null;

        int mid = start + ((end-start)/2) ;

        TreeNode tree = new TreeNode(list.get(mid));
        tree.left = generateBalancedTree(list , start , mid-1);
        tree.right = generateBalancedTree(list , mid+1 , end);

        return tree;
    }
}