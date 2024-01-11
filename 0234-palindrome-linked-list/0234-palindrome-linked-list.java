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
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode mid = head;
        ListNode right = head;
        
        while(right != null && right.next != null){
            mid = mid.next;
            right = right.next.next;
        }
        
        ListNode prev = null;
        ListNode next = null;
        while(mid != null){
            next = mid.next;
            mid.next = prev;
            prev = mid;
            mid = next;
        }
        
        while(prev != null && head != null){
            if(prev.val != head.val) return false;
            prev = prev.next;
            head = head.next;
        }
        return true;
        
        
        
        
        
//         if(head == null || head.next == null){
//             return true;
//         }
//         ListNode left = head, right = head;
//         while(right != null && right.next != null){
//             left = left.next;
//             right = right.next.next;
//         }
        
//         ListNode pre = null, next;
//         while(left != null){
//             next = left.next;
//             left.next = pre;
//             pre = left;
//             left = next;
//         }
        
//         while(pre != null && head != null){
//             if(pre.val != head.val){
//                 return false;
//             }
//             pre = pre.next;
//             head = head.next;
//         }
//         return true;
        
    }
}