package CodingNinjaPOTD;
import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

public class LeftViewTree_Moderate3107 {

    public static void leftView(TreeNode root) {
        //Your code goes here
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return;
        StringBuilder sb = new StringBuilder();
        queue.offer(root);
        while(! queue.isEmpty())
        {
            int size = queue.size();
            boolean flag = false;
            for(int i=0;i<size;i++)
            {
                TreeNode curr = queue.poll();
                if(! flag) 
                {
                    sb.append(curr.val).append(" ");
                    flag = true;
                }

                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
        }

        System.out.println(sb.substring(0 , sb.length()));
    }
}
