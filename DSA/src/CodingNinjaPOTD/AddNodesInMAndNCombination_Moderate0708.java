package CodingNinjaPOTD;

import com.example.datastructure.skeleton.LinkedListNode;
// https://www.codingninjas.com/studio/problems/append-nodes_763407

public class AddNodesInMAndNCombination_Moderate0708 {

    public static LinkedListNode addNodes(LinkedListNode head, int n, int m) {
        // Write your code here.
        LinkedListNode node = head;
        int counter = m;
        while(head != null)
        {
            while(head != null && counter>0) 
            {
                head = head.next;
                counter--;
            }
            if(head!=null)
            {
                int sum =0 ;
                int move = n;
                while(head != null && move>0)
                {
                    sum +=head.val;
                    move--;
                    if(head.next == null) break;
                    if(move>0) head = head.next;
                }
                LinkedListNode temp = head.next;
                head.next = new LinkedListNode(sum);
                head.next.next = temp;
                head = head.next.next;
               
            }
            counter = m;
        }

        return node;
    }
}