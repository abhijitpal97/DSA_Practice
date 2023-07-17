package com.example.microsoftpractice;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

public class SerializeDeserialize {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "#";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        String str = "";

        while(! queue.isEmpty())
        {
            TreeNode node = queue.poll();
            if(node == null)
            {
                str += "# ";
                continue;
            }

            str += node.val+" ";
            queue.offer(node.left);
            queue.offer(node.right);
        }
        
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("#")) return null;
        String[] splittedData = data.split("\\s");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(splittedData[0]));
        queue.offer(root);
        for(int i=1;i<splittedData.length;i++)
        {
            TreeNode curr = queue.poll();

            if(! splittedData[i].equals("#"))
            {
                TreeNode left = new TreeNode(Integer.valueOf(splittedData[i]));
                curr.left = left;
                queue.add(left);
            }

            if(! splittedData[++i].equals("#"))
            {
                TreeNode right = new TreeNode(Integer.valueOf(splittedData[i]));
                curr.right = right;
                queue.add(right);
            }
        }

        return root;

    }

}