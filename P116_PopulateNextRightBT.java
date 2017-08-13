import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by linzhou on 8/12/17.
 */
public class P116_PopulateNextRightBT {

    class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

//        sol1(root);
        sol1(root);
    }

    // Time O(n), Space O(n)
    private void sol1(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int n = queue.size();
            TreeLinkNode prev = null;
            for (int i = 0; i < n; i++) {
                TreeLinkNode node = queue.poll();
                node.next = prev;
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                prev = node;
            }
        }
    }

    // Time O(n), Space O(1), Iteration
    private void sol2(TreeLinkNode root) {
        TreeLinkNode cur = root;
        while (cur != null) {
            TreeLinkNode mostLeft = cur;
            while (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                }
                if (cur.right != null && cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            cur = mostLeft.left;
        }
    }

    // Time O(n), Space O(1), Recursion
    private void sol3(TreeLinkNode root) {
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.right != null && root.next != null) {
            root.right.next = root.next.left;
        }

        connect(root.left);
        connect(root.right);
    }
}
