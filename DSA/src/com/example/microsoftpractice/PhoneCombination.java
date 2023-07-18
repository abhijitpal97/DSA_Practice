package com.example.microsoftpractice;

import java.util.*;

public class PhoneCombination {
    char[][] map = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},
        {'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits.length() == 0 || digits.equals(0) || digits.equals(1)) return list;
        helper(digits , "" , list);

        return list;
    }

    void helper(String digit,String phone , List<String> list)
    {
        if(digit.length()<=0)
        {
            list.add(phone);
            return;
        }

        char di = digit.charAt(0);

        for(char chL : map[di - '0'])
        {
            helper(digit.substring(1) , phone+chL , list);
        }

    }
}