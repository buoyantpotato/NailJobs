import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by linzhou on 2016/11/29.
 */

public class GG_OA_BSTSubset {

    private static int max;
    public static int solution(int A, int B, TreeNode T) {
        // write your code in Java SE 8
        if (T == null) {
            return 0;
        }

        max = 0;
        countNum(A, B, T);
        return max >= 0 ? max : 0;
    }

    private static int countNum(int A, int B, TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftCount = (node.left != null) ? countNum(A, B, node.left) : 0;
        int rightCount = (node.right != null) ? countNum(A, B, node.right) : 0;
        int thisCount = (A <= node.val && node.val <= B) ? 1 : -1;

        if (leftCount >= 0 && rightCount >= 0 && thisCount >= 0) {
            int count = leftCount + rightCount + thisCount;
            max = Math.max(max, count);
            return count;
        } else {
            return -1;
        }
    }

    public static void printTreeInLevelOrder (TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int numOfNext = 0;
        int numOfThis = 1;
        List<Integer> list = new ArrayList<>();
        while (queue.size() != 0) {
            TreeNode node = queue.poll();
            list.add(node.val);

            if (node.left != null) {
                queue.add(node.left);
                numOfNext++;
            }
            if (node.right != null) {
                queue.add(node.right);
                numOfNext++;
            }

            if (numOfThis == list.size()) {
                System.out.println(list.toString());
                numOfThis = numOfNext;
                numOfNext = 0;
                list = new ArrayList<>();
            }
        }
    }

    public static void main(String[] args) {
        //TreeGenerator tree = new TreeGenerator("25,19,37,12,22,29,null,4,null,null,23,null,30");
        TreeGenerator tree = new TreeGenerator("3,1,100");
        TreeNode root = tree.getHead();
        printTreeInLevelOrder(root);
        System.out.println(solution(1, 37, root));
    }
}
