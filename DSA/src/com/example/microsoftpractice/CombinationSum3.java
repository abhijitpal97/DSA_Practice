package com.example.microsoftpractice;

import java.util.*;

public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        function(result, new ArrayList<Integer>(),k,n,1);

        return result;
    }

    void function(List<List<Integer>> result , List<Integer> list , int k , int target,int index)
    {
        if(list.size()==k && target==0)
        {
            result.add(new ArrayList<>(list));
            return;
        }
        if(list.size()>k) return;
        if(target<0) return;
        if(index>9) return;
       
        //pick
        list.add(index);
        function(result , list , k , target-index , index+1);
        list.remove(list.remove(list.size()-1));
        function(result , list , k , target , index+1);
    }
}