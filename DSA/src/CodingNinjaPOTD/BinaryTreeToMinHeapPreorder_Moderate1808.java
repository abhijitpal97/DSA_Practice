package CodingNinjaPOTD;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

public class BinaryTreeToMinHeapPreorder_Moderate1808 {
	public static TreeNode convertBST(TreeNode root) {
		// Write your code here.
		Queue<Integer> pq = new PriorityQueue<>();
		convertHelper(root , pq);

		return constructTree(pq);

	}

	static TreeNode constructTree(Queue<Integer> pq)
	{
		if(pq.isEmpty()) return null;

		TreeNode tree = new TreeNode(pq.poll());
		tree.left = null;
		tree.right = constructTree(pq);

		return tree;
	}

	static void convertHelper(TreeNode root , Queue<Integer> pq)
	{
		if(root == null) return;

		convertHelper(root.left , pq);
		pq.offer(root.val);
		convertHelper(root.right , pq);
	}
}

