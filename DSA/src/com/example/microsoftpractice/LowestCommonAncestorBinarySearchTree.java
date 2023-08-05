package com.example.microsoftpractice;

import com.example.datastructure.skeleton.TreeNode;

public class LowestCommonAncestorBinarySearchTree
{   
    //Function to find the lowest common ancestor in a BST. 
	TreeNode LCA(TreeNode root, int n1, int n2)
	{
        // code here. 
        if(root == null) return null;
        if(n1==root.val || n2==root.val) return root;
        if(n1>root.val && n2<root.val || n1<root.val && n2>root.val) return root;
        if(n1<root.val && n2<root.val) return LCA(root.left , n1 , n2);
        else if(n1>root.val && n2>root.val) return LCA(root.right , n1 , n2);
        return root;
    }
    
}