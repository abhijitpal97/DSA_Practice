package com.example.gspractice;

import java.util.*;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Queue<int[]> queue = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        getAllPermutationSum(nums,0,queue,0,target,0);
        if(queue.isEmpty()) return 0;
        return queue.peek()[0];
    }

    void getAllPermutationSum(int[] nums , int sum , Queue<int[]> queue,int index,int target,int count)
    {
        if(count==3)
        {
            //System.out.println(sum);
            queue.offer(new int[]{sum , Math.abs(target-sum)});
            return;
        }
        if(index >=nums.length) return;
        
        getAllPermutationSum(nums,sum+nums[index],queue,index+1,target,count+1);
        getAllPermutationSum(nums,sum,queue,index+1,target,count);
    }
    
    // Two Pointer
    public int threeSumClosestTwoPointer(int[] nums, int target) {
        Arrays.sort(nums);
        int ans=0,diff=Integer.MAX_VALUE;
        for(int i=0;i<nums.length-2;i++){
            int first=nums[i];
            int start=i+1,end=nums.length-1;
            while(start<end){
                if(first+nums[start]+nums[end]==target){
                    return target;
                }
                else if((Math.abs(first+nums[start]+nums[end]-target)<diff)){
                    diff=Math.abs(first+nums[start]+nums[end]-target);
                    ans=first+nums[start]+nums[end];
                }
                if(first+nums[start]+nums[end]<target){
                    start++;
                }
                else{
                    end--;
                }
            }
        }
        return ans;

        
    }
}