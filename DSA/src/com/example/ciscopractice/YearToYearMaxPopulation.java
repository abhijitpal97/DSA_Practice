package com.example.ciscopractice;

public class YearToYearMaxPopulation {
    public int maximumPopulation(int[][] logs) {
        int[] years = new int[101];
        int max = 0;
        int year=0;

        for(int i=0;i<logs.length;i++)
        {
            for(int j = logs[i][0] ; j<logs[i][1] ; j++)
            {
                years[j-1950]++;
            }
        }

        for(int i=0;i<years.length;i++)
        {
            if(years[i]>max)
            {
                max = years[i];
                year = i+1950;
            }
        }
        return year;
    }
}