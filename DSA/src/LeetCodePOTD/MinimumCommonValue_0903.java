package LeetCodePOTD;
// https://leetcode.com/problems/minimum-common-value/

import java.util.Arrays;

public class MinimumCommonValue_0903 {
	public int getCommon(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int n = nums1.length;
		int m = nums2.length;
		int common = -1;
		int x = 0;
		int y = 0;
		while(x<n && y<m)
		{
			if(nums1[x] == nums2[y])
			{
				return nums1[x];
			}
			else if(nums1[x]<nums2[y]) x++;
			else y++;
		}
		return common;
	}
}