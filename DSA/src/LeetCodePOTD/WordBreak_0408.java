package LeetCodePOTD;

import java.util.*;

public class WordBreak_0408 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String,Boolean> map = new HashMap<>();
        return function(s , wordDict,map);
    }

    boolean function(String str , List<String> wordDict , Map<String,Boolean> map )
    {
        if(str.length() == 0) return true;
        if(map.containsKey(str)) return map.get(str);

            for(String li : wordDict)
            {
                if(str.indexOf(li) == 0)
                {
                    if(function(str.substring(li.length()) , wordDict , map))
                    {
                        map.put(str , true);
                        return true;
                    }
                }
            }

            map.put(str , false);
            return false;
    }
}