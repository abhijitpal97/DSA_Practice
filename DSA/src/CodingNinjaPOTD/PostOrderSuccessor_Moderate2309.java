package CodingNinjaPOTD;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

public class PostOrderSuccessor_Moderate2309
{    
	public static int postOrderSuccessor(TreeNode root, int M)
	{

		List<Integer> list = new ArrayList<>();
		postOrder(root,list);

		int i = 0;
		while(list.get(i) != M)
		{
			i++;
			if(i==list.size()) return -1;
		}

		if(i==list.size()-1) return -1;

		return list.get(i+1);

	}

	static void postOrder(TreeNode root, List<Integer> list)
	{
		if(root == null) return;

		postOrder(root.left,list);
		postOrder(root.right,list);
		list.add(root.val);
	}

}
