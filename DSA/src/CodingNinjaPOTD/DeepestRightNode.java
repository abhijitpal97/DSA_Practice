package CodingNinjaPOTD;
/*

    Time Complexity: O(N)
    Space Complexity: O(2 ^ D)

    Where N is the total number of nodes in the given Binary Tree. 
    Where D is depth of the Binary tree having maximum nodes present.

 */

import java.util.LinkedList;
import java.util.Queue;

import com.example.datastructure.skeleton.TreeNode;

//https://www.codingninjas.com/studio/problems/deepest-right-leaf_764143?leftPanelTabValue=PROBLEM

public class DeepestRightNode {

	public static TreeNode deepestRightLeaf(TreeNode root) {

		// If the root node is empty, then return.
		if (root == null) {
			return null;
		}

		// Create a queue for level order traversal and add the root node into it.
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		// Node to store the deepest rightmost node.
		TreeNode result = null;

		// Traverse until the queue is empty.
		while (!q.isEmpty()) {

			// Storing the peek of the queue in the temp node and removing it from the Queue.
			TreeNode temp = q.peek();
			q.poll();

			// If left child is present, push it into the Queue.
			if (temp.left != null) {
				q.add(temp.left);
			}

			// If right child is present, add it into the Queue.
			if (temp.right != null) {
				q.add(temp.right);

				// Update the result with each right leaf node, the last one to update will be the deepest rightmost node.
				if (temp.right.left == null && temp.right.right == null) {
					result = temp.right;
				}
			}
		}

		// Return the deepest rightmost node stored in result.
		return result;
	}

}