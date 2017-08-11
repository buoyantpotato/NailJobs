/**
 * Created by linzhou on 8/10/17.
 */
public class P226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        root.left = invertTree(root.left);
        root.right = invertTree(root.right);

        TreeNode temp = new TreeNode(0);
        temp.left = root.left;
        root.left = root.right;
        root.right = temp.left;

        return root;
    }
}
