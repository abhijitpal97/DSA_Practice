package com.example.amazonpractice;


public class NextPrimePalindrome {
    public int primePalindrome(int n) {
        if(isPrime(n) && isPalindrome(n)) return n;
        while(true)
        {
            if(isPrime(n) && isPalindrome(n)) return n;
            n++;

            if (10000000 < n && n < 100000000) n = 100000000;
        }
    }
    
    
        static boolean isPrime(int n) {  
        if (n <= 1) {  
            return false;  
        }  
        for (int i = 2; i*i <= n; i++) {  
            if (n % i == 0) {  
                return false;  
            }
            
        }
        return true;  
        
        }

    public static boolean isPalindrome(int x) {
        int r,s=0,c=x;
        while(x>0){
            r=x%10;
            s=(s*10)+r;
            x = x/10;
        }
        if(c==s) return true; 
        else return false;
    }
}