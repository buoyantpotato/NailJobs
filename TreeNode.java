import java.util.Objects;

/**
 * Created by linzhou on 2016/11/29.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public String str;

    public TreeNode(int v) {
        val = v;
    }

//    @Override
//    public boolean equals(Object o) {
//        TreeNode t = (TreeNode) o;
//        return t.str.equals(this.str);
//    }

    @Override
    public int hashCode() {
        return 1;
    }
}
