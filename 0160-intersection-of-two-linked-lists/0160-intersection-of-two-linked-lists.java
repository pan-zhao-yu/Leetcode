/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ha = headA, hb = headB;
        while(ha != hb){
            if(ha == null){
                ha = headB;
            }else{
                ha = ha.next;
            }
            if(hb == null){
                hb = headA;
            }else{
                hb = hb.next;
            }
        }
        return ha == hb ? ha : null;
    }
}