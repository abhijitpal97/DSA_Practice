package com.example.amazonpractice;

public class RepeatedStringMatch {
    public int repeatedStringMatch(String a, String b) {
       String str="";
       int count = 0;

       while(str.length()<(b.length()+2*a.length()))
       {
           str += a;
           count++;
           if(str.contains(b)) return count;
       }

       return -1;
    }
}