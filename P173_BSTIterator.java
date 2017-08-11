import java.util.Stack;

/**
 * Created by linzhou on 8/10/17.
 */
public class P173_BSTIterator {

    private Stack<TreeNode> stack;

    public P173_BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        loadLeft(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !this.stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = this.stack.pop();
        if (node.right != null) {
            loadLeft(node.right);
        }
        return node.val;
    }

    private void loadLeft(TreeNode node) {
        TreeNode cur = node;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
    }

}
