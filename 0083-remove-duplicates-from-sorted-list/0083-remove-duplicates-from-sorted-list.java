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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode result = head;
        while(result != null){
            if(result.next == null){
                break;
            }
            if(result.val == result.next.val){
                result.next = result.next.next;
                
            }else{
                result = result.next;
            }
        }
        return head;
    }
}