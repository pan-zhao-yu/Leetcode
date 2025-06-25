class Trie {
    class TrieNode{
        char c;
        TrieNode[] child;
        Boolean isEnd;
        public TrieNode(char c, TrieNode[] child, Boolean isEnd){
            this.c = c;
            this.child = child;
            this.isEnd = isEnd;
        }
    }
    TrieNode root;
    public Trie() {
        root = new TrieNode(' ', new TrieNode[26], false);
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(curr.child[c - 'a'] == null){
                curr.child[c - 'a'] = new TrieNode(c, new TrieNode[26], false);
            }
            curr = curr.child[c - 'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(curr.child[c - 'a'] == null) return false;
            else curr = curr.child[c - 'a'];
        }
        if(curr.isEnd == false) return false;
        else return true;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char c : prefix.toCharArray()){
            if(curr.child[c - 'a'] == null) return false;
            else curr = curr.child[c - 'a'];
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