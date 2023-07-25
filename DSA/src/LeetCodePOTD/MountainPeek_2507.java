package LeetCodePOTD;

public class MountainPeek_2507 {
    public int peakIndexInMountainArray(int[] arr) {
        
        int i = 0 ;
        int j = arr.length -1 ;
        while(i<=j)
        {
            int mid = i+ (j-i)/2;
            if((mid==0 || arr[mid-1]<arr[mid]) && (mid == arr.length-1 || arr[mid+1]<arr[mid])) return mid;
            else if(mid>0 && arr[mid-1]>arr[mid]) j = mid-1;
            else i = mid+1;
        }
        return -1;
    }
}