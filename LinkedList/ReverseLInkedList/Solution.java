package ReverseLInkedList;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        return reverseListRE(null, head);
    }

    public ListNode reverseListRE(ListNode prev, ListNode curr) {
        if(curr == null) {
            return prev;
        }
        ListNode right = curr.next;

        curr.next = prev;

        return reverseListRE(curr,right);
    }
}
