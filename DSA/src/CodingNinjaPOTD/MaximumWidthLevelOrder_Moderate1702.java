package CodingNinjaPOTD;
import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

// https://www.codingninjas.com/studio/problems/maximum-width-in-binary-tree_763671

public class MaximumWidthLevelOrder_Moderate1702 {
	public static int getMaxWidth(TreeNode root) {
		// Write your code here.
		if(root == null) return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		int max = 0;

		while(! queue.isEmpty())
		{
			int currWidth = queue.size();
			if(currWidth>max)
			{
				max = currWidth;
			}

			while(currWidth>0)
			{
				TreeNode curr = queue.poll();
				if(curr.left != null) queue.offer(curr.left);
				if(curr.right != null) queue.offer(curr.right);

				currWidth--;
			}

		}

		return max;
	}
}