package CodingNinjaPOTD;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

// https://practice.geeksforgeeks.org/problems/check-whether-bst-contains-dead-end/1

public class IsDeadEndBST_Moderate0609 {
	public static Boolean isDeadEnd(TreeNode root) {
		// Write your code here
		Map<Integer,Integer> map = new HashMap<>();
		map.put(0 , 1);
		getAllNodes(root , map);
		return check(root , map);
	}

	static void getAllNodes(TreeNode root , Map<Integer,Integer> map)
	{
		if(root == null) return;

		map.put(root.val,1);
		getAllNodes(root.left , map);
		getAllNodes(root.right , map);
	}

	static boolean check(TreeNode root , Map<Integer,Integer> map)
	{
		if(root == null) return false;

		if(root.left == null && root.right == null)
		{
			int prev = root.val-1;
			int next = root.val+1;
			if(map.containsKey(prev) && map.containsKey(next)) return true;

		}

		return check(root.left , map) || check(root.right , map);           

	}
}
