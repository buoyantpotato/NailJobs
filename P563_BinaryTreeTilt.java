/**
 * Created by linzhou on 8/17/17.
 */
public class P563_BinaryTreeTilt {
    public int findTilt(TreeNode root) {
        int[] sum = new int[1];
        helper(root, sum);
        return sum[0];
    }

    private int helper(TreeNode node, int[] sum) {
        if (node == null) {
            return 0;
        }

        int left = helper(node.left, sum);
        int right = helper(node.right, sum);
        sum[0] += Math.abs(left - right);
        return left + right + node.val;
    }
}
