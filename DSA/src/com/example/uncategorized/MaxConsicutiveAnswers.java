package com.example.uncategorized;

// https://leetcode.com/problems/maximize-the-confusion-of-an-exam/description/

public class MaxConsicutiveAnswers {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int ans = function(answerKey , k , 'T');
        ans  = Math.max(ans , function(answerKey , k , 'F'));

        return ans;
    }

    int function(String answerKey , int k , char ch)
    {
        int left = 0;
        int right = 0;
        int n = answerKey.length();
        int ans = 1;

        while(right<n)
        {
            char curr = answerKey.charAt(right);
            if(curr == ch) right++;
            else
            {
                if(k==0)
                {
                    while(left<=right)
                    {
                        if(answerKey.charAt(left) != ch)
                        {
                            left++;
                            k++;
                            break;
                        }
                        left++;
                    }
                }

                k--;
                right++;
            }

            ans = Math.max(ans , right-left);
        }

        return ans;
    }
}