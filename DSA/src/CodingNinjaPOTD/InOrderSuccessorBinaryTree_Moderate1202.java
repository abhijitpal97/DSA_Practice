package CodingNinjaPOTD;
import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

// https://www.codingninjas.com/studio/problems/inorder-sucessor_799913

public class InOrderSuccessorBinaryTree_Moderate1202 {
	public static TreeNode inorderSuccesor(TreeNode root, TreeNode node) {
		// Write you code here.
		List<TreeNode> list = new ArrayList<>();
		function(root , list);
		int n = list.size();
		for(int i=0;i<n; i++)
		{
			if(list.get(i).val == node.val)
			{
				if(i==n-1) return null;
				return list.get(i+1);
			}
		}
		return null;
	}

	static void function(TreeNode root , List<TreeNode> list)
	{
		if(root == null) return;

		function(root.left , list);
		list.add(root);
		function(root.right , list);
	}
}