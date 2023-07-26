package LeetCodePOTD;

public class MinSpeedBeforeTime_2607 {
    public int minSpeedOnTime(int[] dist, double hour) {
        int low = 1;
        int high = (int)1e7;
        int minSpeed = -1;

        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(isPossible(dist , hour ,mid))
            {
                minSpeed = mid;
                high = mid-1;
            }
            else low = mid+1;
        }

        return minSpeed;
    }

    boolean isPossible(int[] dist , double hour ,int speed)
    {
        double hrs = 0;
        for(int i =0 ; i<dist.length;i++)
        {
            double time = (double)dist[i] / speed;
            if(i==dist.length-1) hrs +=time;
            else hrs += Math.ceil(time);
            if(hrs>hour) return false;
        }
        
        return true;
    }
}