package com.example.microsoftpractice;

import java.util.*;

public class BulbSwitcher2 {
    public int flipLights(int n, int presses) {
        if(presses == 0) return 1;
        if(n==1) return 2;
        List<String> list = new ArrayList<>();
        String str = "";
        for(int i=0;i<=n;i++) str+='o';
        function(presses , str , list);
        //System.out.println(list);
        return list.size();
    }

    void function(int presses , String str , List<String> list)
    {
        if(presses == 0 ) 
        {
            if(! list.contains(str)) list.add(str);
            return;
        }

        //b1 - flip
        function(presses-1 , flip(str) , list);
        //b2 - even
        function(presses-1 , even(str) , list);
        //b3 - odd
        function(presses-1 , odd(str) , list);
        //b4 = with status
        function(presses-1 , rand(str) , list);

        
    }

    String flip(String str)
    {
        char[] chars = str.toCharArray();
        for(int i=1 ; i<chars.length ; i++)
        {
            if(chars[i] == 'o') chars[i] = 'k';
            else chars[i]='o';
        }

        return new String(chars);
    }
    String even(String str)
    {
        char[] chars = str.toCharArray();
        for(int i=2 ; i<chars.length ; i=i+2)
        {
            if(chars[i] == 'o') chars[i] = 'k';
            else chars[i]='o';
        }

        return new String(chars);
    }
    String odd(String str)
    {
        char[] chars = str.toCharArray();
        for(int i=1 ; i<chars.length ; i=i+2)
        {
            if(chars[i] == 'o') chars[i] = 'k';
            else chars[i]='o';
        }

        return new String(chars);
    }
    String rand(String str)
    {
        char[] chars = str.toCharArray();
        for(int i=1 ; i<chars.length ; i=3*i+1)
        {
            if(chars[i] == 'o') chars[i] = 'k';
            else chars[i]='o';
        }

        return new String(chars);
    }
    


}