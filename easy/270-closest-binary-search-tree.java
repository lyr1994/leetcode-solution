/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return -1;
        }
        TreeNode lowerNode = lowerBound(root, target);
        TreeNode upperNode = upperBound(root, target);
        if (lowerNode == null) {
            return upperNode.val;
        }
        if (upperNode == null) {
            return lowerNode.val;
        }
        if (target - lowerNode.val < upperNode.val - target) {
            return lowerNode.val;
        }
        return upperNode.val;
    }
    
    private TreeNode lowerBound(TreeNode root, double target) {
        if (root == null) {
            return root;
        }
        if (root.val >= target) {
            return lowerBound(root.left, target);
        }
        TreeNode lowerNode = lowerBound(root.right, target);
        if (lowerNode != null) {
            return lowerNode;
        }
        return root;
    }
    
    private TreeNode upperBound(TreeNode root, double target) {
        if (root == null) {
            return root;
        }
        if (root.val < target) {
            return upperBound(root.right, target);
        }
        TreeNode upperNode = upperBound(root.left, target);
        if (upperNode != null) {
            return upperNode;
        }
        return root;
    }
}
