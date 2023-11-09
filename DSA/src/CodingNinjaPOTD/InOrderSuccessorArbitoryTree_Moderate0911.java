package CodingNinjaPOTD;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

// https://www.codingninjas.com/studio/problems/inorder-successors_2084578

public class InOrderSuccessorArbitoryTree_Moderate0911 {
	public static TreeNode inorderSuccesor(TreeNode root, TreeNode node) {
		// Write you code here.
		List<TreeNode> list = new ArrayList<>();
		inOrder(root , list);

		for(int i=0; i<list.size() ; i++)
		{
			if(list.get(i).val == node.val && i+1<list.size()) return list.get(i+1);
		}
		return null;
	}

	static void inOrder(TreeNode root , List<TreeNode> list)
	{
		if(root == null) return;
		inOrder(root.left,list);
		list.add(root);
		inOrder(root.right,list);
	}
}