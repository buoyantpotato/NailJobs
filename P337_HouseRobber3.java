import java.util.HashMap;
import java.util.Map;

/**
 * Created by linzhou on 8/22/17.
 */
public class P337_HouseRobber3 {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Map<TreeNode, Integer> cache = new HashMap<>();
        helper1(root, cache);

        int[] max = helper2(root);
        return Math.max(max[0], max[1]);
    }

    // Time O(n), Space O(1)
    private int helper1(TreeNode node, Map<TreeNode, Integer> cache) {
        if (node == null) {
            return 0;
        }
        if (cache.containsKey(node)) {
            return cache.get(node);
        }

        int thisVal = node.val;
        int leftVal = 0, rightVal = 0, leftChildVal = 0, rightChildVal = 0;
        if (node.left != null) {
            leftVal = helper1(node.left, cache);
            leftChildVal = helper1(node.left.left, cache) + helper1(node.left.right, cache);
        }
        if (node.right != null) {
            rightVal = helper1(node.right, cache);
            rightChildVal = helper1(node.right.left, cache) + helper1(node.right.right, cache);
        }

        int opt = Math.max(thisVal + leftChildVal + rightChildVal, leftVal + rightVal);
        cache.put(node, opt);

        return opt;
    }


    // Time O(n), Space O(1)
    private int[] helper2(TreeNode node) {
        int[] res = {0, 0};
        if (node == null) {
            return res;
        }

        int[] left = helper2(node.left);
        int[] right = helper2(node.right);
        res[0] = node.val + left[1] + right[1];
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return res;
    }
}
