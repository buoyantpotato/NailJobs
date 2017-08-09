import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by linzhou on 2016/11/29.
 */
public class TreeGenerator {

    private static final PrintStream ps = System.out;

    TreeNode head;

    public TreeGenerator(String str) {
        String[] list = str.split(",");
        head = new TreeNode(Integer.parseInt(list[0]));
        //TreeNode cursor = head;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        TreeNode node = null;

        int i = 1;
        while (i < list.length) {
            node = queue.remove();

            if (node == null) {
                continue;
            }

            if (!list[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(list[i]));
                queue.add(node.left);
                i++;
            }
            else {
                queue.add(null);
                i++;
            }

            if (!list[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(list[i]));
                queue.add(node.right);
                i++;
            }
            else {
                queue.add(null);
                i++;
            }

            //printNode(node);
        }

    }

    public TreeNode getHead() {
        return this.head;
    }

    private void printNode(TreeNode node) {
        if (node == null) {
            ps.print("null");
        }
        else {
            ps.print(node.val);
            if (node.left == null) {
                ps.print("  Left:null");
            }
            else {
                ps.print("  Left:" + node.left.val);
            }

            if (node.right == null) {
                ps.print("  Right:null");
            }
            else {
                ps.print("  Right:" + node.right.val);
            }
        }

        ps.println();
    }

    public static void main(String[] args) {
        String str = "1,2,3,null,5,null,6,7,8,null,null,9,10,11,12";
        String[] list = str.split(",");

        TreeGenerator tree = new TreeGenerator(str);
        ps.println(tree.getHead().toString());

    }

}
