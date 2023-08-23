package com.example.microsoftpractice;

public class MinStepsCopyPasteKeyBoard {
    int max = (int)1e9;
    public int minSteps(int n) {
        if(n==1)
            return 0;
        return function(1,0, n , 0);
    }

    int function(int screen , int copy , int n , int paste)
    {
        if(screen == n) return 0;
        if(screen>n) return max;
        
        if(copy == 0)
        {
            return 1+function(screen , 1 , n , screen);
        }
        
        int op1 = 1+function(screen+paste , 1, n , paste);
        int op2 = 1+function(screen+paste , 0 , n , 0);

        return Math.min(op1,op2);
    }
}