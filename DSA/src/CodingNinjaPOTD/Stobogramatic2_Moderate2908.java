package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

public class Stobogramatic2_Moderate2908 {
    public static ArrayList<String> findStrobogrammatic(int n) {
    	// Write your code here.
        ArrayList<String> ans = function(n, n);

        return ans;
    }

    public static ArrayList<String> function(int n, int len){

        ArrayList<String> res = new ArrayList<String>();

        // If len = 0, return empty string.
        if (len == 0) {
            res.add("");
            return res;
        }

        if (len == 1) {
            res.add("0");
            res.add("1");
            res.add("8");
            return res;
        }

        ArrayList<String> prev = function(n, len - 2);

        for(int i = 0 ;i<prev.size();i++)
        {
            if(len != n) res.add("0"+prev.get(i)+"0");
        
            res.add("1" + prev.get(i) + "1");
            res.add("6" + prev.get(i) + "9");
            res.add("8" + prev.get(i) + "8");
            res.add("9" + prev.get(i) + "6");
        }

        return res;
    }
}