package com.example.googlepractice;

import com.example.datastructure.skeleton.TreeNode;

public class FlattenBSTToLL {
    public void flatten(TreeNode root) {
         if(root == null) return ;

         flatten(root.left);
         if(root != null)
         {
             TreeNode temp = root.right;
             root.right = root.left;
             root.left = null;
             while(root.right != null) root = root.right;
             root.right = temp;
         }
         flatten(root.right);
    }
    
}