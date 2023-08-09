package CodingNinjaPOTD;

import com.example.datastructure.skeleton.TreeNode;

public class LowestCommonAncester_Moderate0908 {
	public static int lowestCommonAncestor(TreeNode root, int x, int y) {
		//    Write your code here.
		if(root == null) return Integer.MIN_VALUE;
		if( x == root.val || y == root.val) return root.val;

		int le = lowestCommonAncestor(root.left , x , y);
		int ri = lowestCommonAncestor(root.right , x , y);

		if(le == Integer.MIN_VALUE) return ri;
		if(ri == Integer.MIN_VALUE) return le;
		return root.val;
	}
}