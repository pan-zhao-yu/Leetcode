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
    public ListNode swapNodes(ListNode head, int k) {
        
        ListNode left = head, right = head, temp = head;
        
        while(k > 1){
            temp = temp.next;
            right = right.next;
            k--;
        }
        right = right.next;
        while(right != null){
            right = right.next;
            left = left.next;
        }
        
        int val = temp.val;
        temp.val = left.val;
        left.val = val;
        
        return head;
        
    }
}