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
    public void reverse(ListNode head){
        ListNode next = head;
        ListNode prev = null;
        while(head != null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        // return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null) return head;
        if (k == 1) return head;

        ListNode temp = head;
        ListNode ans = head;
        ListNode lastTail = ans;

        while(true){
            
            ListNode curNode = temp;
            ListNode kthNode = temp;

            int count = 1;
            while(count < k && kthNode != null){
                kthNode = kthNode.next;
                count++;
            }

            if (kthNode == null) {
                lastTail.next = temp;
                break;
            }

            temp = kthNode.next;
            kthNode.next = null;
            
            reverse(curNode);
            lastTail.next = kthNode;
            lastTail = curNode;

            if(ans == head) ans = kthNode;

        }
        return ans;
    }
}