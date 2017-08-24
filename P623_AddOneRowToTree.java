/**
 * Created by linzhou on 8/23/17.
 */
public class P623_AddOneRowToTree {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null || d <= 0) {
            return root;
        }
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }

        helper(root, v, d);
        return root;
    }

    // Time O(n), Space O(1)
    private void helper(TreeNode node, int v, int d) {
        if (node == null) {
            return;
        }
        if (d == 2) {
            TreeNode newNode = new TreeNode(v);
            newNode.left = node.left;
            node.left = newNode;

            newNode = new TreeNode(v);
            newNode.right = node.right;
            node.right = newNode;
            return;
        }

        helper(node.left, v, d - 1);
        helper(node.right, v, d - 1);
    }
}
