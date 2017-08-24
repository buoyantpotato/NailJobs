import java.util.HashMap;
import java.util.Map;

/**
 * Created by linzhou on 8/23/17.
 */
public class P663_EqualTreePartition {
    public boolean checkEqualTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return false;
        }

        sol1(root);
        return sol2(root);
    }


    // Time O(n), Space O(n)
    private boolean sol1(TreeNode root) {
        Map<Integer, TreeNode> cache = new HashMap<>();
        int sum = helper1(root, cache);
        return sum % 2 == 0 && cache.get(sum / 2) != null;
    }
    private int helper1(TreeNode node, Map<Integer, TreeNode> cache) {
        if (node == null) {
            return 0;
        }

        int left = helper1(node.left, cache);
        int right = helper1(node.right, cache);
        int sum = node.val + left + right;
        cache.put(sum, node);
        return sum;
    }


    // Time O(2n)~O(n), Space O(1)
    private boolean sol2(TreeNode root) {
        int sum = getSum(root);
        if (sum % 2 != 0) {
            return false;
        }

        boolean[] res = new boolean[1];
        helper2(root, sum / 2, res);
        return res[0];
    }

    private int getSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = getSum(node.left);
        int right = getSum(node.right);
        int sum = node.val + left + right;
        return sum;
    }

    private int helper2(TreeNode node, int halfSum, boolean[] res) {
        if (node == null) {
            return 0;
        }

        int left = helper2(node.left, halfSum, res);
        int right = helper2(node.right, halfSum, res);
        int tempSum = node.val + left + right;
        if (tempSum == halfSum) {
            res[0] = true;
        }
        return tempSum;
    }


}
