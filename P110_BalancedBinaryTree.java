/**
 * Created by linzhou on 8/11/17.
 */
public class P110_BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return helper(root) >= 0;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = helper(node.left);
        int right = helper(node.right);

        if (left < 0 || right < 0) {
            return -1;
        }

        if (Math.abs(left - right) <= 1) {
            return Math.max(left, right) + 1;
        } else {
            return -1;
        }
    }
}
