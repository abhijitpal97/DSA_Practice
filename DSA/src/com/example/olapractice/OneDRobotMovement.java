package com.example.olapractice;

public class OneDRobotMovement{
    public static String moveRobots(String s1, String s2){
        //code here
        int i = 0;
        int j = 0; 
        int n = s1.length();
        
        while(i<n && j<n)
        {
            if(s1.charAt(i) == '#') i++;
            
            else if(s2.charAt(j) == '#') j++;
            
            else if(s1.charAt(i) != s2.charAt(j)) return "No";
            
            else if(s1.charAt(i) == 'B' && s2.charAt(j) == 'B' && i>j) return "No";
            
            else if(s1.charAt(i) == 'A' && s2.charAt(j) == 'A' && i<j) return "No";
            
            else
            {
                i++;
                j++;
            }
        }
        
        return "Yes";
    }
}
