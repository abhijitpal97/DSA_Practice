package com.example.gspractice;

public class StringCompression {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int n = chars.length;
        for(int i = 0;i<n;i++)
        {
            char ch = chars[i];
            int count = 0;
            while(chars[i] == ch)
            {
                i++;
                count++;
                if(i>=n) break;
            }
            sb.append(ch).append(count);
            i--;
        }
        System.out.println(sb.toString());
        return sb.length()/2 == n ? n : sb.length();
    }
}