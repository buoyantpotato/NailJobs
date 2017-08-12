/**
 * Created by linzhou on 8/11/17.
 */
public class P235_LCAofBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        sol1(root, p, q);
        return sol2(root, p, q);
    }

    // Time O(n)
    private TreeNode sol1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }

        if (root == p) {
            return p;
        }
        if (root == q) {
            return q;
        }

        TreeNode left = sol1(root.left, p, q);
        TreeNode right = sol1(root.right, p, q);

        if (left != null && right == null) {
            return left;
        }
        if (left == null && right != null) {
            return right;
        }
        if (left != null && right != null) {
            return root;
        }

        return null;
    }

    // Time O(1)
    private TreeNode sol2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }

        TreeNode small = p.val <= q.val ? p : q;
        TreeNode large = p.val >= q.val ? p : q;

        TreeNode cur = root;
        while (cur.val < small.val || cur.val > large.val) {
            while (cur.val < small.val) {
                cur = cur.right;
            }
            while (cur.val > large.val) {
                cur = cur.left;
            }
        }

        return cur;
    }
}
