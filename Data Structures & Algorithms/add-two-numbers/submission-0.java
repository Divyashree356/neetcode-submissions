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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode ans = new ListNode(0);
        ListNode sum = ans;

        int c = 0;

        while (l1 != null && l2 != null) {
            int s = l1.val + l2.val + c;

            c = s / 10;
            s = s % 10;

            ListNode newNode = new ListNode(s);
            sum.next = newNode;
            sum = sum.next;
            l1 = l1.next;
            l2 = l2.next;

        }

        while (l1 != null) {
            int s = l1.val + c;
            c = s / 10;
            s = s % 10;

            ListNode newNode = new ListNode(s);
            sum.next = newNode;
            sum = sum.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int s = l2.val + c;
            c = s/10;
            s =s %10;

            ListNode newNode = new ListNode(s);
            sum.next = newNode;
            sum = sum.next;
            l2 = l2.next;
        }

        if(c != 0) {
            ListNode newNode = new ListNode(c);
            sum.next = newNode;

        }
        return ans.next;
    }
}