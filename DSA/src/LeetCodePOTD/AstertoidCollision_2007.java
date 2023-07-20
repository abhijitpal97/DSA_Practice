package LeetCodePOTD;

import java.util.Stack;

public class AstertoidCollision_2007 {
    public int[] asteroidCollision(int[] asteroids) {
        if(asteroids.length == 1) return asteroids; 
        Stack<Integer> stack = new Stack<>();
        int i = 1;
        stack.push(asteroids[0]);

        while(i<asteroids.length)
        {
            if(stack.isEmpty() || i<asteroids.length && ! (stack.peek() > 0 && asteroids[i]<0))
            {
                stack.push(asteroids[i++]);
                continue;
            }
            else if(-asteroids[i]>stack.peek())
            {
                stack.pop();
                continue;
            }
            else if(asteroids[i]+stack.peek() == 0)
            {
                stack.pop();
                i++;
                continue;
            }
            else i++;
        }

        int[] ans = new int[stack.size()];
        int index = stack.size();
        while(! stack.isEmpty())
        {
            ans[--index] = stack.pop();
        }

        return ans;
        
    }
}