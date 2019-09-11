/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        return cloneMap(node, map);
    }
    
    private Node cloneMap(Node node, Map<Node, Node> map) {
        Node newNode = new Node(node.val, new LinkedList<>());
        map.put(node, newNode);
        for (Node neighbor : node.neighbors) {
            if (!map.containsKey(neighbor)) {
                cloneMap(neighbor, map);
            }
            newNode.neighbors.add(map.get(neighbor));
        }
        return newNode;
    }
}
