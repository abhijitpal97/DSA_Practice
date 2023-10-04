package com.example.microsoftpractice;

// https://leetcode.com/problems/compare-version-numbers/description/

public class CompareVersion {
	public int compareVersion(String version1, String version2) {
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");

		int l1 = v1.length;
		int l2 = v2.length;
		int i=0;
		for(i=0 ; i<Math.min(l1,l2) ; i++)
		{
			if(Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])) return -1;
			else if(Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])) return 1;
		}

		if(i==l1)
		{
			while(i<l2)
			{
				if(Integer.parseInt(v2[i]) > 0) return -1;
				i++;
			}
		}

		if(i==l2)
		{
			while(i<l1)
			{
				if(Integer.parseInt(v1[i]) > 0) return 1;
				i++;
			}
		}

		return 0;
	}
}