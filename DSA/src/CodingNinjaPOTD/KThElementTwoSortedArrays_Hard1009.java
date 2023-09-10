package CodingNinjaPOTD;

public class KThElementTwoSortedArrays_Hard1009 {
    public static int ninjaAndLadoos(int row1[], int row2[], int m, int n, int k) {
        // Write your code here.
        if(k>m+n) return -1;

        int i=0;
        int j=0;
        while(i<m && j<n && k>1)
        {
            if(row1[i]<row2[j]) i++;
            else j++;
            k--;
        }
        if(i<m && j<n && k==1)
        {
            if(row1[i]<row2[j]) return row1[i];
            else return row2[j];
        }

        while(i<m && k>1)
        {
            i++;
            k--;
            if(k == 1) return row1[i];
        }

        while(j<n && k>1)
        {
            j++;
            k--;
            if(k == 1) return row2[j];
        }

        if(i<m && k==1) return row1[i];
        if(j<n && k==1) return row2[j];

        return -1;
    }
}
