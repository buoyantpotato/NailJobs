import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by linzhou on 8/23/17.
 */
public class P515_FindMaxInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        sol1(root);
        return sol2(root);
    }

    // Time O(n), Space O(n)
    private List<Integer> sol1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int count = q.size(), max = Integer.MIN_VALUE;
            while (count != 0) {
                count--;
                TreeNode node = q.poll();
                max = Math.max(max, node.val);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            list.add(max);
        }

        return list;
    }


    // Time O(n), Space O(1)
    private List<Integer> sol2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list, 0);
        return list;
    }

    private void helper(TreeNode node, List<Integer> list, int depth) {
        if (node == null) {
            return;
        }

        if (list.size() == depth) {
            list.add(node.val);
        } else {
            list.set(depth, Math.max(list.get(depth), node.val));
        }

        helper(node.left, list, depth + 1);
        helper(node.right, list, depth + 1);
    }
}
