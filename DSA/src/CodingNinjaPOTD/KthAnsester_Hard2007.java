package CodingNinjaPOTD;

import java.util.*;
import com.example.datastructure.skeleton.TreeNode;

public class KthAnsester_Hard2007 {      
    static int findKthAncestor(TreeNode root, int targetNodeVal, int kth) {
        // Write your code here.
        Map<TreeNode,TreeNode> map = new HashMap<>();
        Queue<TreeNode> target = new LinkedList<>();
        markParent(root , map , target , targetNodeVal);
        if(target.isEmpty()) return -1;

        while(! target.isEmpty() && kth>0)
        {
            TreeNode bt = target.poll();
            if(map.containsKey(bt))
            {
                target.offer(map.get(bt));
                kth--;
            }
            else return -1;
        }

        TreeNode res = target.poll();
        return res.val;
    }

    static void markParent(TreeNode root , Map<TreeNode,TreeNode> map , 
    Queue<TreeNode> target , int targetNodeVal)
    {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty())
        {
            TreeNode bt = queue.poll();
            if(bt.val == targetNodeVal) target.offer(bt);
            if(bt.left != null)
            {
                map.put(bt.left , bt);
                queue.offer(bt.left);
            }
            if(bt.right != null)
            {
                map.put(bt.right , bt);
                queue.offer(bt.right);
            }
        }
    }
}   
