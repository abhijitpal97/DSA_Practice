package CodingNinjaPOTD;

import com.example.datastructure.skeleton.LinkedListNode;

// https://www.codingninjas.com/studio/problems/add-first-and-second-half_759343

public class LinkedListMiddleAndAddTwoHalevs_Moderate3108 {
	
	public static void main(String[] args)
	{
		LinkedListNode head = new LinkedListNode(9);
//		head.next = new LinkedListNode(1);
//		head.next.next = new LinkedListNode(9);
//		head.next.next.next = new LinkedListNode(9);
//		head.next.next.next.next = new LinkedListNode(2);
//		head.next.next.next.next.next = new LinkedListNode(1);
//		head.next.next.next.next.next.next = new LinkedListNode(9);
//		head.next.next.next.next.next.next.next = new LinkedListNode(9);
		
		LinkedListNode res =  addFirstAndSecondHalf(head);
		StringBuilder sb = new StringBuilder();
		while(res != null)
		{
			sb.append(res.val);
			res = res.next;
		}
		System.out.println(sb);
	}
	
	
	public static LinkedListNode addFirstAndSecondHalf(LinkedListNode head) {
        if(head == null) {
            return null;
        }

        LinkedListNode temp = head;

        // Variable to hold the size of the linked list.
        int len = 0;

        while(temp != null) {
            len++;
            temp = temp.next;
        }

        LinkedListNode head1 = null, head2 = null, cur = null;
        int count = 0;

        temp = head;

        // Extract 1st half of the linked list.
        while(count < (len + 1) / 2) {

            if(head1 == null) {
                head1 = new LinkedListNode(temp.val);
                cur = head1;
            }
            else {
                cur.next = new LinkedListNode(temp.val);
                cur = cur.next;
            }

            temp = temp.next;
            count++;
        }

        cur = null;

        // Extract the 2nd half of the linked list.
        while(temp != null) {
            if(head2 == null) {
                head2 = new LinkedListNode(temp.val);
                cur = head2;
            }
            else {
                cur.next = new LinkedListNode(temp.val);
                cur = cur.next;
            }

            temp = temp.next;
        }

        head1 = reverseList(head1);
        head2 = reverseList(head2);

        LinkedListNode sumHead = addTwoLinkedList(head1, head2);

        while(sumHead != null && sumHead.val == 0) {
            sumHead = sumHead.next;
        }

        // If all the digits in the sum string are zero, return only "0".
        if(sumHead == null) {
            return new LinkedListNode(0);
        }

        return sumHead;
    }

    // Function used to add two linked lists.
    private static LinkedListNode addTwoLinkedList(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode head = null, cur = null;
        int carry = 0;

        while(head1 != null || head2 != null) {
            int sum = carry + head1.val;
            if(head2 != null) {
                sum += head2.val;
            }

            if(sum > 9) {
                sum -= 10;
                carry = 1;
            }
            else {
                carry = 0;
            }

            if(head == null) {
                head = new LinkedListNode(sum);
                cur = head;
            }
            else {
                cur.next = new LinkedListNode(sum);
                cur = cur.next;
            }

            head1 = head1.next;
            if(head2 != null) {
                head2 = head2.next;
            }
        }

        if(carry == 1) {
            cur.next = new LinkedListNode(1);
            cur = cur.next;
        }

        LinkedListNode reverseListHead = reverseList(head);

        return reverseListHead;
    }

    // Function used to reverse the linked list.
    private static LinkedListNode reverseList(LinkedListNode head) {
        LinkedListNode prev = null;

        while(head != null) {
            LinkedListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        return prev;
    }
}