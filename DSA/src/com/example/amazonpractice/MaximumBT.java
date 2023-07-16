package com.example.amazonpractice;

import java.util.Arrays;

import com.example.datastructure.skeleton.TreeNode;

public class MaximumBT {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int index = 0;
        int max = 0;
        int len = nums.length;
        if(len == 0) return null;
        if(len == 1) return new TreeNode(nums[0]);
        for(int i=0;i<len;i++)
        {
            if(nums[i]>max)
            {
                max = nums[i];
                index=i;
            }
        }
        TreeNode root = new TreeNode(nums[index]);
        root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums , 0 , index));
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums , index+1,len));

        return root;
    }
}