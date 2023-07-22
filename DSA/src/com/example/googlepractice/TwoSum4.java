package com.example.googlepractice;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

public class TwoSum4 {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return hasTarget(root , k , set);
    }

    boolean hasTarget(TreeNode root , int target , Set<Integer> set)
    {
        if(root == null) return false;
        if(set.contains(target-root.val)) return true;

        set.add(root.val);

        return hasTarget(root.left , target , set) || hasTarget(root.right , target , set);        
    }
}