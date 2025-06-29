package AddTwoNumberLinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Starting with the Case 1, both are equal

        if(l1 == null) {
            return l2;
        }

        if(l2 == null) {
            return l1;
        }

        ListNode ansHead = null;
        ListNode ansTail = null;
        int carry = 0;
        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            int digit = sum % 10; // which is remainder hence % used
            carry = sum / 10;  // which is quotient hence / is used

            ListNode newNode = new ListNode(digit);

            if(ansHead == null) {
                ansHead = newNode;
                ansTail = newNode;
            }
            else {
                ansTail.next = newNode;
                ansTail = newNode;
            }

            l1 = l1.next;
            l2 = l2.next;
        }


        // Second case head1 is longer
        while(l1 != null) {
            int sum = l1.val + carry;
            int digit = sum % 10; // which is remainder hence %
            carry = sum / 10; // which is quotient hence /

            ListNode newNode = new ListNode(digit);

            ansTail.next = newNode;
            ansTail = newNode;

            l1 = l1.next;
        }

        // Third case head2 is longer
        while(l2 != null) {
            int sum = l2.val + carry;
            int digit = sum % 10; // which is remainder hence %
            carry = sum / 10; // which is quotient hence /

            ListNode newNode = new ListNode(digit);

            ansTail.next = newNode;
            ansTail = newNode;

            l2 = l2.next;
        }

        // Fourth case carry forward values

        while(carry != 0) {
            int sum = carry;
            int digit = sum % 10;
            carry = sum /10;

            ListNode newNode = new ListNode(digit);

            ansTail.next = newNode;
            ansTail = newNode;
        }

        return ansHead;
    }
}
