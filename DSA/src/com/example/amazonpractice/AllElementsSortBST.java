package com.example.amazonpractice;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

public class AllElementsSortBST {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        
        getElements(root1 , l1);
        getElements(root2 , l2);

        int i=0;
        int j=0;
        int l1Len = l1.size();
        int l2Len = l2.size();

        while(i<l1Len && j<l2Len)
        {
            if(l1.get(i)<=l2.get(j))
            {
                res.add(l1.get(i));
                i++;
            }
            else
            {
                res.add(l2.get(j));
                j++;
            }
        }

        while(i<l1Len)
        {
            res.add(l1.get(i));
            i++;
        }

        while(j<l2Len)
        {
            res.add(l2.get(j));
            j++;
        }

        return res;
    }

    void getElements(TreeNode root , List<Integer>l1)
    {
        if(root == null) return;

        getElements(root.left , l1);
        l1.add(root.val);
        getElements(root.right , l1);
    }
}