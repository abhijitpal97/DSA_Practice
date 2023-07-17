package CodingNinjaPOTD;

import com.example.datastructure.skeleton.TreeNode;

public class RecoverBST {
    TreeNode prev= null;
    TreeNode first = null;
    TreeNode second = null;

    public void recoverTree(TreeNode root) {
       if(root == null) return;
        inOrder(root);

        int temp = first.val;
        first.val = second.val;
        second.val=temp;
        
    }

    void inOrder(TreeNode root)
    {
        if(root== null) return;
        
        inOrder(root.left);
        if(prev != null && prev.val>root.val)
        {
            if(first == null) first = prev;
            second = root;
        }
        prev = root;
        inOrder(root.right);
    }
}