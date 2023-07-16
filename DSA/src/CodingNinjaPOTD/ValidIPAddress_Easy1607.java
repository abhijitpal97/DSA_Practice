package CodingNinjaPOTD;


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

}
