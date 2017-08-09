import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by linzhou on 5/13/17.
 */
public class P148_SortLinkedList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        ListNode headCur = new ListNode(0);
        ListNode tailCur = new ListNode(0);
        headCur.next = head;
        tailCur.next = tail;
        sortListHelper(headCur, tailCur);

        return headCur.next;
    }

    private void sortListHelper(ListNode headCur, ListNode tailCur) {

        ListNode prev = headCur.next;
        ListNode later = tailCur.next;

        int pivot = headCur.next.val;

        Arrays.sort(new int[2]);
    }

    private void print(ListNode node) {
        ListNode cur = node;
        while (cur.next != null) {
            System.out.print(cur.next.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
