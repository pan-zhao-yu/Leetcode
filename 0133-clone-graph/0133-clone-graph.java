/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        /*
        dfs /bfs to traverse the original graph and create copy and its neighbors.
        maintain a map to keep track of visited nodes and their clones.
        use map will help avoiding cycles and revisiting nodes.
        
        */
        if(node == null) return null;
        if(visited.containsKey(node)) return visited.get(node);
        Node cloneNode = new Node(node.val);
        visited.put(node, cloneNode);
        
        for(Node neighbor : node.neighbors){
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }
}