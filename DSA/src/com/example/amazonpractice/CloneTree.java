package com.example.amazonpractice;

import java.util.HashMap;
import java.util.Map;

import com.example.datastructure.skeleton.TreeNode;

public class CloneTree{
    public TreeNode cloneTree(TreeNode tree){
       // add code here.
       HashMap<TreeNode,TreeNode> map = new HashMap<>();
       visitTree(tree , map);
       
       TreeNode copy = tree;
       
       copyNode(copy , map);
       
       return map.get(tree);
     }
     
     void visitTree(TreeNode tree , HashMap<TreeNode,TreeNode> map)
     {
         if(tree == null) return;
         map.put(tree , new TreeNode(tree.val));
         visitTree(tree.left , map);
         visitTree(tree.right , map);
     }
     
     void copyNode(TreeNode copy , Map<TreeNode,TreeNode> map )
     {
         if(copy == null) return;
         
         map.get(copy).left = map.get(copy.left);
         map.get(copy).right = map.get(copy.right);
         map.get(copy).random = map.get(copy.random);
         
         copyNode(copy.left , map);
         copyNode(copy.right , map);
     }
}