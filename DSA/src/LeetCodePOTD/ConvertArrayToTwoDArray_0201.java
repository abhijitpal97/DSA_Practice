package LeetCodePOTD;

import java.util.*;

// https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/

public class ConvertArrayToTwoDArray_0201 {
	public List<List<Integer>> findMatrix(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		for(int i=0; i<nums.length;i++)
		{
			int curr = nums[i];

			if(result.size()==0)
			{
				result.add(new ArrayList<>(Arrays.asList(curr)));
			}
			else
			{
				boolean flag = false;
				for(List<Integer> li : result)
				{
					if(! li.contains(curr))
					{
						li.add(curr);
						flag = true;
					}
					if(flag) break;
				}
				if(!flag) result.add(new ArrayList<>(Arrays.asList(curr)));
			}
		}

		return result;
	}
}