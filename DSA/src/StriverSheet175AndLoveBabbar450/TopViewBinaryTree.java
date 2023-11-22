package StriverSheet175AndLoveBabbar450;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

class TopViewPair
{
	TreeNode node;
	int index;

	TopViewPair(TreeNode node , int index)
	{
		this.node = node;
		this.index = index;
	}
}


public class TopViewBinaryTree {
	public static List<Integer> getTopView(TreeNode root) {
		// Write your code here.
		Queue<TopViewPair> queue = new LinkedList<>();
		Map<Integer,Integer> map = new TreeMap<>();
		queue.offer(new TopViewPair(root,0));

		while(! queue.isEmpty())
		{
			TopViewPair p1 = queue.poll();
			TreeNode curr = p1.node;
			int index = p1.index;
			if(! map.containsKey(index)) map.put(index , curr.val);

			if(curr.left != null) queue.offer(new TopViewPair(curr.left , index-1));
			if(curr.right != null) queue.offer(new TopViewPair(curr.right , index+1));
		}

		List<Integer> result = new ArrayList<>();
		for(Map.Entry<Integer,Integer> m1 : map.entrySet()) result.add(m1.getValue());

		return result;
	}
}
