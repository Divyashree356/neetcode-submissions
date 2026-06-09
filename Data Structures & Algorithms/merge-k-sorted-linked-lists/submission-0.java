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
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode ans = new ListNode(0);
        ListNode temp = ans;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                temp.next = l1;
                l1 = l1.next;
            }else{
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        temp.next = l1 != null ? l1 : l2;
        return ans.next;
    }

    public ListNode mergeSort(ListNode[] lists, int left, int right){
        if(left == right) return lists[left];
        int mid = left + (right-left)/2;

        ListNode l1 = mergeSort(lists, left , mid);
        ListNode l2 = mergeSort(lists, mid+1 , right);

        return merge(l1, l2);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 1) return lists[0];
        if (lists.length == 0) return null;

        return mergeSort(lists, 0, lists.length -1);
    }
}