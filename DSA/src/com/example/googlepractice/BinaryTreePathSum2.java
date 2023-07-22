package com.example.googlepractice;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

public class BinaryTreePathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        if(isLeaf(root) && root.val == targetSum)
        {
            result.add(new ArrayList<>(Arrays.asList(root.val)));
            return result;
        }
        calculateSum(root , targetSum , new ArrayList<>() , result);
        return result;
    }

    void calculateSum(TreeNode root , int target , List<Integer> list , List<List<Integer>> result)
    {
        if(root == null) return;
        if(isLeaf(root) && target==root.val)
        {
            list.add(root.val);
            result.add(new ArrayList<>(list));
            list.remove(list.size()-1);
        }
        
        list.add(root.val);
        calculateSum(root.left , target-root.val , list , result);
        calculateSum(root.right , target-root.val , list , result);
        list.remove(list.size()-1);
    }

    boolean isLeaf(TreeNode node)
    {
        if(node.left == null && node.right == null) return true;
        return false;
    }
}