package StriverSheet175AndLoveBabbar450;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

// https://www.codingninjas.com/studio/problems/path-in-a-tree_3843990

public class PathInATree {
	public static ArrayList<Integer> pathInATree(TreeNode root, int x) {
		// Write your code here..

		ArrayList<Integer> list = new ArrayList<>();
		function(root , x , list);
		list.add(root.val);
		Collections.reverse(list);
		return list;
	}

	static boolean function(TreeNode root , int x , ArrayList<Integer> list)
	{
		if(root == null) return false;
		if(root.val == x) return true;

		if(function(root.left,x,list))
		{
			list.add(root.left.val);
			return true;
		}

		if(function(root.right,x,list))
		{
			list.add(root.right.val);
			return true;
		}

		return false;
	}

}