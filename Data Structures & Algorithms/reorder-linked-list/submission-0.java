/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public void reorderList(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode curr = slow.next;
        ListNode next = slow.next;
        ListNode prev = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        slow.next = prev;
        ListNode p = head;

        ListNode second = slow.next;
        slow.next = null;

        ListNode temp = head;
        while (second != null) {
            next = temp.next;
            temp.next = second;
            second = second.next;
            temp = temp.next;
            temp.next = next;
            temp = temp.next;
        }

    }
}