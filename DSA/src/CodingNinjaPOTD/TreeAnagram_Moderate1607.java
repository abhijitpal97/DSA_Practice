package CodingNinjaPOTD;

import java.util.*;

import com.example.datastructure.skeleton.TreeNode;

// https://www.codingninjas.com/studio/problems/check-if-all-levels-of-two-trees-are-anagrams-of-each-other-not_1214546

public class TreeAnagram_Moderate1607 {

	public static boolean anagram(TreeNode root1, int n, 
			TreeNode root2, int m) {
		// Write your code here
		if(root1 == null && root2 == null) return true;
		Queue<TreeNode> q1 = new LinkedList<>();
		Queue<TreeNode> q2 = new LinkedList<>();
		q1.offer(root1);
		q2.offer(root2);
		while(! q1.isEmpty() && !q2.isEmpty())
		{
			//System.out.println("Inside While");
			if(q1.size() != q2.size()) return false;
			int size = q1.size();
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			for(int i=0;i<size;i++)
			{
				TreeNode curr1 = q1.poll();
				TreeNode curr2 = q2.poll(); 
				sb1.append(String.valueOf(curr1.val));
				sb2.append(String.valueOf(curr2.val));
				if(curr1.left != null) q1.offer(curr1.left);
				if(curr1.right != null) q1.offer(curr1.right);
				if(curr2.left != null) q2.offer(curr2.left);
				if(curr2.right != null) q2.offer(curr2.right);                
			}
			if(! checkAnagram(sb1.toString() , sb2.toString())) return false;
		}
		//System.out.println("Outside While");
		if(!q1.isEmpty() || ! q2.isEmpty()) return false;

		return true;
	}

	static boolean checkAnagram(String str1 , String str2)
	{
		char[] sortedchars = str1.toCharArray();
		Arrays.sort(sortedchars);
		str1 = new String(sortedchars);

		char[] sortedchar2 = str2.toCharArray();
		Arrays.sort(sortedchar2);
		str2 = new String(sortedchar2);
		//System.out.println(str1 + " - "+str2+" - "+str1.equals(str2));
		return str1.equals(str2);
	}
}