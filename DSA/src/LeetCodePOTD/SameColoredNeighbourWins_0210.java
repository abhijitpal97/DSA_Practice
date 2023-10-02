package LeetCodePOTD;

// https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/description/

public class SameColoredNeighbourWins_0210 {
	public boolean winnerOfGame(String colors) {
		int n = colors.length();
		int alice = 0;
		int bob = 0;
		for(int i =1 ; i<n-1;i++)
		{
			char prev = colors.charAt(i-1);
			char curr = colors.charAt(i);
			int next = colors.charAt(i+1);
			if(prev == 'A' && curr == 'A' && next=='A') alice++;
			else if(prev == 'B' && curr == 'B' && next=='B') bob++;
		}

		return alice>bob?true:false;
	}
}