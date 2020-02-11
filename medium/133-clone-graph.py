"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = []):
        self.val = val
        self.neighbors = neighbors
"""
class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if node == None:
            return node
        newNode = Node(node.val, [])
        queue = []
        queue.append(node)
        mapping = {node : newNode}
        while queue:
            curNode = queue.pop(0)
            for neighbor in curNode.neighbors:
                if neighbor not in mapping:
                    mapping[neighbor] = Node(neighbor.val, [])
                    queue.append(neighbor)
                mapping[curNode].neighbors.append(mapping[neighbor])
        return mapping[node]
    
"""
Time Complexity: O(N)
Space O(N)
"""
