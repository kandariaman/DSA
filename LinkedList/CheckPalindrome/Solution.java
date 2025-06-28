package CheckPalindrome;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = head;

        while(fast != null) {
            fast = fast.next;

            if(fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
        }

        ListNode startNodeofReverse = slow;

        ListNode prev = null;
        ListNode curr = startNodeofReverse;
        ListNode next = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode startingOfReverse = prev;

        while(startingOfReverse != null) {
            if(temp.val != startingOfReverse.val) {
                return false;
            } else {
                temp = temp.next;
                startingOfReverse = startingOfReverse.next;
            }
        }
        return true;
    }
}