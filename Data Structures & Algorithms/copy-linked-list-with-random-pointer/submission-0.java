/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        Node temp = head;

        while(temp != null){
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }

        temp = head;

        while(temp != null){
            if(temp.random == null) temp.next.random = null;
            else{
             Node random = temp.random;
             temp.next.random = random.next;   
            }
            temp = temp.next.next;
        }

        Node newList = new Node(0);
        Node newTemp = newList;
        temp = head;

        while(temp != null) {
            newTemp.next = temp.next;
            temp.next = temp.next.next;
            newTemp= newTemp.next;
            temp = temp.next;
        }
        
        return newList.next;   
    }
}