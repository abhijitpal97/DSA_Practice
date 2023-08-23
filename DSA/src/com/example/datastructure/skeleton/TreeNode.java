package com.example.datastructure.skeleton;

import java.util.List;

public class TreeNode {
     public int val;
     public TreeNode left;
     public TreeNode right;
     public TreeNode random;
     public TreeNode next;
     public List<TreeNode> children;
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