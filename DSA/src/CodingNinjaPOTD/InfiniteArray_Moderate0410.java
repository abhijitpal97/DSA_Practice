package CodingNinjaPOTD;
import java.util.*; 

// https://www.codingninjas.com/studio/problems/boolean-queries_2271421?leftPanelTab=0

public class InfiniteArray_Moderate0410 {
	boolean[] statusList;
	InfiniteArray_Moderate0410() {
		statusList = new boolean[1000001];
	}

	void setAllTrue() {
		// Implement the function here 
		Arrays.fill(statusList , true);
	}

	void setAllFalse() {
		// Implement the function here
		Arrays.fill(statusList , false);
	}

	void setIndexTrue(int index) {
		// Implement the function here
		statusList[index] = true;	 
	}

	void setIndexFalse(int index) {
		// Implement the function here	
		statusList[index] = false;	 
	}

	boolean getIndex(int index) {
		// Implement the function here
		return statusList[index];
	}

}
