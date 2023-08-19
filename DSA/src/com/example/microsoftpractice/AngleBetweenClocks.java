package com.example.microsoftpractice;

public class AngleBetweenClocks {
    public double angleClock(int hour, int minutes) {
        //30
        //15
        //

        hour %=12;
        double hrAheadAngle = (hour*30) + ((double)minutes/60)*30; //105
        double minAheadAngle = ((double)minutes/60)*360;//180

        System.out.println(hrAheadAngle + " -" + minAheadAngle);
        double outer = Math.abs(minAheadAngle - hrAheadAngle);
        double inner = 360 - outer;
        return Math.min(outer , inner);

    }
}