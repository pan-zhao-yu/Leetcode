class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Create a dummy node to handle the head manipulation easily
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = head;
        int len = 0;
        
        // Calculate the length of the list
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        
        // prevTail points to the last node of the previously reversed part
        ListNode prevTail = dummy;
        
        // Reverse in groups of k
        while (len >= k) {
            ListNode start = prevTail.next;  // The first node of the current k-group
            ListNode nextFirst = start;      // This will move to k nodes ahead
            for (int i = 0; i < k; i++) {
                nextFirst = nextFirst.next;
            }
            
            // Reverse the k-group
            ListNode prev = nextFirst;       // Initially, the nextFirst is where the reversed group should point to
            ListNode curr = start;           // Start reversing from the current start node
            for (int i = 0; i < k; i++) {
                ListNode next = curr.next;   // Save next node
                curr.next = prev;            // Reverse current node's pointer
                prev = curr;                 // Move prev to current
                curr = next;                 // Move to next node
            }
            
            // Connect the previous part to the reversed group
            prevTail.next = prev;
            prevTail = start;   // After reversing, start is now the tail of the reversed group
            
            len -= k;  // Reduce the length by k since we've reversed a group
        }
        
        return dummy.next;
    }
}
