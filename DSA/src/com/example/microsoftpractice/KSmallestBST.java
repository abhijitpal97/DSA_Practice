package com.example.microsoftpractice;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

public class KSmallestBST {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrderTraversal(root , k , list);
        return list.get(list.size()-1);

    }

    void inOrderTraversal(TreeNode root , int k , List<Integer> list)
    {
        if(root == null) return ;       
        inOrderTraversal(root.left , k , list);
        if(list.size() == k ) return;
        list.add(root.val);        
        inOrderTraversal(root.right , k , list);
    }
}