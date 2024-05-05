class ListNode{
    ListNode back;
    ListNode forward;
    String url;
    public ListNode(String url){
        this.url = url;
        back = forward = null;
    }
}
class BrowserHistory {
    ListNode head;
    ListNode curr;
    
    public BrowserHistory(String homepage) {
        head = new ListNode(homepage);
        curr = head;
    }
    
    public void visit(String url) {
        curr.forward = new ListNode(url);
        curr.forward.back = curr;
        curr = curr.forward;
    }
    
    public String back(int steps) {
        while(steps > 0 && curr.back != null){
            curr = curr.back;
            steps--;
        }
        return curr.url;
    }
    
    public String forward(int steps) {
        while(steps > 0 && curr.forward != null){
            curr = curr.forward;
            steps--;
        }
        return curr.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */