package com.example.datastructure.skeleton;

 public class TreeNode {
     public int val;
     public TreeNode left;
     public TreeNode right;
     public TreeNode random;
     TreeNode() {}
     public TreeNode(int val) { this.val = val; }
     
     public TreeNode(int val, TreeNode left, TreeNode right , TreeNode random) {
         this.val = val;
         this.left = left;
         this.right = right;
         this.random=random;
     }
     
     public TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }