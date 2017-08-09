import java.util.List;

/**
 * Created by linzhou on 5/13/17.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

    public static ListNode generateList(int[] vals) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int i = 0; i < vals.length; i++) {
            ListNode node = new ListNode(vals[i]);
            cur.next = node;
            cur = cur.next;
        }

        return dummy.next;
    }
}
