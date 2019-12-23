package leetcode.enter;

/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 */
public class MinimalDepthBST {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null) {
            return 1 + minDepth(root.right);
        } else if (root.right == null) {
            return 1 + minDepth(root.left);
        }

        int right = minDepth(root.right);
        int left = minDepth(root.left);

        return Math.min(right, left) + 1;
    }
}
