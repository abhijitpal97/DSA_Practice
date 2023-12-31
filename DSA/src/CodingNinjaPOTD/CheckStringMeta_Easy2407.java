package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/meta-strings_1089556?leftPanelTab=0
public class CheckStringMeta_Easy2407{

	public static void main(String[] args)
	{
		boolean res = checkMeta("Coding", "Codnig");
		System.out.println(res);
	}
	public static boolean checkMeta(String str1, String str2) {
		// Write your code here.
		int l1 = str1.length();
		int l2 = str2.length();
		if(str1.equals(str2) || l1 != l2) return false;
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<l1;i++)
		{
			if(str1.charAt(i) == str2.charAt(i)) continue;
			stack.push(i);
		}
		if(stack.size() != 2) return false;
		int first = stack.pop();
		int second=stack.pop();

		char ch = str1.charAt(first);
		char ch1 = str1.charAt(second);

		str1 = str1.substring(0,second)+ch+str1.substring(second+1 , first)+ch1+str1.substring(first+1);

		if(str1.equals(str2)) return true;
		return false;
	}

	public static boolean checkMetaSpace(String str1, String str2) {
		// Write your code here.
		int n = str1.length();
		int m = str2.length();

		if(n != m) return false;

		int[] arr1 = new int[2];
		int[] arr2 = new int[2];
		int count = 0;
		int index = 0;
		for(int i=0;i<n;i++)
		{
			if(str1.charAt(i) == str2.charAt(i)) continue;
			if(index>=2) return false;

			arr1[index] = str1.charAt(i);
			arr2[index] = str2.charAt(i);
			index++;
		}
		if(index<2) return false;

		return (arr1[0] == arr2[1]) && (arr1[1] == arr2[0]);
	}
}