package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

public class ExpanseSubsequence_Moderate2307 {

    public static int expanseOfSubsequences(int[] arr) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<>();
        generateSubsequeunce(arr ,  0 , new ArrayList<>() , result);
        //System.out.println(result);
        int sum = 0 ;
        for(List<Integer> li : result)
        {
            if(li.size() <= 1) continue;
            sum += (li.get(li.size()-1) - li.get(0))%1000000007;
        }

        return sum%1000000007;
    }

    static void generateSubsequeunce(int[] arr , int index , List<Integer> list , List<List<Integer>> result)
    {
        if(index == arr.length)
        {
            List<Integer> temp = new ArrayList<>(list);
            Collections.sort(temp);
            result.add(temp);
            return;
        }
        list.add(arr[index]);
        generateSubsequeunce(arr,index+1,list,result);
        list.remove(list.size()-1);
        generateSubsequeunce(arr,index+1,list,result);
    }
    
}