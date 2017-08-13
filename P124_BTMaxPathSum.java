/**
 * Created by linzhou on 8/13/17.
 */
public class P124_BTMaxPathSum {
    public int maxPathSum(TreeNode root) {

        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        
        int num = helper(root, max);
        return Math.max(num, max[0]);

    }

    private int helper(TreeNode node, int[] max) {
        if (node == null) {
            return 0;
        }

        int left = Math.max(0, helper(node.left, max));
        int right = Math.max(0, helper(node.right, max));
        max[0] = Math.max(max[0], node.val + left + right);

        return node.val + Math.max(left, right);
    }
}
