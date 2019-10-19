package enter;

/**
 * Given a Binary Search Tree (BST).
 *
 * Convert it to a Greater Tree such that every key of the original BST is changed
 * to the original key plus sum of all keys greater than the original key in BST.
 *
 * Input: The root of a Binary Search Tree like this:
 *               5
 *             /   \
 *            2     13
 *
 * Output: The root of a Greater Tree like this:
 *              18
 *             /   \
 *           20     13
 */

public class ConvertTree {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        convertBSTHelper(root, 0);
        return root;
    }

    public int convertBSTHelper(TreeNode root, int current) {
        if (root == null) {
            return current;
        }

        int rightValue = convertBSTHelper(root.right, current);
        root.val += (rightValue + current);
        int leftValue = convertBSTHelper(root.left, root.val);

        return leftValue;
    }
}
