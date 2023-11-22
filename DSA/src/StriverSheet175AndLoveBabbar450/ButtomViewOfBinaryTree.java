package StriverSheet175AndLoveBabbar450;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;


class ButtomViewPair
{
	TreeNode node;
	int index;

	ButtomViewPair(TreeNode node , int index)
	{
		this.node = node;
		this.index = index;
	}
}


public class ButtomViewOfBinaryTree {
	public static List<Integer> bottomView(TreeNode root) {
		// Write your code here.   
		Queue<ButtomViewPair> queue = new LinkedList<>();
		Map<Integer,Integer> map = new TreeMap<>();
		queue.offer(new ButtomViewPair(root,0));

		while(! queue.isEmpty())
		{
			ButtomViewPair p1 = queue.poll();
			TreeNode curr = p1.node;
			int index = p1.index;
			map.put(index , curr.val);

			if(curr.left != null) queue.offer(new ButtomViewPair(curr.left , index-1));
			if(curr.right != null) queue.offer(new ButtomViewPair(curr.right , index+1));
		}

		List<Integer> result = new ArrayList<>();
		for(Map.Entry<Integer,Integer> m1 : map.entrySet()) result.add(m1.getValue());

		return result;


	}
}
