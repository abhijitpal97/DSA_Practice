package CodingNinjaPOTD;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

// https://www.codingninjas.com/studio/problems/same-bst_920453

public class CheckBST_Moderate2312 {

	public static Boolean checkBSTs(TreeNode root1, TreeNode root2) {       
		// Write Your Code here.
		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();
		traverse(set1 , root1);
		traverse(set2 , root2);
		return find(set1 , set2);
	}

	static void traverse(Set<Integer> set , TreeNode root)
	{
		if(root == null) return;
		set.add(root.val);
		traverse(set , root.left);
		traverse(set , root.right);
	}

	static boolean find(Set<Integer> set1 , Set<Integer> set2)
	{
		if(set1.size() != set2.size()) return false;

		//System.out.println("S1 P - "+set1);
		//System.out.println("S2 P - "+set2);

		for(int i : set1)
		{
			if(! set2.contains(i)) return false;
			set2.remove(i);
			//set1.remove(i);
		}

		//System.out.println("S1 - "+set1);
		//System.out.println("S2 - "+set2);
		return set2.isEmpty();
	}

}