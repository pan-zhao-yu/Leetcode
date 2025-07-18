class Trie {
    class Node{
        char c;
        boolean isEnd;
        Node[] next;
        public Node(char c, Node[] next){
            this.c = c;
            this.next = next;
        }
    }
    Node h;
    public Trie() {
        h = new Node('a', new Node[26]);
    }
    
    public void insert(String word) {
        Node temp = h;
        for(char curr : word.toCharArray()){
            if(temp.next[curr - 'a'] == null){
                temp.next[curr - 'a'] = new Node(curr, new Node[26]);
            }
            temp = temp.next[curr - 'a'];
        }
        temp.isEnd = true;
    }
    
    public boolean search(String word) {
        Node temp = h;
        for(char c : word.toCharArray()){
            if(temp.next[c - 'a'] == null) return false;
            temp = temp.next[c - 'a'];
        }    
        return temp.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Node temp = h;
        for(char c : prefix.toCharArray()){
            if(temp.next[c - 'a'] == null) return false;
            temp = temp.next[c - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */