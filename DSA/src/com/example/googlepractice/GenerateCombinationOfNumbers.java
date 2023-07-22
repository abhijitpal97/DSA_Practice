package com.example.googlepractice;

import java.util.*;

public class GenerateCombinationOfNumbers {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        function(n,k,new ArrayList<>(),result,1);
        return result;
    }

    void function(int n , int k , List<Integer> list , List<List<Integer>> result,int i)
    {
        //if(k>0 || n<=0) return;
        if(k==0)
        {
            List<Integer> temp = new ArrayList<>(list);
            Collections.sort(temp);
            if(!result.contains(temp)) result.add(new ArrayList<>(temp));
            return;
        }

        if(i>n) return;

        //pick
        list.add(i);
        function(n,k-1,list,result,i+1);
        list.remove(list.size()-1);
        function(n,k,list,result,i+1);        
    }
}