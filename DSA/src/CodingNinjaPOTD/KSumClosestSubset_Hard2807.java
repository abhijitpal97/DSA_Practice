package CodingNinjaPOTD;

public class KSumClosestSubset_Hard2807 {
    static int maxSum = Integer.MIN_VALUE;
    public static int kSumSubset(int[] array, int k) {

        // Write your code here..
        maxSum = Integer.MIN_VALUE;
        maxSum(array , 0 , array.length , k , 0);

        return maxSum;
    }

    static void maxSum(int[] array , int index , int n , int k , int sum)
    {
        if(sum<=k)
        {
            maxSum = Math.max(maxSum , sum);
        }
        if(sum>k) return;
        if(index>=n) return;

        maxSum(array , index+1 , n , k , sum+array[index]);
        maxSum(array , index+1 , n , k , sum);
    }

}