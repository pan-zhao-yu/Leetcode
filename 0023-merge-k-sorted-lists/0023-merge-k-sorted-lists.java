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
    public ListNode mergeKLists(ListNode[] lists) {
        return lists.length == 0 ? null : divide(lists, 0, lists.length - 1);
    }
    private ListNode divide(ListNode lists[], int l, int r){
        if(r == l) return lists[r];
        int mid = l + (r - l) / 2;
        ListNode left = divide(lists, l, mid);
        ListNode right = divide(lists, mid + 1, r);
        return sort(left, right);
    }
    private ListNode sort(ListNode l, ListNode r){
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while(l != null && r != null){
            if(l.val < r.val){
                curr.next = l;
                l = l.next;
            }else{
                curr.next = r;
                r = r.next;
            }
            curr = curr.next;
        }
        if(l != null) curr.next = l;
        if(r != null) curr.next = r;
        return dummy.next;
    }
}