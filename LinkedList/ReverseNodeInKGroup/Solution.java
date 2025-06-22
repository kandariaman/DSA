package ReverseNodeInKGroup;

class ListNode {
     int val;
     ListNode next;

     ListNode() {
     }

     ListNode(int val) {
         this.val = val;
     }

     ListNode(int val, ListNode next) {
         this.val = val;
         this.next = next;
     }
 }

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) {
            return head;
        }
        int length = size(head);
        if(k > length) {
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = head.next;
        for(int i = 0; i<=k-1; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        if(next != null) {
            head.next = reverseKGroup(next, k);
        }
        return prev;
    }

    int size(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}