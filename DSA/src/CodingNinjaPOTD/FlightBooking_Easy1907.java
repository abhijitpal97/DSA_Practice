package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class FlightBooking_Easy1907 {
    public static ArrayList < Integer > corpFlightBookings(ArrayList < ArrayList < Integer >> bookings, int n) {
        // Write your code here.
        int[] result = new int[n];

        for(int i = 0 ;i<bookings.size() ; i++)
        {
            ArrayList<Integer> list = bookings.get(i);
            for(int j =  list.get(0); j<= list.get(1) ; j++) result[j-1] += list.get(2);
        }
        

        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++) res.add(result[i]);

        return res;
    }
}