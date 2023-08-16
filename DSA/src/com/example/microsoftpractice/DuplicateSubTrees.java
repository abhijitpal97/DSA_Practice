package com.example.microsoftpractice;

import java.util.*;
import com.example.datastructure.skeleton.TreeNode;

public class DuplicateSubTrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String,Integer> map = new HashMap<>();
        List<TreeNode> result = new ArrayList<>();
        function(root , map , result);

        return result;
    }

    String function(TreeNode root , Map<String,Integer> map , List<TreeNode> result)
    {
        if(root == null) return "";

        String l = function(root.left,map,result);
        String r = function(root.right,map,result);
        String str = root.val+"#"+l+"#"+r;

        map.put(str, map.getOrDefault(str , 0)+1);
        if(map.get(str) == 2) result.add(root);

        return str;
    }
}