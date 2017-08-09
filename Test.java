/**
 * Created by linzhou on 5/13/17.
 */
public class Test {
    public static void main(String[] args) {
        P148_SortLinkedList p148 = new P148_SortLinkedList();
        int[] arr = {12,26,36,1,26,35,24,8,7,5};
        ListNode node = ListNode.generateList(arr);

        p148.sortList(node);
    }
}
