package CodingNinjaPOTD;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

// https://www.codingninjas.com/studio/problems/larget-number-in-binary-tree_790727

public class LargestNumberStringInBinaryTree_Moderate2511 {
	public static String printLargest(TreeNode root) {
		// Write your code here.
		List<String> list = new ArrayList<>();
		traverseTree(root , list);
		Collections.sort(list, new Comparator<String>()
		{
			public int compare(String x , String y)
			{
				String xy = x+y;
				String yx = y+x;

				return xy.compareTo(yx)>0?-1:1;
			}
		});

		StringBuilder sb = new StringBuilder();
		for(String str: list)
		{
			sb.append(str);
		}

		String res = sb.toString();
		int i=0;
		while(i+1<res.length() && res.charAt(i)=='0' && res.charAt(i) == res.charAt(i+1))
		{
			i++;
		}
		//System.out.println(res + " - "+i);
		//System.out.println( res.substring(i));
		return res.substring(i);

	}

	static void traverseTree(TreeNode root , List<String> list)
	{
		if(root == null) return ;
		list.add(String.valueOf(root.val));

		traverseTree(root.left,list);
		traverseTree(root.right,list);
	}
}