package CodingNinjaPOTD;


// https://www.codingninjas.com/studio/problems/program-to-validate-ip-address_981315

public class ValidIPAddress_Easy1607 {

	static boolean inRange(String s){

		// if string empty

		if(s.length()==0){

			return false;

		}

		int x = Integer.valueOf(s);

		// if string out of range

		if(x>255 || x<0){

			return false;

		}

		return true;

	}

	public static boolean isValidIPv4(String ipAddress) {

		// write your code here

		int count = 0;

		int sq = 0;

		// if initial character is .

		if(ipAddress.charAt(0)=='.'){

			return false;

		}

		for(int i=0;i<ipAddress.length();i++){

			// if ipString contains character

			if(ipAddress.charAt(i)-'0'>10){

				return false;

			}

			// if in range

			if(ipAddress.charAt(i)=='.'){

				count++;

				if(!inRange(ipAddress.substring(sq,i))){

					return false;

				} 

				sq=i+1;

			}

		}

		// if IPv4 having 4 octets.

		if(count!=3){

			return false;

		}

		return true;

	}

	// Using Try - Catch
	public static boolean isValidIPv4WithErrorBlock(String ipAddress) {
		// write your code here
		String[] strs = ipAddress.split("\\.");
		if(strs.length != 4) return false;
		for(String str : strs)
		{
			int i = 0;
			try
			{
				i = Integer.valueOf(str);
			}
			catch(Exception e)
			{
				return false;
			}
			if(i<0 || i>255) return false;
		}

		return true;
	}

}
