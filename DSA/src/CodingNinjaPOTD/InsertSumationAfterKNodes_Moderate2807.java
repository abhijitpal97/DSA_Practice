package CodingNinjaPOTD;

import com.example.datastructure.skeleton.LinkedListNode;

public class InsertSumationAfterKNodes_Moderate2807 {
	public static LinkedListNode getListAfterAddingLinkedListNodes(LinkedListNode head, int k) {
        // Write your code here.
        if(head == null) return null;
        if(head.next == null)
        {
            head.next = new LinkedListNode(head.val);
            return head;
        }
        
        LinkedListNode result = head;
        LinkedListNode temp = result;
        int counter = k;

        int sum = 0;
        while(temp.next != null && counter>0)
        {
            sum += temp.val;
            counter--;
            if(counter == 0)
            {
                LinkedListNode x = temp.next;
                temp.next = new LinkedListNode(sum);
                temp = temp.next;
                temp.next = x;
                sum = 0;
                counter = k; 
            }
            temp = temp.next;
            if(temp.next == null)
            {
                sum += temp.val;
                temp.next = new LinkedListNode(sum);
                temp = temp.next;
            }
        }
        return result;
    }
}