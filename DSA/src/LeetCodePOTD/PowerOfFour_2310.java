package LeetCodePOTD;

// https://leetcode.com/problems/power-of-four/description/

public class PowerOfFour_2310 {
    public boolean isPowerOfFour(int n) {
        if(n==1) return true;
        if(n<=0) return false;

        double logbase = Math.log(n) / Math.log(4) ;

        return logbase == (int)logbase;
    }
}