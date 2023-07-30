package com.example.microsoftpractice;

import java.util.*;

class WordLadderPair
{
    String word;
    int count;
    
    WordLadderPair(String word , int count)
    {
        this.word = word;
        this.count = count;
    }
}

public class WordLadder
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        if(startWord.equals(targetWord)) return 0;
        List<String> wordLists = new ArrayList<>();
        for(String str : wordList) wordLists.add(str);
        
        Queue<WordLadderPair> queue = new LinkedList<>();
        queue.offer(new WordLadderPair(startWord , 1));
        wordLists.remove(startWord);
        
        while(! queue.isEmpty())
        {
            WordLadderPair currP = queue.poll();
            String currStr = currP.word;
            int count = currP.count;
            if(currStr.equals(targetWord)) return count;
            for(int i = 0; i <currStr.length();i++)
            {
                for(char ch = 'a' ; ch<='z'; ch++)
                {
                    char[] charArray = currStr.toCharArray();
                    charArray[i] = ch;
                    String newStr = new String(charArray);
                    if(wordLists.contains(newStr))
                    {
                        queue.offer(new WordLadderPair(newStr , count+1));
                        wordLists.remove(newStr);
                    }
                }
            }
        }
        
        return 0;
    }
    
}