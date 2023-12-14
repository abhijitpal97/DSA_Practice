package CodingNinjaPOTD;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

// https://www.codingninjas.com/studio/problems/convert-bst-to-min-heap_920498

public class BSTToMinHeap_Moderate0712 {
	static int index = 0;
	public static TreeNode convertBST(TreeNode root) {
		// Write your code here.
		index = 0;
		if(root == null) return null;
		List<Integer> list = new ArrayList<>();
		generateMin(root , list);

		convertTree(root , list);

		return root;
	}

	static void convertTree(TreeNode root , List<Integer> list)
	{
		if(root == null) return;

		root.val = list.get(index);
		index++;

		convertTree(root.left , list);
		convertTree(root.right , list);
	}

	static void generateMin(TreeNode root , List<Integer> list)
	{
		if(root == null) return;

		generateMin(root.left,list);
		list.add(root.val);
		generateMin(root.right,list);
	}
}

