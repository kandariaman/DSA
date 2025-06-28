package Linked_List_Cycle2;

  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null) {
            fast = fast.next;

            if(fast != null) {
                fast = fast.next;
                slow = slow.next;
            }

            if(fast == slow) {
                // First we found out that we are in loop

                // Now we are checking the starting index
                slow = head;
                int index = 0;
                while(slow != fast) {
                    index += 1;
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }
}
