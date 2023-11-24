package StriverSheet175AndLoveBabbar450;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/word-break_1094901

public class PossibleWordBreak	 {
    public static Boolean wordBreak(String[] arr, int n, String target) {
        // Write your code here.
        List<String> dict = new ArrayList<>();
        for(String str : arr) dict.add(str);
        return function(target , dict);
    }

    static boolean function(String target , List<String> dict)
    {
        if(target.length() == 0) return true;

        for(String str : dict)
        {
            if(target.indexOf(str) == 0)
            {
                if(function(target.substring(str.length()) , dict)) return true;   
            }
        }

        return false;
    }
}