package LeetCodePOTD;

import java.util.*;

public class LetterCombinationPhoneNumber_0308 {
    char[][] map = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},
        {'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        function(digits , "" , list);
        return list;
    }
    void function(String digits , String ref , List<String> list)
    {
        if(digits.length() == 0)
        {
            if(!ref.isBlank())list.add(ref);
            return;
        }

        char curr = digits.charAt(0);
        for(char ch : map[curr - '0'])
        {
            function(digits.substring(1) , ref+ch , list);
        }
    }
}