package CodingNinjaPOTD;
import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

public class KthSmallestTree_Moderate1209 {
    public static int kthSmallest(TreeNode root, int k) {
        // Write your code here.
        List<Integer> list = new ArrayList<>();
        traversal(root , k , list);
        if(list.size()<k) return -1;
        return list.get(list.size()-1);        
    
    }

    static void traversal(TreeNode root , int k , List<Integer> list)
    {
        if(root == null) return;
        traversal(root.left , k , list);
        if(list.size() == k) return;
        list.add(root.val);
        traversal(root.right , k , list);
        if(list.size() == k) return;
    }
}