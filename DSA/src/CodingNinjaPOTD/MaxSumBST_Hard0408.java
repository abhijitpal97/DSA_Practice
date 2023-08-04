package CodingNinjaPOTD;

import com.example.datastructure.skeleton.TreeNode;

public class MaxSumBST_Hard0408 {
    static TreeNode prev = null;
    static int max = Integer.MIN_VALUE;
    static int maximumSumBST(TreeNode root) {
        // Write your code here.
        max = Integer.MIN_VALUE;
        if(root == null) return 0;
        calculateMax(root);
        return max;
        
    }

    static void calculateMax(TreeNode node)
    {
        if(node == null) return;

        prev = null;
        if(isBST(node))
        {
            //System.out.println("Node = "+node.val+" curr Max "+max);
            max = Math.max(max , sumTreeValue(node));
            //System.out.println("Max = "+max);
            return;
        }
        calculateMax(node.left);
        calculateMax(node.right);

    }

    static int sumTreeValue(TreeNode root)
    {
        if(root == null) return 0;
        int l = sumTreeValue(root.left);
        int r = sumTreeValue(root.right);

        return l+r+root.val;
    }


    static boolean isBST(TreeNode node)
    {
        if(node == null) return true;
        boolean l = isBST(node.left);
        if(prev != null && prev.val >= node.val) return false;
        else
        {
            prev = node;
        }
        boolean r = isBST(node.right);

        return l && r;
    }




}
