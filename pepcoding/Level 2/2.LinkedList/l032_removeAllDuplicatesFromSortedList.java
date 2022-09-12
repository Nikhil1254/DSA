import java.util.*;

public class l032_removeAllDuplicatesFromSortedList {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode removeDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(-1), prev = dummy, curr = head;
        prev.next = head;

        while (curr != null) {
            boolean loopRun = false;
            while (curr.next != null && curr.next.val == prev.next.val) {
                curr = curr.next;
                loopRun = true;
            }

            if (!loopRun) {
                prev = prev.next;
                prev.next = curr.next;
            } else
                prev.next = curr.next;

            curr = curr.next;
        }

        return dummy.next;
    }

    // InFput_code===================================================

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode makeList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = makeList(scn.nextInt());

        ListNode ans = removeDuplicates(head);
        printList(ans);
    }
}
