package com.example.microsoftpractice;

import java.util.Arrays;

import com.example.datastructure.skeleton.TreeNode;

public class TreePreOrderInOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder==null || inorder==null || 
        inorder.length==0 || preorder.length==0) return null;

        TreeNode node = new TreeNode(preorder[0]);
        int iPos=0;
        boolean flag=false;
        for(int i=0;i<inorder.length;i++)
        {
            if(inorder[i]==preorder[0])
            {
                iPos=i;
                flag = true;
                break;
            }
            if(flag) break;

        }
        int[] preOrderL = Arrays.copyOfRange(preorder,1,iPos+1);
        int[] preOrderR = Arrays.copyOfRange(preorder,iPos+1,preorder.length);
        int[] inOrderL = Arrays.copyOfRange(inorder,0,iPos);
        int[] inOrderR = Arrays.copyOfRange(inorder,iPos+1,inorder.length);
        node.left = buildTree(preOrderL , inOrderL);
        node.right = buildTree(preOrderR , inOrderR);


        return node;
    }
}